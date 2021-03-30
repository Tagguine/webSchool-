package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Adresse entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
