package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
    public int LARGEUR_PAR_DEFAUT = 10;
    public int PROFONDEUR_PAR_DEFAUT = 15;
    private int largeur;
    private int profondeur;

    private Piece pieceActuelle;
    private Piece pieceSuivante;

    Puits() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.profondeur = PROFONDEUR_PAR_DEFAUT;
    }

    Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
    }

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public void setPieceSuivante(Piece pieceSuivante) {
        if (this.pieceSuivante != null) {
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(largeur / 2, -4);
        }
        this.pieceSuivante = pieceSuivante;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    @Override
    public String toString() {
        return "Puits : Dimension " + largeur + " x " + profondeur + "\n" +
                "Piece Actuelle : " + (pieceActuelle != null ? pieceActuelle.toString() : "<aucune>\n") +
                "Piece Suivante : " + (pieceSuivante != null ? pieceSuivante.toString() : "<aucune>");
    }
}