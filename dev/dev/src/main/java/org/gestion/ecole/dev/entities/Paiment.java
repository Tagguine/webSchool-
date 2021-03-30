package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Paiment.
 */
@Entity
@Table(name = "paiment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Paiment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_pay")
    private String typePay;

    @Column(name = "mnt_payer")
    private Integer mntPayer;

    @Column(name = "date_pay")
    private Instant datePay;

    @ManyToOne
    @JsonIgnoreProperties("paiments")
    private Facture facture;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTypePay() {
        return typePay;
    }

    public Paiment typePay(String typePay) {
        this.typePay = typePay;
        return this;
    }

    public void setTypePay(String typePay) {
        this.typePay = typePay;
    }

    public Integer getMntPayer() {
        return mntPayer;
    }

    public Paiment mntPayer(Integer mntPayer) {
        this.mntPayer = mntPayer;
        return this;
    }

    public void setMntPayer(Integer mntPayer) {
        this.mntPayer = mntPayer;
    }

    public Instant getDatePay() {
        return datePay;
    }

    public Paiment datePay(Instant datePay) {
        this.datePay = datePay;
        return this;
    }

    public void setDatePay(Instant datePay) {
        this.datePay = datePay;
    }

    public Facture getFacture() {
        return facture;
    }

    public Paiment facture(Facture facture) {
        this.facture = facture;
        return this;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Paiment)) {
            return false;
        }
        return id != null && id.equals(((Paiment) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Paiment{" +
            "id=" + getId() +
            ", typePay='" + getTypePay() + "'" +
            ", mntPayer=" + getMntPayer() +
            ", datePay='" + getDatePay() + "'" +
            "}";
    }
}
