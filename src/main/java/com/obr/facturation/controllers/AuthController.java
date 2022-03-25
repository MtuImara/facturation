package com.obr.facturation.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obr.facturation.entities.LesRoles;
import com.obr.facturation.entities.Role;
import com.obr.facturation.entities.UtilisateurEntity;
import com.obr.facturation.jwt.JwtUtils;
import com.obr.facturation.reponse.Jibu;
import com.obr.facturation.reponse.JwtReponse;
import com.obr.facturation.reponse.MessageReponse;
import com.obr.facturation.reponse.ReponseATout;
import com.obr.facturation.repositories.RoleRepository;
import com.obr.facturation.repositories.UtilisateursRepository;
import com.obr.facturation.request.LoginRequest;
import com.obr.facturation.request.SignupRequest;
import com.obr.facturation.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UtilisateursRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	
//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) 
//	{
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		String jwt = jwtUtils.generateJwtToken(authentication);
//		
//		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
//		List<String> roles = userDetails.getAuthorities().stream()
//				.map(item -> item.getAuthority())
//				.collect(Collectors.toList());
//		return ResponseEntity.ok(new JwtReponse(jwt 
////												 userDetails.getId(), 
////												 userDetails.getUsername(),
////												 roles
//												 ));
//	}
	
	
	@PostMapping("/login")
	  public ResponseEntity<?> authenticateUser(@Valid  @RequestBody LoginRequest loginRequest) throws Exception 
	  {

	    String username = loginRequest.getUsername();
	    String password = loginRequest.getPassword();
	    

	    if (username.isEmpty()) {
	      return new ResponseEntity<>(new ReponseATout("false", "Veuillez fournir le nom d'utilisateur !"), HttpStatus.OK);
	    }

	    if (password.isEmpty()) {
	      return new ResponseEntity<>(new ReponseATout("false", "Veuillez fournir votre mot de passse !"), HttpStatus.OK);
	    }

	    if (password.isEmpty() || username.isEmpty()) {
	      return new ResponseEntity<>(new ReponseATout("false", "Veuillez fournir tout les champs obligatoires  !"),
	          HttpStatus.OK);
	    }

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	    

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);

	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return new ResponseEntity<>(new Jibu<>("True", "Operation reussi !", new JwtReponse(jwt,
	        userDetails.getId(),
	        userDetails.getUsername(),
	        roles
	        )), HttpStatus.OK);
	    
	  }
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageReponse("Error: Username is already taken!"));
			
		}
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Email is already in use!"));
//		}
		// Create new user's account
		UtilisateurEntity user = new UtilisateurEntity(signUpRequest.getUsername(),
				encoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(LesRoles.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(LesRoles.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "mod":
					Role modRole = roleRepository.findByName(LesRoles.ROLE_SEC)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(LesRoles.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageReponse("User registered successfully!"));
	}

}
