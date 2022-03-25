package com.obr.facturation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obr.facturation.entities.UtilisateurEntity;
import com.obr.facturation.services.UtilisateursService;

@RestController
@RequestMapping(value  = "/utilisateurs", method = { RequestMethod.GET, RequestMethod.POST })
public class UtilisateursController {
	
	@Autowired
	private UtilisateursService utilisateursService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(utilisateursService.getAll(), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/user_name", method = RequestMethod.GET)
//	public ResponseEntity<?> getByUsername(){
//		return new ResponseEntity<>(utilisateursService.getByUsername("wawa"), HttpStatus.OK);
//	}
	
	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public ResponseEntity<?> add(@RequestBody UtilisateurEntity ue){
//		boolean created = utilisateursService.create(ue);
//		if(created) {
//			return new ResponseEntity<>("Utilisateur cree avec success", HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>("Utilisateur n a pas pu etre cree", HttpStatus.FORBIDDEN);
//		}
//	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UtilisateurEntity ue){
//		boolean updated = utilisateursService.update(id, ue);
//		if(updated) {
//			return new ResponseEntity<>("Utilisateur cree avec success", HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>("Echec de mise a jour", HttpStatus.FORBIDDEN);
//		}
//		
//	}
	
	
	
	@GetMapping("/voir")

	public List<UtilisateurEntity> getUtilisateursModels()
	{
				return utilisateursService.getAll();
	}
	
	@PostMapping("/new")
	public Long ajouterUtilisateurs(@RequestBody UtilisateurEntity users) {
		return utilisateursService.newUtilisateur(users);
	}
	
	@DeleteMapping(path = "{idUser}")
	public void supprimerUtilisateur(@PathVariable("idUser") Long idUser) {
		utilisateursService.supprimerUtilisateur(idUser);
	}
	
	@PutMapping(path = "{idUser}")
	public void modifierUtilisateur(@PathVariable("idUser") Long IdUser,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String token) 
	{
		utilisateursService.modifierUtilisateur(IdUser,username,password,token);
	}

}
