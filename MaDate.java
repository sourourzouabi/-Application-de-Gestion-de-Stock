/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
    public class MaDate {
    private int jj; // Jour
    private int mm; // Mois
    private int aa; // Année

    // Constructor
    public MaDate(int jj, int mm, int aa) {
        this.jj = jj;
        this.mm = mm;
        this.aa = aa;
    }

    // Getter and Setter for jj (Jour)
    public int getJj() {
        return jj;
    }

    public void setJj(int jj) {
        this.jj = jj;
    }

    // Getter and Setter for mm (Mois)
    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    // Getter and Setter for aa (Année)
    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "MaDate{" +
                "jj=" + jj +
                ", mm=" + mm +
                ", aa=" + aa +
                '}';
    }

    }
