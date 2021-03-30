package org.gestion.ecole.dev.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Proffeseur.
 */
@Entity
@Table(name = "proffeseur")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Proffeseur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_naissance")
    private Instant dateNaissance;

    @Column(name = "phone")
    private String phone;

    @Column(name = "photo")
    private String photo;

    @Column(name = "genre")
    private String genre;

    @Column(name = "cin")
    private Integer cin;

    @Column(name = "echelle")
    private Integer echelle;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public Proffeseur nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Proffeseur prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public Proffeseur email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Proffeseur password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getDateNaissance() {
        return dateNaissance;
    }

    public Proffeseur dateNaissance(Instant dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public void setDateNaissance(Instant dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhone() {
        return phone;
    }

    public Proffeseur phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public Proffeseur photo(String photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGenre() {
        return genre;
    }

    public Proffeseur genre(String genre) {
        this.genre = genre;
        return this;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getCin() {
        return cin;
    }

    public Proffeseur cin(Integer cin) {
        this.cin = cin;
        return this;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public Integer getEchelle() {
        return echelle;
    }

    public Proffeseur echelle(Integer echelle) {
        this.echelle = echelle;
        return this;
    }

    public void setEchelle(Integer echelle) {
        this.echelle = echelle;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proffeseur)) {
            return false;
        }
        return id != null && id.equals(((Proffeseur) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Proffeseur{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", dateNaissance='" + getDateNaissance() + "'" +
            ", phone='" + getPhone() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", genre='" + getGenre() + "'" +
            ", cin=" + getCin() +
            ", echelle=" + getEchelle() +
            "}";
    }
}
