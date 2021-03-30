package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring Data  repository for the Matiere entity.
 */
@RepositoryRestResource
public interface MatiereRepository extends JpaRepository<Matiere, Long> {


}
