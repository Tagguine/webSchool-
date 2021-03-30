package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Niveau entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface NiveauRepository extends JpaRepository<Niveau, Long> {

}
