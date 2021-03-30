package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Examin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Examin entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface ExaminRepository extends JpaRepository<Examin, Long> {

}
