package nl.logicai.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Kamer {

    @Id
    private int nummer;
    private int maxPersonen;
    private String type;
    private double prijsPerNacht;
    private int verdieping;


    public Kamer() {
    }

    public Kamer(int nummer, String type, double prijsPerNacht, int maxPersonen, int verdieping) {
        this.nummer = nummer;
        this.type = type;
        this.prijsPerNacht = prijsPerNacht;
        this.maxPersonen = maxPersonen;
        this.verdieping = verdieping;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxPersonen() {
        return maxPersonen;
    }

    public void setMaxPersonen(int maxPersonen) {
        this.maxPersonen = maxPersonen;
    }

    public double getPrijsPerNacht() {
        return prijsPerNacht;
    }

    public void setPrijsPerNacht(double prijsPerNacht) {
        this.prijsPerNacht = prijsPerNacht;
    }

    public int getVerdieping(){
        return verdieping;
    }
}
