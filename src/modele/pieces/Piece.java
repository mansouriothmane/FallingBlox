package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

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

    public Piece deplacerDe(int deltaX, int deltaY) {
        //TODO : Cas supérieur à 1
        if (deltaY < 0) throw new IllegalStateException("Unexpected value: " + deltaY);
        for(Element e : this.elements) {
            e.deplacerDe(deltaX, deltaY);
        }
        return this;
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
