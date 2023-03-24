package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import java.util.ArrayList;
import java.util.List;

public class OPiece extends Piece{


    public OPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    public void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.getElements().add(new Element(coordonnees, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse(),coordonnees.getOrdonnee() - 1, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse() + 1,coordonnees.getOrdonnee(), couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse() + 1,coordonnees.getOrdonnee() - 1, couleur));
        //TODO : Gérer les exceptions
    }
}