package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Province.
 */
@Entity
@Table(name = "province")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "province")
    private String province;

    @OneToMany(mappedBy = "province")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Adresse> adresses = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("provinces")
    private Region region;

    public Province(Long id, String province) {
        this.id = id;
        this.province = province;
    }

    public Province() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getProvince() {
        return province;
    }

    public Province province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Set<Adresse> getAdresses() {
        return adresses;
    }

    public Province adresses(Set<Adresse> adresses) {
        this.adresses = adresses;
        return this;
    }

    public Province addAdresse(Adresse adresse) {
        this.adresses.add(adresse);
        adresse.setProvince(this);
        return this;
    }

    public Province removeAdresse(Adresse adresse) {
        this.adresses.remove(adresse);
        adresse.setProvince(null);
        return this;
    }

    public void setAdresses(Set<Adresse> adresses) {
        this.adresses = adresses;
    }

    public Region getRegion() {
        return region;
    }

    public Province region(Region region) {
        this.region = region;
        return this;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Province)) {
            return false;
        }
        return id != null && id.equals(((Province) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Province{" +
            "id=" + getId() +
            ", province='" + getProvince() + "'" +
            "}";
    }
}
