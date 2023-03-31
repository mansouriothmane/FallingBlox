package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class Piece {
    private static final Logger logger = Logger.getLogger(PieceDeplacement.class.getName());

    private List<Element> elements;
    private Puits puits;

    public Piece(Coordonnees coordonnees, Couleur couleur){
        this.elements = new ArrayList<>();
        this.setElements(coordonnees, couleur);
        this.puits = puits;
    }

    public List<Element> getElements() {
        return elements;
    }

    abstract protected void setElements(Coordonnees coordonnees, Couleur couleur);

    public void deplacerDe(int deltaX, int deltaY) {
        try {
            for (Element e : this.elements) {
                Coordonnees nouvellePosition = e.nouvellePosition(deltaX, deltaY);
                if (estUnePositionLegale(nouvellePosition)) {
                    throw new BloxException("Illegal position : " + nouvellePosition, BloxException.BLOX_SORTIE_PUITS);
                }
            }
        } catch (BloxException ex) {
            throw new RuntimeException(ex);
        }
        if (deltaY < 0) throw new IllegalStateException("Unexpected value: " + deltaY);
        if (deltaX > 1 || deltaY > 1) throw new IllegalStateException("Unexpected value: " + deltaX);
        for(Element e : this.elements) {
            e.deplacerDe(deltaX, deltaY);
        }
    }

    public Piece tourner(boolean sensHoraire) {
        int dx = elements.get(0).getCoordonnees().getAbscisse();
        int dy = elements.get(0).getCoordonnees().getOrdonnee();
        for(Element e : elements) {
            e.deplacerDe(-dx, -dy);
            e.tourner(sensHoraire);
            e.deplacerDe(dx, dy);
        }
        return this;
    }

    public boolean estUnePositionLegale(Coordonnees position) {
        return position.getAbscisse() >= puits.getLargeur() ||
                position.getOrdonnee() >= puits.getProfondeur() ||
                position.getAbscisse() < 0 ||
                position.getOrdonnee() < 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.getClass().getSimpleName() + " :\n");
        for(Element e : this.elements){
            str.append("\t").append(e.toString()).append("\n");
        }
        return str.toString();
    }

    public void setPosition(int abscisse, int ordonnee){
        Couleur couleur = this.elements.get(0).getCouleur();
        this.elements.clear();
        Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
        this.setElements(coordonnees ,couleur);
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }
}
