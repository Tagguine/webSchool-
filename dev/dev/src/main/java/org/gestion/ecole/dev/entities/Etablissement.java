package org.gestion.ecole.dev.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Etablissement.
 */
@Entity
@Table(name = "etablissement")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Etablissement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lib_etabt")
    private String libEtabt;

    @Column(name = "date_creation")
    private Instant dateCreation;

    @Column(name = "status")
    private String status;

    @Column(name = "logo")
    private String logo;

    @OneToOne
    @JoinColumn(unique = true)
    private Adresse adresse;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "etablissement_module",
               joinColumns = @JoinColumn(name = "etablissement_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
    private Set<Filliere> modules = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLibEtabt() {
        return libEtabt;
    }

    public Etablissement libEtabt(String libEtabt) {
        this.libEtabt = libEtabt;
        return this;
    }

    public void setLibEtabt(String libEtabt) {
        this.libEtabt = libEtabt;
    }

    public Instant getDateCreation() {
        return dateCreation;
    }

    public Etablissement dateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public void setDateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatus() {
        return status;
    }

    public Etablissement status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogo() {
        return logo;
    }

    public Etablissement logo(String logo) {
        this.logo = logo;
        return this;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Etablissement adresse(Adresse adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Filliere> getModules() {
        return modules;
    }

    public Etablissement modules(Set<Filliere> fillieres) {
        this.modules = fillieres;
        return this;
    }

    public Etablissement addModule(Filliere filliere) {
        this.modules.add(filliere);
        filliere.getEtablissements().add(this);
        return this;
    }

    public Etablissement removeModule(Filliere filliere) {
        this.modules.remove(filliere);
        filliere.getEtablissements().remove(this);
        return this;
    }

    public void setModules(Set<Filliere> fillieres) {
        this.modules = fillieres;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Etablissement)) {
            return false;
        }
        return id != null && id.equals(((Etablissement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Etablissement{" +
            "id=" + getId() +
            ", libEtabt='" + getLibEtabt() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            ", status='" + getStatus() + "'" +
            ", logo='" + getLogo() + "'" +
            "}";
    }
}
