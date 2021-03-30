package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Proffeseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Proffeseur entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface ProffeseurRepository extends JpaRepository<Proffeseur, Long> {

}
