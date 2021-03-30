package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Module entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<Module, Long> {

}
