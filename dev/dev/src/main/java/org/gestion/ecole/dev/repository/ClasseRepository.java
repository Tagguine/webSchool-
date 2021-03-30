package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Classe entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface ClasseRepository extends JpaRepository<Classe, Long> {

}
