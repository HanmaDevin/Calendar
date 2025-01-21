package org.devin.calendar.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class EintragDTO {

    private String name;
    private String info;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") private LocalDateTime abholdatum;
    private String telefonnummer;
    private String abholOrt;
    private String zielOrt;

    public EintragDTO() {
    }

    public EintragDTO(String name, String info, LocalDateTime abholdatum, String telefonnummer, String abholOrt, String zielOrt) {
        this.name = name;
        this.info = info;
        this.abholdatum = abholdatum;
        this.telefonnummer = telefonnummer;
        this.abholOrt = abholOrt;
        this.zielOrt = zielOrt;
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
                "Abholdatum: " + abholdatum + "\n";
    }
}
