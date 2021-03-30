package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Region.
 */
@Entity
@Table(name = "region")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "lib_region")
    private String libRegion;

    @OneToMany(mappedBy = "region")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Province> provinces = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("regions")
    private Pays pays;

    public Region(Long id, String libRegion) {
        this.id = id;
        this.libRegion = libRegion;
    }

    public Region() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLibRegion() {
        return libRegion;
    }

    public Region libRegion(String libRegion) {
        this.libRegion = libRegion;
        return this;
    }

    public void setLibRegion(String libRegion) {
        this.libRegion = libRegion;
    }

    public Set<Province> getProvinces() {
        return provinces;
    }

    public Region provinces(Set<Province> provinces) {
        this.provinces = provinces;
        return this;
    }

    public Region addProvince(Province province) {
        this.provinces.add(province);
        province.setRegion(this);
        return this;
    }

    public Region removeProvince(Province province) {
        this.provinces.remove(province);
        province.setRegion(null);
        return this;
    }

    public void setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }

    public Pays getPays() {
        return pays;
    }

    public Region pays(Pays pays) {
        this.pays = pays;
        return this;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Region)) {
            return false;
        }
        return id != null && id.equals(((Region) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Region{" +
            "id=" + getId() +
            ", libRegion='" + getLibRegion() + "'" +
            "}";
    }
}
