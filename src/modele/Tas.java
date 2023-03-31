package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

public class Tas {

    private Puits puits;
    private Element[][] elements;

    public Tas(Puits puits) {
        this.puits = puits;
    }

    public Tas(Puits puits, int nbElements) {
        this.puits = puits;
        construireTas(nbElements, nbElements / puits.getLargeur() + 1, new Random());
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this.puits = puits;
        construireTas(nbElements, nbLignes, new Random());
    }

    private void construireTas(int nbElements, int nbLignes, Random rand) {
        if (nbElements > 0 && nbElements > nbLignes * puits.getLargeur())
            throw new IllegalArgumentException("Unexpected value : " + nbElements);
        int nbElementsPlaces = 0;
        while (nbElementsPlaces < nbElements) {
            int ordonnee = puits.getProfondeur() - rand.nextInt(1, nbLignes + 1);
            int abscisse = rand.nextInt(0, puits.getLargeur());
            if (elements[abscisse][ordonnee] != null) {
                int indiceCouleur = rand.nextInt(0, Couleur.values().length);
                elements[abscisse][ordonnee] = new Element(abscisse, ordonnee, Couleur.values()[indiceCouleur]);
                nbElementsPlaces += 1;
            }
        }
    }
}
