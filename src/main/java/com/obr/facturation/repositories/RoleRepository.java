package com.obr.facturation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obr.facturation.entities.LesRoles;
import com.obr.facturation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(LesRoles nom);
}
