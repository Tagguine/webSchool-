package org.gestion.ecole.dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Matiere.
 */
@Entity
@Table(name = "matiere")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "theme")
    private String theme;

    @Column(name = "nbr_heure")
    private Integer nbrHeure;

    @Column(name = "cof")
    private Integer cof;

    @OneToMany(mappedBy = "matiere")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Note> notes = new HashSet<>();

    @OneToMany(mappedBy = "matiere")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Emploi> emplois = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "matiere_examin",
               joinColumns = @JoinColumn(name = "matiere_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "examin_id", referencedColumnName = "id"))
    private Set<Examin> examins = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("matieres")
    private Module module;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTheme() {
        return theme;
    }

    public Matiere theme(String theme) {
        this.theme = theme;
        return this;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getNbrHeure() {
        return nbrHeure;
    }

    public Matiere nbrHeure(Integer nbrHeure) {
        this.nbrHeure = nbrHeure;
        return this;
    }

    public void setNbrHeure(Integer nbrHeure) {
        this.nbrHeure = nbrHeure;
    }

    public Integer getCof() {
        return cof;
    }

    public Matiere cof(Integer cof) {
        this.cof = cof;
        return this;
    }

    public void setCof(Integer cof) {
        this.cof = cof;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public Matiere notes(Set<Note> notes) {
        this.notes = notes;
        return this;
    }

    public Matiere addNote(Note note) {
        this.notes.add(note);
        note.setMatiere(this);
        return this;
    }

    public Matiere removeNote(Note note) {
        this.notes.remove(note);
        note.setMatiere(null);
        return this;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<Emploi> getEmplois() {
        return emplois;
    }

    public Matiere emplois(Set<Emploi> emplois) {
        this.emplois = emplois;
        return this;
    }

    public Matiere addEmploi(Emploi emploi) {
        this.emplois.add(emploi);
        emploi.setMatiere(this);
        return this;
    }

    public Matiere removeEmploi(Emploi emploi) {
        this.emplois.remove(emploi);
        emploi.setMatiere(null);
        return this;
    }

    public void setEmplois(Set<Emploi> emplois) {
        this.emplois = emplois;
    }

    public Set<Examin> getExamins() {
        return examins;
    }

    public Matiere examins(Set<Examin> examins) {
        this.examins = examins;
        return this;
    }

    public Matiere addExamin(Examin examin) {
        this.examins.add(examin);
        examin.getMatieres().add(this);
        return this;
    }

    public Matiere removeExamin(Examin examin) {
        this.examins.remove(examin);
        examin.getMatieres().remove(this);
        return this;
    }

    public void setExamins(Set<Examin> examins) {
        this.examins = examins;
    }

    public Module getModule() {
        return module;
    }

    public Matiere module(Module module) {
        this.module = module;
        return this;
    }

    public void setModule(Module module) {
        this.module = module;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Matiere)) {
            return false;
        }
        return id != null && id.equals(((Matiere) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Matiere{" +
            "id=" + getId() +
            ", theme='" + getTheme() + "'" +
            ", nbrHeure=" + getNbrHeure() +
            ", cof=" + getCof() +
            "}";
    }
}
