package com.ieseljust.edd.helloMaven;

public class Contactes {

    private String nom;
    private String telefon;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    Contactes(String nom, String telefon) {
        this.setNom(nom);
        this.setTelefon(telefon);
    }

    @Override
    public String toString() {
        return "Contactes{" + "nom=" + nom + ", telefon=" + telefon + '}';
    }
    
}