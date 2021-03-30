package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Region entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface RegionRepository extends JpaRepository<Region, Long> {

}
