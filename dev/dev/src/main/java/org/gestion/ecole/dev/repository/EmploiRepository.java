package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Emploi entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface EmploiRepository extends JpaRepository<Emploi, Long> {

}
