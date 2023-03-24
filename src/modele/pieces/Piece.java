package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    private List<Element> elements;
    public List<Element> getElements() {
        return elements;
    }

    public Piece(Coordonnees coordonnees, Couleur couleur){
        this.elements = new ArrayList<>();
        this.setElements(coordonnees, couleur);
    }


    abstract public void setElements(Coordonnees coordonnees, Couleur couleur);
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.getClass().getName() + " :\n");
        for(Element e : this.elements){
            str.append("    ").append(e.toString()).append("\n");
        }
        return str.toString();
    }

    public void setPosition(int abscisse, int ordonnee){
        Couleur couleur = this.elements.get(0).getCouleur();
        this.elements.clear();
        Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
        this.setElements(coordonnees ,couleur);
    }
}
