package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Note.
 */
@Entity
@Table(name = "note")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "note")
    private Integer note;

    @Column(name = "appreciation")
    private String appreciation;

    @ManyToOne
    @JsonIgnoreProperties("notes")
    private Etudiant etudiant;

    @ManyToOne
    @JsonIgnoreProperties("notes")
    private Matiere matiere;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getNote() {
        return note;
    }

    public Note note(Integer note) {
        this.note = note;
        return this;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Note appreciation(String appreciation) {
        this.appreciation = appreciation;
        return this;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Note etudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        return this;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Note matiere(Matiere matiere) {
        this.matiere = matiere;
        return this;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Note)) {
            return false;
        }
        return id != null && id.equals(((Note) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Note{" +
            "id=" + getId() +
            ", note=" + getNote() +
            ", appreciation='" + getAppreciation() + "'" +
            "}";
    }
}
