package com.obr.facturation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obr.facturation.entities.ContribuableEntity;

public interface ContribuablesRepository extends JpaRepository<ContribuableEntity, Long> {
	
	//pour que le user name soit unique
	Optional<ContribuableEntity> findContribuablesModelByNif(String nif);

}
