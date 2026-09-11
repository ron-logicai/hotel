package nl.logicai.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Resevering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reseveringNummer;

    private LocalDate start;
    private LocalDate eind;
    private boolean betaald;

    @ManyToOne
    @JoinColumn(name = "gast_id")
    private Gast gast;

    @ManyToOne
    @JoinColumn(name = "kamer_nummer")
    private Kamer kamer;

    public Resevering() {
    }

    public Resevering(LocalDate start, LocalDate eind, Gast gast, Kamer kamer) {
        this.start = start;
        this.eind = eind;
        this.gast = gast;
        this.kamer = kamer;
    }

    public int getReseveringNummer() {
        return reseveringNummer;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEind() {
        return eind;
    }

    public void setEind(LocalDate eind) {
        this.eind = eind;
    }

    public boolean isBetaald() {
        return betaald;
    }

    public void setBetaald(boolean betaald) {
        this.betaald = betaald;
    }

    public Gast getGast() {
        return gast;
    }

    public void setGast(Gast gast) {
        this.gast = gast;
    }

    public Kamer getKamer() {
        return kamer;
    }

    public void setKamer(Kamer kamer) {
        this.kamer = kamer;
    }

    public long getAantalNachten() {
        if (start == null || eind == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(start, eind);
    }

    public double getTotaalPrijs() {
        if (kamer == null) {
            return 0;
        }
        double totaal = getAantalNachten() * kamer.getPrijsPerNacht();
        return Math.round(totaal * 100) / 100.0;
    }
}
