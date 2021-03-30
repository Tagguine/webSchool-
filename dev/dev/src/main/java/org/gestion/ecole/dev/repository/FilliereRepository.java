package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Filliere;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Filliere entity.
 */
@RepositoryRestResource
public interface FilliereRepository extends JpaRepository<Filliere, Long> {

    @Query(value = "select distinct filliere from Filliere filliere left join fetch filliere.modules",
        countQuery = "select count(distinct filliere) from Filliere filliere")
    @RestResource(path = "/filliereAndModules")
    Page<Filliere> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct filliere from Filliere filliere left join fetch filliere.modules")
    @RestResource(path = "/listModulesEtab")
    List<Filliere> findAllWithEagerRelationships();

    @Query("select filliere from Filliere filliere left join fetch filliere.modules where filliere.id =:id")
    @RestResource(path = "/modulesFilliere")
    Optional<Filliere> findOneWithEagerRelationships(@Param("id") Long id);

}
