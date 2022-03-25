package com.obr.facturation.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obr.facturation.entities.UtilisateurEntity;
import com.obr.facturation.repositories.UtilisateursRepository;

@Service
public class UtilisateursService {

	@Autowired
	private final UtilisateursRepository utilisateursRepository;

	public UtilisateursService(UtilisateursRepository utilisateursRepository) {
		super();
		this.utilisateursRepository = utilisateursRepository;
	}

	public List<UtilisateurEntity> getAll() {
		return utilisateursRepository.findAll();
	}

//	public UtilisateurEntity getByUsername(String username) {
//		return this.utilisateursRepository.findByUsername(username);
//	}
//
//	public boolean create(UtilisateurEntity ue) {
//		UtilisateurEntity findByUserName = this.utilisateursRepository.findByUsername(ue.getUsername());
//		boolean exist = findByUserName != null;
//		if (!exist) {
//			utilisateursRepository.save(ue);
//			return true;
//		} else {
//			return false;
//		}
//
//	}


//ajout users et pour verifier si le user name exist deja 
	public Long newUtilisateur(UtilisateurEntity users) {
		Optional<UtilisateurEntity> usersOptional = utilisateursRepository.findByUsername(users.getUsername());
		if (usersOptional.isPresent()) {
			throw new IllegalStateException("Ce Username Existe deja, Choisis un autre");
		}

		return utilisateursRepository.save(users).getId();
	}

	public void supprimerUtilisateur(Long idUser) {

		boolean exists = utilisateursRepository.existsById(idUser);
		if (!exists) {
			throw new IllegalStateException("L'Utilisateur dont l'Id est " + idUser + " n'existe pas");
		}

		utilisateursRepository.deleteById(idUser);
	}

	@Transactional
	public void modifierUtilisateur(Long idUser, String username, String password, String token) {
		UtilisateurEntity utilisateursModel = utilisateursRepository.findById(idUser).orElseThrow(
				() -> new IllegalStateException("L'Utilisateur dont l'Id est " + idUser + " n'existe pas"));
		/*
		 * if (username != null && username.length() > 0 &&
		 * !Objects.equals(utilisateursModel.getUsername(), username) ) {
		 * Optional<UtilisateursModel> utilisateursModelOptional =
		 * utilisateursRepository.findUtilisateursModelByUsername(username);
		 * 
		 * if (utilisateursModelOptional.isPresent()) { throw new
		 * IllegalStateException("Votre UserName a ETE bien Modifier"); }
		 * utilisateursModel.setUsername(username); }
		 */

		if (username != null && username.length() > 0 && !Objects.equals(utilisateursModel.getUsername(), username)) {
			utilisateursModel.setUsername(username);
		}

		if (password != null && password.length() > 0 && !Objects.equals(utilisateursModel.getPassword(), password)) {
			utilisateursModel.setPassword(password);
		}

//		if (token != null && token.length() > 0 && !Objects.equals(utilisateursModel.getToken(), token)) {
//			utilisateursModel.setToken(token);
//		}
	}

}
