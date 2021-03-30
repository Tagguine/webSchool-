package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Module.
 */
@Entity
@Table(name = "module")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "theme")
    private Integer theme;

    @Column(name = "designation")
    private String designation;

    @Column(name = "nbre_heure")
    private Integer nbreHeure;

    @OneToMany(mappedBy = "module")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Matiere> matieres = new HashSet<>();


    @ManyToMany(mappedBy = "modules")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Filliere> fillieres = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getTheme() {
        return theme;
    }

    public Module theme(Integer theme) {
        this.theme = theme;
        return this;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public String getDesignation() {
        return designation;
    }

    public Module designation(String designation) {
        this.designation = designation;
        return this;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbreHeure() {
        return nbreHeure;
    }

    public Module nbreHeure(Integer nbreHeure) {
        this.nbreHeure = nbreHeure;
        return this;
    }

    public void setNbreHeure(Integer nbreHeure) {
        this.nbreHeure = nbreHeure;
    }

    public Set<Matiere> getMatieres() {
        return matieres;
    }

    public Module matieres(Set<Matiere> matieres) {
        this.matieres = matieres;
        return this;
    }

    public Module addMatiere(Matiere matiere) {
        this.matieres.add(matiere);
        matiere.setModule(this);
        return this;
    }

    public Module removeMatiere(Matiere matiere) {
        this.matieres.remove(matiere);
        matiere.setModule(null);
        return this;
    }

    public void setMatieres(Set<Matiere> matieres) {
        this.matieres = matieres;
    }


    public Set<Filliere> getFillieres() {
        return fillieres;
    }

    public Module fillieres(Set<Filliere> fillieres) {
        this.fillieres = fillieres;
        return this;
    }


    public void setFillieres(Set<Filliere> fillieres) {
        this.fillieres = fillieres;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Module)) {
            return false;
        }
        return id != null && id.equals(((Module) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Module{" +
            "id=" + getId() +
            ", theme=" + getTheme() +
            ", designation='" + getDesignation() + "'" +
            ", nbreHeure=" + getNbreHeure() +
            "}";
    }
}
