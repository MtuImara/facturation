package com.obr.facturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obr.facturation.entities.FactureEntity;

public interface FacturesRepository extends JpaRepository<FactureEntity, Long> {

}
