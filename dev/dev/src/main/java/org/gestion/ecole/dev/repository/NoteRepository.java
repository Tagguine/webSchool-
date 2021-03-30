package org.gestion.ecole.dev.repository;


import org.gestion.ecole.dev.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data  repository for the Note entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note, Long> {

}
