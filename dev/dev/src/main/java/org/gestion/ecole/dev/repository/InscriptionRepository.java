package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Inscription entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

}
