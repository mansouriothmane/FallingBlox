package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class IPiece extends Piece{

    public IPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.getElements().add(new Element(coordonnees, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse(),coordonnees.getOrdonnee() - 1, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse() ,coordonnees.getOrdonnee() + 1, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse(),coordonnees.getOrdonnee() + 2, couleur));
        //TODO : Gérer les exceptions
    }
}
