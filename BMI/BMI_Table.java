package com.mycompany.projekt9.resources;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("BMI_Table")
@SessionScoped
public class BMI_Table implements Serializable {
    private List<BMI> BMIs; // Lista przechowująca wszystkie BMI
    @Inject
    private BMI currentBMI; // Referencja do beana BMI

    @PostConstruct
    public void init() {
        BMIs = new ArrayList<>(); // Inicjalizacja pustej listy
    }

    // Metoda do dodawania BMI do listy
    public void addBMI() {
        if (currentBMI.getObliczoneBMI() > 0) {
            // Tworzymy nowy obiekt BMI
            BMI newBMI = new BMI(
                currentBMI.getMasa(),
                currentBMI.getWysokosc(),
                currentBMI.getObliczoneBMI()
            );
            
            // Dodajemy nowy obiekt do listy
            BMIs.add(newBMI);
            
            // Resetujemy pola w beanie BMI
            //currentBMI.resetuj();
        }
    }
    
    public String remove(){
        BMIs.clear();
        return "index?faces-redirect=true";
    }

    // Getter dla listy BMI
    public List<BMI> getBMIs() {
        return BMIs;
    }

    // Getter dla aktualnego BMI
    public BMI getCurrentBMI() {
        return currentBMI;
    }
}