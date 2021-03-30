package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Bulletin entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface BulletinRepository extends JpaRepository<Bulletin, Long> {

}
