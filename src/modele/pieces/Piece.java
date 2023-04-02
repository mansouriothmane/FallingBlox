package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.Math.abs;

public abstract class Piece {
    private static final Logger logger = Logger.getLogger(PieceDeplacement.class.getName());

    private List<Element> elements;
    private Puits puits;

    public Piece(Coordonnees coordonnees, Couleur couleur){
        this.elements = new ArrayList<>();
        this.setElements(coordonnees, couleur);
    }

    public List<Element> getElements() {
        return elements;
    }

    abstract protected void setElements(Coordonnees coordonnees, Couleur couleur);

    public void deplacerDe(int deltaX, int deltaY) {
        if (deltaY < 0) throw new IllegalStateException("Unexpected value: " + deltaX + deltaY);
        if (abs(deltaX) > 1 || abs(deltaY) > 1) throw new IllegalStateException("Unexpected value: " + deltaX + deltaY);
        try {
            for (Element e : this.elements) {
                int posX = e.getCoordonnees().getAbscisse() + deltaX;
                int posY = e.getCoordonnees().getOrdonnee() + deltaY;
                if (posX < 0 || posY < 0 || posX >= puits.getLargeur() || posY >= puits.getProfondeur()) {
                    throw new BloxException("La pièce sort du Puits", BloxException.BLOX_SORTIE_PUITS);
                }
                else if (puits.getTas().getElements()[posX][posY] != null) {
                    throw new BloxException("Collision détectée", BloxException.BLOX_COLLISION);
                }
            }
        } catch (BloxException ex) {
            //TODO move outside
            throw new RuntimeException(ex);
        }
        for(Element e : this.elements) {
            e.deplacerDe(deltaX, deltaY);
        }
    }

    public void tourner(boolean sensHoraire) {
        int dx = elements.get(0).getCoordonnees().getAbscisse();
        int dy = elements.get(0).getCoordonnees().getOrdonnee();
        try {
            for (Element e : elements) {
                int x = e.getCoordonnees().getAbscisse() - dx;
                int y = e.getCoordonnees().getOrdonnee() - dy;
                int newX = sensHoraire ? y : -y;
                int newY = sensHoraire ? -x : x;
                int posX = newX + dx;
                int posY = newY + dy;
                if (posX < 0 || posY < 0 || posX >= puits.getLargeur() || posY >= puits.getProfondeur()) {
                    throw new BloxException("La pièce sort du Puits", BloxException.BLOX_SORTIE_PUITS);
                }
                else if (puits.getTas().getElements()[posX][posY] != null) {
                    throw new BloxException("Collision détectée", BloxException.BLOX_COLLISION);
                }
            }
        } catch (BloxException ex) {
            //TODO move outside
            throw new RuntimeException(ex);
        }
        for(Element e : elements) {
            e.deplacerDe(-dx, -dy);
            e.tourner(sensHoraire);
            e.deplacerDe(dx, dy);
        }
    }

    public boolean estDansPuits(Coordonnees position) {
        return position.getAbscisse() < puits.getLargeur() &&
                position.getOrdonnee() < puits.getProfondeur() &&
                position.getAbscisse() >= 0 &&
                position.getOrdonnee() >= 0;
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
