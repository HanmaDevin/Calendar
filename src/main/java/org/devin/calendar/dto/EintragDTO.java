package org.devin.calendar.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import java.time.LocalTime;

public class EintragDTO {

    private String name;
    private String info;
    @DateTimeFormat(pattern = "dd-MM-yyyy") private LocalDate abholdatum;
    @DateTimeFormat(pattern = "HH:mm") private LocalTime abholzeit;
    private String telefonnummer;
    private String abholOrt;
    private String zielOrt;

    public EintragDTO() {
    }

    public EintragDTO(String name, String info, LocalDate abholdatum, LocalTime abholzeit, String telefonnummer, String abholOrt, String zielOrt) {
        this.name = name;
        this.info = info;
        this.abholdatum = abholdatum;
        this.abholzeit = abholzeit;
        this.telefonnummer = telefonnummer;
        this.abholOrt = abholOrt;
        this.zielOrt = zielOrt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setAbholdatum(LocalDate abholdatum) {
        this.abholdatum = abholdatum;
    }

    public void setAbholzeit(LocalTime abholzeit) {
        this.abholzeit = abholzeit;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void setAbholOrt(String abholOrt) {
        this.abholOrt = abholOrt;
    }

    public void setZielOrt(String zielOrt) {
        this.zielOrt = zielOrt;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public LocalDate getAbholdatum() {
        return abholdatum;
    }

    public LocalTime getAbholzeit() {
        return abholzeit;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getAbholOrt() {
        return abholOrt;
    }

    public String getZielOrt() {
        return zielOrt;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\n" +
                "Abholort: " + abholOrt + "\n" +
                "Zielort: " + zielOrt + "\n" +
                "Info: " + info + "\n" +
                "Abholdatum: " + abholdatum + "\n" +
                "Abholzeit: " + abholzeit + "\n" +
                "Telefonnummer: " + telefonnummer;
    }
}
