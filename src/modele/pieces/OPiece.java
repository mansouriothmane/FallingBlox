package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import java.util.ArrayList;
import java.util.List;

public class OPiece {
    private List<Element> elements;

    public OPiece(Coordonnees coordonnees, Couleur couleur) {
        this.elements = new ArrayList<>();
        //TODO
    }

    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        //TODO
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }
}