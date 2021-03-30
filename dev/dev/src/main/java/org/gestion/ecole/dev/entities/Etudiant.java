package org.gestion.ecole.dev.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Etudiant.
 */
@Entity
@Table(name = "etudiant")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Etudiant implements Serializable {

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

    @OneToOne
    @JoinColumn(unique = true)
    private Adresse adresse;

    @OneToMany(mappedBy = "etudiant")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Inscription> inscriptions = new HashSet<>();

    @OneToMany(mappedBy = "etudiant")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Note> notes = new HashSet<>();

    @OneToMany(mappedBy = "etudiant")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Bulletin> bulletins = new HashSet<>();

    @OneToMany(mappedBy = "etudiant")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Facture> factures = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "etudiant_examin",
               joinColumns = @JoinColumn(name = "etudiant_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "examin_id", referencedColumnName = "id"))
    private Set<Examin> examins = new HashSet<>();

    public Etudiant(Long id,String nom, String prenom, String email, String password, Instant dateNaissance, String phone, String photo, String genre, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.phone = phone;
        this.photo = photo;
        this.genre = genre;
        this.adresse = adresse;
    }

    public Etudiant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public Etudiant nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Etudiant prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public Etudiant email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Etudiant password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getDateNaissance() {
        return dateNaissance;
    }

    public Etudiant dateNaissance(Instant dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public void setDateNaissance(Instant dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhone() {
        return phone;
    }

    public Etudiant phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public Etudiant photo(String photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGenre() {
        return genre;
    }

    public Etudiant genre(String genre) {
        this.genre = genre;
        return this;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Etudiant adresse(Adresse adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public Etudiant inscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
        return this;
    }

    public Etudiant addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
        inscription.setEtudiant(this);
        return this;
    }

    public Etudiant removeInscription(Inscription inscription) {
        this.inscriptions.remove(inscription);
        inscription.setEtudiant(null);
        return this;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public Etudiant notes(Set<Note> notes) {
        this.notes = notes;
        return this;
    }

    public Etudiant addNote(Note note) {
        this.notes.add(note);
        note.setEtudiant(this);
        return this;
    }

    public Etudiant removeNote(Note note) {
        this.notes.remove(note);
        note.setEtudiant(null);
        return this;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<Bulletin> getBulletins() {
        return bulletins;
    }

    public Etudiant bulletins(Set<Bulletin> bulletins) {
        this.bulletins = bulletins;
        return this;
    }

    public Etudiant addBulletin(Bulletin bulletin) {
        this.bulletins.add(bulletin);
        bulletin.setEtudiant(this);
        return this;
    }

    public Etudiant removeBulletin(Bulletin bulletin) {
        this.bulletins.remove(bulletin);
        bulletin.setEtudiant(null);
        return this;
    }

    public void setBulletins(Set<Bulletin> bulletins) {
        this.bulletins = bulletins;
    }

    public Set<Facture> getFactures() {
        return factures;
    }

    public Etudiant factures(Set<Facture> factures) {
        this.factures = factures;
        return this;
    }

    public Etudiant addFacture(Facture facture) {
        this.factures.add(facture);
        facture.setEtudiant(this);
        return this;
    }

    public Etudiant removeFacture(Facture facture) {
        this.factures.remove(facture);
        facture.setEtudiant(null);
        return this;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

    public Set<Examin> getExamins() {
        return examins;
    }

    public Etudiant examins(Set<Examin> examins) {
        this.examins = examins;
        return this;
    }

    public Etudiant addExamin(Examin examin) {
        this.examins.add(examin);
        examin.getEtudiants().add(this);
        return this;
    }

    public Etudiant removeExamin(Examin examin) {
        this.examins.remove(examin);
        examin.getEtudiants().remove(this);
        return this;
    }

    public void setExamins(Set<Examin> examins) {
        this.examins = examins;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Etudiant)) {
            return false;
        }
        return id != null && id.equals(((Etudiant) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", dateNaissance='" + getDateNaissance() + "'" +
            ", phone='" + getPhone() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", genre='" + getGenre() + "'" +
            "}";
    }
}
