package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Pays entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface PaysRepository extends JpaRepository<Pays, Long> {

}
