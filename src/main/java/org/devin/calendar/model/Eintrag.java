package org.devin.calendar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Eintrag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String info;

    private LocalDateTime abholdatum;

    private String abholOrt;
    private String zielOrt;
    private String telefonnummer;

    public Eintrag() {
    }

    public Eintrag(String name, String info, LocalDateTime abholdatum, String abholOrt, String zielOrt, String telefonnummer) {
        this.name = name;
        this.info = info;
        this.abholdatum = abholdatum;
        this.abholOrt = abholOrt;
        this.zielOrt = zielOrt;
        this.telefonnummer = telefonnummer;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public LocalDateTime getAbholdatum() {
        return abholdatum;
    }

    public String getAbholOrt() {
        return abholOrt;
    }

    public String getZielOrt() {
        return zielOrt;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setAbholdatum(LocalDateTime abholdatum) {
        this.abholdatum = abholdatum;
    }

    public void setAbholOrt(String abholOrt) {
        this.abholOrt = abholOrt;
    }

    public void setZielOrt(String zielOrt) {
        this.zielOrt = zielOrt;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    @Override
    public String toString() {
        return """
                Name: %s
                Abholort: %s
                Zielort: %s
                Info: %s
                Tel. Kunde: %s
                """.formatted(name, abholOrt, zielOrt, info, telefonnummer);
    }
}
