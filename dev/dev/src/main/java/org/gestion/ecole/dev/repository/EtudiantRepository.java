package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Etudiant;
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
 * Spring Data  repository for the Etudiant entity.
 */
@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query(value = "select distinct etudiant from Etudiant etudiant left join fetch etudiant.examins",
        countQuery = "select count(distinct etudiant) from Etudiant etudiant")
    @RestResource(path = "/etudiantExamens")
    Page<Etudiant> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct etudiant from Etudiant etudiant left join fetch etudiant.examins")
    @RestResource(path = "/listEtudiantExamens")
    List<Etudiant> findAllWithEagerRelationships();

    @Query("select etudiant from Etudiant etudiant left join fetch etudiant.examins where etudiant.id =:id")
    @RestResource(path = "/getExamensEtudiant")
    Optional<Etudiant> findOneWithEagerRelationships(@Param("id") Long id);

}
