package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Province entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface ProvinceRepository extends JpaRepository<Province, Long> {

}
