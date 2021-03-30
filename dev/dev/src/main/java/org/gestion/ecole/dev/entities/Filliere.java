package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Filliere.
 */
@Entity
@Table(name = "filliere")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Filliere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "lib_filliere")
    private String libFilliere;



    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "filliere_module",
               joinColumns = @JoinColumn(name = "filliere_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
    private Set<Module> modules = new HashSet<>();

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @ManyToOne
    @JsonIgnoreProperties("fillieres")
    private Inscription inscription;

    @ManyToMany(mappedBy = "modules")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Etablissement> etablissements = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLibFilliere() {
        return libFilliere;
    }

    public Filliere libFilliere(String libFilliere) {
        this.libFilliere = libFilliere;
        return this;
    }

    public void setLibFilliere(String libFilliere) {
        this.libFilliere = libFilliere;
    }


    public Inscription getInscription() {
        return inscription;
    }

    public Filliere inscription(Inscription inscription) {
        this.inscription = inscription;
        return this;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public Set<Etablissement> getEtablissements() {
        return etablissements;
    }

    public Filliere etablissements(Set<Etablissement> etablissements) {
        this.etablissements = etablissements;
        return this;
    }

    public Filliere addEtablissement(Etablissement etablissement) {
        this.etablissements.add(etablissement);
        etablissement.getModules().add(this);
        return this;
    }

    public Filliere removeEtablissement(Etablissement etablissement) {
        this.etablissements.remove(etablissement);
        etablissement.getModules().remove(this);
        return this;
    }

    public void setEtablissements(Set<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Filliere)) {
            return false;
        }
        return id != null && id.equals(((Filliere) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Filliere{" +
            "id=" + getId() +
            ", libFilliere='" + getLibFilliere() + "'" +
            "}";
    }
}
