package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Examin.
 */
@Entity
@Table(name = "examin")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Examin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_examin")
    private String typeExamin;

    @Column(name = "date_examin")
    private Instant dateExamin;

    @ManyToMany(mappedBy = "examins")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Etudiant> etudiants = new HashSet<>();

    @ManyToMany(mappedBy = "examins")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Matiere> matieres = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeExamin() {
        return typeExamin;
    }

    public Examin typeExamin(String typeExamin) {
        this.typeExamin = typeExamin;
        return this;
    }

    public void setTypeExamin(String typeExamin) {
        this.typeExamin = typeExamin;
    }

    public Instant getDateExamin() {
        return dateExamin;
    }

    public Examin dateExamin(Instant dateExamin) {
        this.dateExamin = dateExamin;
        return this;
    }

    public void setDateExamin(Instant dateExamin) {
        this.dateExamin = dateExamin;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public Examin etudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
        return this;
    }

    public Examin addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
        etudiant.getExamins().add(this);
        return this;
    }

    public Examin removeEtudiant(Etudiant etudiant) {
        this.etudiants.remove(etudiant);
        etudiant.getExamins().remove(this);
        return this;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Set<Matiere> getMatieres() {
        return matieres;
    }

    public Examin matieres(Set<Matiere> matieres) {
        this.matieres = matieres;
        return this;
    }

    public Examin addMatiere(Matiere matiere) {
        this.matieres.add(matiere);
        matiere.getExamins().add(this);
        return this;
    }

    public Examin removeMatiere(Matiere matiere) {
        this.matieres.remove(matiere);
        matiere.getExamins().remove(this);
        return this;
    }

    public void setMatieres(Set<Matiere> matieres) {
        this.matieres = matieres;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Examin)) {
            return false;
        }
        return id != null && id.equals(((Examin) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Examin{" +
            "id=" + getId() +
            ", typeExamin='" + getTypeExamin() + "'" +
            ", dateExamin='" + getDateExamin() + "'" +
            "}";
    }
}
