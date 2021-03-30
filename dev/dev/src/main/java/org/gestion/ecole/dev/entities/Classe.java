package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Classe.
 */
@Entity
@Table(name = "classe")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lib_classe")
    private String libClasse;

    @OneToOne
    @JoinColumn(unique = true)
    private Emploi emploi;

    @ManyToOne
    @JsonIgnoreProperties("classes")
    private Inscription inscription;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLibClasse() {
        return libClasse;
    }

    public Classe libClasse(String libClasse) {
        this.libClasse = libClasse;
        return this;
    }

    public void setLibClasse(String libClasse) {
        this.libClasse = libClasse;
    }

    public Emploi getEmploi() {
        return emploi;
    }

    public Classe emploi(Emploi emploi) {
        this.emploi = emploi;
        return this;
    }

    public void setEmploi(Emploi emploi) {
        this.emploi = emploi;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public Classe inscription(Inscription inscription) {
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
        if (!(o instanceof Classe)) {
            return false;
        }
        return id != null && id.equals(((Classe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Classe{" +
            "id=" + getId() +
            ", libClasse='" + getLibClasse() + "'" +
            "}";
    }
}
