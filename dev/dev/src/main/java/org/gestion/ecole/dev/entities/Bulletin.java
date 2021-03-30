package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Bulletin.
 */
@Entity
@Table(name = "bulletin")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Bulletin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "note")
    private Integer note;

    @Column(name = "designation")
    private String designation;

    @Column(name = "date_debut")
    private Instant dateDebut;

    @Column(name = "date_fin")
    private Instant dateFin;

    @Column(name = "appreciation")
    private String appreciation;

    @ManyToOne
    @JsonIgnoreProperties("bulletins")
    private Etudiant etudiant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Integer getNote() {
        return note;
    }

    public Bulletin note(Integer note) {
        this.note = note;
        return this;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getDesignation() {
        return designation;
    }

    public Bulletin designation(String designation) {
        this.designation = designation;
        return this;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Instant getDateDebut() {
        return dateDebut;
    }

    public Bulletin dateDebut(Instant dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public void setDateDebut(Instant dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Instant getDateFin() {
        return dateFin;
    }

    public Bulletin dateFin(Instant dateFin) {
        this.dateFin = dateFin;
        return this;
    }

    public void setDateFin(Instant dateFin) {
        this.dateFin = dateFin;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Bulletin appreciation(String appreciation) {
        this.appreciation = appreciation;
        return this;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Bulletin etudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        return this;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bulletin)) {
            return false;
        }
        return id != null && id.equals(((Bulletin) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Bulletin{" +
            "id=" + getId() +
            ", note=" + getNote() +
            ", designation='" + getDesignation() + "'" +
            ", dateDebut='" + getDateDebut() + "'" +
            ", dateFin='" + getDateFin() + "'" +
            ", appreciation='" + getAppreciation() + "'" +
            "}";
    }
}
