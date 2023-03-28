package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Puits {
    public static int LARGEUR_PAR_DEFAUT = 400;
    public static int PROFONDEUR_PAR_DEFAUT = 400;
    public static String MODIFICATION_PIECE_ACTUELLE = "MODIFICATION_PIECE_ACTUELLE";
    public static String MODIFICATION_PIECE_SUIVANTE = "MODIFICATION_PIECE_SUIVANTE";
    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;
    private PropertyChangeSupport pcs;

    public Puits() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.profondeur = PROFONDEUR_PAR_DEFAUT;
        this.pcs = new PropertyChangeSupport(this);
    }

    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pcs = new PropertyChangeSupport(this);
    }

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public void setPieceSuivante(Piece nouvellePiece) {
        if (pieceSuivante != null) {
            Piece tmp = pieceActuelle; // HARD COPY ?
            pieceActuelle = pieceSuivante;
            pieceActuelle.setPosition(largeur / 2, -4);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, tmp, pieceActuelle);
        }
        Piece tmp = pieceSuivante; // HARD COPY ?
        pieceSuivante = nouvellePiece;
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, tmp, pieceSuivante);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Puits : Dimension " + largeur + " x " + profondeur + "\n" +
                "Piece Actuelle : " + (pieceActuelle != null ? pieceActuelle.toString() : "<aucune>\n") +
                "Piece Suivante : " + (pieceSuivante != null ? pieceSuivante.toString() : "<aucune>");
    }
}