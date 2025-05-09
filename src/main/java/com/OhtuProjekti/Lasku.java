package com.OhtuProjekti;

public class Lasku {
    public int laskuID;
    public double summa;
    public String erapaiva;
    public int varausID;
    public int maksettu;

    public Lasku(int laskuID, double summa, String erapaiva, int varausID, int maksettu){
        this.laskuID = laskuID;
        this.summa = summa;
        this.erapaiva = erapaiva;
        this.varausID = varausID;
        this.maksettu = maksettu;
    }
}
