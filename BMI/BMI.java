package com.mycompany.projekt9.resources;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Cookie;

@Named("BMI")
@SessionScoped
public class BMI implements Serializable {
    private double masa;
    private double wysokosc;
    private double obliczoneBMI;

    public BMI() {}

    // Konstruktor z parametrami
    public BMI(double masa, double wysokosc) {
        this.masa = masa;
        this.wysokosc = wysokosc;
        this.obliczoneBMI = -1;
    }

    public BMI(double masa, double wysokosc, double obliczoneBMI) {
        this.masa = masa;
        this.wysokosc = wysokosc;
        this.obliczoneBMI = obliczoneBMI;
    }

    // Gettery i settery
    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getObliczoneBMI() {
        return obliczoneBMI;
    }

    public String obliczBMI() {
        if (wysokosc <= 0 || masa <= 0) {
            obliczoneBMI = -1; // Błąd: niepoprawne dane
            return "error?faces-redirect=true";
        }
        double wzrostWMetrach = wysokosc / 100.0;
        obliczoneBMI = masa / (wzrostWMetrach * wzrostWMetrach);
        return null;
    }

    public String resetuj() {
        masa = 0;
        wysokosc = 0;
        obliczoneBMI = -1; // Resetujemy na -1 (brak obliczeń)
        return "index?faces-redirect=true";
    }
}