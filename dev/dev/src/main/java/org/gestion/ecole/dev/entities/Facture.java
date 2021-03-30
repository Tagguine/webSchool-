package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Facture.
 */
@Entity
@Table(name = "facture")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "ref")
    private String ref;

    @Column(name = "mnt_facture")
    private Integer mntFacture;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "facture")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Paiment> paiments = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("factures")
    private Etudiant etudiant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getRef() {
        return ref;
    }

    public Facture ref(String ref) {
        this.ref = ref;
        return this;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getMntFacture() {
        return mntFacture;
    }

    public Facture mntFacture(Integer mntFacture) {
        this.mntFacture = mntFacture;
        return this;
    }

    public void setMntFacture(Integer mntFacture) {
        this.mntFacture = mntFacture;
    }

    public String getDescription() {
        return description;
    }

    public Facture description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Paiment> getPaiments() {
        return paiments;
    }

    public Facture paiments(Set<Paiment> paiments) {
        this.paiments = paiments;
        return this;
    }

    public Facture addPaiment(Paiment paiment) {
        this.paiments.add(paiment);
        paiment.setFacture(this);
        return this;
    }

    public Facture removePaiment(Paiment paiment) {
        this.paiments.remove(paiment);
        paiment.setFacture(null);
        return this;
    }

    public void setPaiments(Set<Paiment> paiments) {
        this.paiments = paiments;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Facture etudiant(Etudiant etudiant) {
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
        if (!(o instanceof Facture)) {
            return false;
        }
        return id != null && id.equals(((Facture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Facture{" +
            "id=" + getId() +
            ", ref='" + getRef() + "'" +
            ", mntFacture=" + getMntFacture() +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
