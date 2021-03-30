package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Paiment entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface PaimentRepository extends JpaRepository<Paiment, Long> {

}
