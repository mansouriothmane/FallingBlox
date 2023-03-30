package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

public class Tas {

    private Puits puits;
    private Element[][] elements;

    public Tas(Puits puits) {

    }

    public Tas(Puits puits, int nbElements) {
        this.puits = puits;
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this.puits = puits;
        construireTas(nbElements, nbLignes, new Random());
    }

    private void construireTas(int nbElements, int nbLignes, Random rand) {

    }
}
