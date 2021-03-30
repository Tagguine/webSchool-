package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Emploi.
 */
@Entity
@Table(name = "emploi")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Emploi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_emplois")
    private Instant dateEmplois;

    @Column(name = "heure")
    private String heure;

    @ManyToOne
    @JsonIgnoreProperties("emplois")
    private Matiere matiere;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Instant getDateEmplois() {
        return dateEmplois;
    }

    public Emploi dateEmplois(Instant dateEmplois) {
        this.dateEmplois = dateEmplois;
        return this;
    }

    public void setDateEmplois(Instant dateEmplois) {
        this.dateEmplois = dateEmplois;
    }

    public String getHeure() {
        return heure;
    }

    public Emploi heure(String heure) {
        this.heure = heure;
        return this;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Emploi matiere(Matiere matiere) {
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
        if (!(o instanceof Emploi)) {
            return false;
        }
        return id != null && id.equals(((Emploi) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Emploi{" +
            "id=" + getId() +
            ", dateEmplois='" + getDateEmplois() + "'" +
            ", heure='" + getHeure() + "'" +
            "}";
    }
}
