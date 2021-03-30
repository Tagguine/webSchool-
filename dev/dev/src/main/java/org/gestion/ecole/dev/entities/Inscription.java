package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Inscription.
 */
@Entity
@Table(name = "inscription")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "date_inscription")
    private Instant dateInscription;

    @Column(name = "annee_scolaire")
    private String anneeScolaire;

    @Column(name = "frais_inscription")
    private Integer fraisInscription;

    @Column(name = "date_debut")
    private Instant dateDebut;

    @Column(name = "date_fin")
    private Instant dateFin;

    @OneToMany(mappedBy = "inscription")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Niveau> niveaus = new HashSet<>();

    @OneToMany(mappedBy = "inscription")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Filliere> fillieres = new HashSet<>();

    @OneToMany(mappedBy = "inscription")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Classe> classes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("inscriptions")
    private Etudiant etudiant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Instant getDateInscription() {
        return dateInscription;
    }

    public Inscription dateInscription(Instant dateInscription) {
        this.dateInscription = dateInscription;
        return this;
    }

    public void setDateInscription(Instant dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public Inscription anneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
        return this;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Integer getFraisInscription() {
        return fraisInscription;
    }

    public Inscription fraisInscription(Integer fraisInscription) {
        this.fraisInscription = fraisInscription;
        return this;
    }

    public void setFraisInscription(Integer fraisInscription) {
        this.fraisInscription = fraisInscription;
    }

    public Instant getDateDebut() {
        return dateDebut;
    }

    public Inscription dateDebut(Instant dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public void setDateDebut(Instant dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Instant getDateFin() {
        return dateFin;
    }

    public Inscription dateFin(Instant dateFin) {
        this.dateFin = dateFin;
        return this;
    }

    public void setDateFin(Instant dateFin) {
        this.dateFin = dateFin;
    }

    public Set<Niveau> getNiveaus() {
        return niveaus;
    }

    public Inscription niveaus(Set<Niveau> niveaus) {
        this.niveaus = niveaus;
        return this;
    }

    public Inscription addNiveau(Niveau niveau) {
        this.niveaus.add(niveau);
        niveau.setInscription(this);
        return this;
    }

    public Inscription removeNiveau(Niveau niveau) {
        this.niveaus.remove(niveau);
        niveau.setInscription(null);
        return this;
    }

    public void setNiveaus(Set<Niveau> niveaus) {
        this.niveaus = niveaus;
    }

    public Set<Filliere> getFillieres() {
        return fillieres;
    }

    public Inscription fillieres(Set<Filliere> fillieres) {
        this.fillieres = fillieres;
        return this;
    }

    public Inscription addFilliere(Filliere filliere) {
        this.fillieres.add(filliere);
        filliere.setInscription(this);
        return this;
    }

    public Inscription removeFilliere(Filliere filliere) {
        this.fillieres.remove(filliere);
        filliere.setInscription(null);
        return this;
    }

    public void setFillieres(Set<Filliere> fillieres) {
        this.fillieres = fillieres;
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public Inscription classes(Set<Classe> classes) {
        this.classes = classes;
        return this;
    }

    public Inscription addClasse(Classe classe) {
        this.classes.add(classe);
        classe.setInscription(this);
        return this;
    }

    public Inscription removeClasse(Classe classe) {
        this.classes.remove(classe);
        classe.setInscription(null);
        return this;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Inscription etudiant(Etudiant etudiant) {
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
        if (!(o instanceof Inscription)) {
            return false;
        }
        return id != null && id.equals(((Inscription) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Inscription{" +
            "id=" + getId() +
            ", dateInscription='" + getDateInscription() + "'" +
            ", anneeScolaire='" + getAnneeScolaire() + "'" +
            ", fraisInscription=" + getFraisInscription() +
            ", dateDebut='" + getDateDebut() + "'" +
            ", dateFin='" + getDateFin() + "'" +
            "}";
    }
}
