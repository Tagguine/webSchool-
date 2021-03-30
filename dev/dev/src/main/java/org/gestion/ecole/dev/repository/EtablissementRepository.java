package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Etablissement;
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
 * Spring Data  repository for the Etablissement entity.
 */
@RepositoryRestResource
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

    @Query(value = "select distinct etablissement from Etablissement etablissement left join fetch etablissement.modules",
        countQuery = "select count(distinct etablissement) from Etablissement etablissement")
    @RestResource(path = "/EtablissementAndModules")
    Page<Etablissement> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct etablissement from Etablissement etablissement left join fetch etablissement.modules")
    @RestResource(path = "/listModulesEtab")
    List<Etablissement> findAllWithEagerRelationships();

    @Query("select etablissement from Etablissement etablissement left join fetch etablissement.modules where etablissement.id =:id")
    @RestResource(path = "/modulesEtab")
    Optional<Etablissement> findOneWithEagerRelationships(@Param("id") Long id);

}
