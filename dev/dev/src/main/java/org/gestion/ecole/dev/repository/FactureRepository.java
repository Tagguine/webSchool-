package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Facture entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
