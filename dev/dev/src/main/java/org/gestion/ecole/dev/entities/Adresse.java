package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Adresse.
 */
@Entity
@Table(name = "adresse")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "lib_adresse")
    private String libAdresse;

    @Column(name = "commune")
    private String commune;

    @ManyToOne
    @JsonIgnoreProperties("adresses")
    private Province province;

    public Adresse(Long id, String libAdresse, String commune, Province province) {
        this.id = id;
        this.libAdresse = libAdresse;
        this.commune = commune;
        this.province = province;
    }

    public Adresse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibAdresse() {
        return libAdresse;
    }

    public Adresse libAdresse(String libAdresse) {
        this.libAdresse = libAdresse;
        return this;
    }

    public void setLibAdresse(String libAdresse) {
        this.libAdresse = libAdresse;
    }

    public String getCommune() {
        return commune;
    }

    public Adresse commune(String commune) {
        this.commune = commune;
        return this;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public Province getProvince() {
        return province;
    }

    public Adresse province(Province province) {
        this.province = province;
        return this;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Adresse)) {
            return false;
        }
        return id != null && id.equals(((Adresse) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Adresse{" +
            "id=" + getId() +
            ", libAdresse='" + getLibAdresse() + "'" +
            ", commune='" + getCommune() + "'" +
            "}";
    }
}
