package com.obr.facturation.repositories;

import java.util.Optional;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.obr.facturation.entities.UtilisateurEntity;

public interface UtilisateursRepository extends JpaRepository<UtilisateurEntity, Long> {
	
	//pour que le user name soit unique
	
	Optional<UtilisateurEntity> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	//UtilisateurEntity findByUsername(String username);
	
	//Ou bien on Ecrit la requette
	//@Querry (" SELECT s FROM UtilisateursModel s WHERE s.username = ?1 ")
	/*
	 @Query (" SELECT s FROM UtilisateurEntity s WHERE s.username = :username ")
	  Optional<UtilisateurEntity> findByUsername(@Param("username") String username);
	*/
}
