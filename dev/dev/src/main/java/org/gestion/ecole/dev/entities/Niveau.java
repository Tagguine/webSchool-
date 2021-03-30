package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Niveau.
 */
@Entity
@Table(name = "niveau")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "lib_niveau")
    private String libNiveau;

    @ManyToOne
    @JsonIgnoreProperties("niveaus")
    private Inscription inscription;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLibNiveau() {
        return libNiveau;
    }

    public Niveau libNiveau(String libNiveau) {
        this.libNiveau = libNiveau;
        return this;
    }

    public void setLibNiveau(String libNiveau) {
        this.libNiveau = libNiveau;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public Niveau inscription(Inscription inscription) {
        this.inscription = inscription;
        return this;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Niveau)) {
            return false;
        }
        return id != null && id.equals(((Niveau) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Niveau{" +
            "id=" + getId() +
            ", libNiveau='" + getLibNiveau() + "'" +
            "}";
    }
}
