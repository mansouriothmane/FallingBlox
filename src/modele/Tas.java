package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;
import java.util.logging.Logger;

public class Tas {
    private static final Logger logger = Logger.getLogger(Puits.class.getName());
    private Puits puits;
    private Element[][] elements;

    public Tas(Puits puits) {
        this.puits = puits;
        elements = new Element[puits.getLargeur()][puits.getProfondeur()];
    }

    public Tas(Puits puits, int nbElements) {
        this.puits = puits;
        elements = new Element[puits.getLargeur()][puits.getProfondeur()];
        construireTas(nbElements, nbElements / puits.getLargeur() + 1, new Random());
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this.puits = puits;
        elements = new Element[puits.getLargeur()][puits.getProfondeur()];
        construireTas(nbElements, nbLignes, new Random());
    }

    public Element[][] getElements() {
        return elements;
    }

    private void construireTas(int nbElements, int nbLignes, Random rand) {
        if (nbElements > 0 && nbElements > nbLignes * puits.getLargeur())
            throw new IllegalArgumentException("Unexpected value : " + nbElements);
        int nbElementsPlaces = 0;
        while (nbElementsPlaces < nbElements) {
            int ordonnee = puits.getProfondeur() - rand.nextInt(1, nbLignes + 1);
            int abscisse = rand.nextInt(0, puits.getLargeur());
            if (elements[abscisse][ordonnee] == null) {
                int indiceCouleur = rand.nextInt(0, Couleur.values().length);
                elements[abscisse][ordonnee] = new Element(abscisse, ordonnee, Couleur.values()[indiceCouleur]);
                nbElementsPlaces += 1;
            }
        }
    }

    public void ajouterElements(Piece piece) {
        for (Element e : piece.getElements()) {
            int posX = e.getCoordonnees().getAbscisse();
            int posY = e.getCoordonnees().getOrdonnee();
            this.elements[posX][posY] = e;
        }
    }

    public void supprimerLignesCompletees() {
        for (int y = 0; y < elements[0].length; y++) {
            boolean ligneComplete = true;
            for (int x = 0; x < elements.length; x++) {
                if (elements[x][y] == null) {
                    ligneComplete = false;
                    break;
                }
            }
            if (ligneComplete) {
                // Supprimer la ligne y
                for (int yy = y; yy > 0; yy--) {
                    for (int x = 0; x < elements.length; x++) {
                        elements[x][yy] = elements[x][yy-1];
                    }
                }
                for (int x = 0; x < elements.length; x++) {
                    elements[x][0] = null;
                }
            }
        }
    }


    public void displayBoard() {
        for (int col = 0; col < elements[0].length; col++) {
            for (int row = 0; row < elements.length; row++) {
                if (elements[row][col] != null) {
                    System.out.print("[x]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
