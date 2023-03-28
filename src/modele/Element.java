package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
    private Coordonnees coordonnees;
    private Couleur couleur;

    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
        this.couleur = Couleur.values()[0];
    }

    public Element(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = Couleur.values()[0];
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = couleur;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void deplacerDe(int deltaX, int deltaY) {
        coordonnees.setAbscisse(coordonnees.getAbscisse() + deltaX);
        coordonnees.setOrdonnee(coordonnees.getOrdonnee() + deltaY);
    }

    public void tourner(boolean sensHoraire) {
        //TODO: finir
        deplacerDe(-coordonnees.getAbscisse(), -coordonnees.getOrdonnee());
        int x = coordonnees.getAbscisse();
        int y = coordonnees.getOrdonnee();
        coordonnees.setAbscisse((int) Math.sqrt(x*x + y*y));
        coordonnees.setOrdonnee(0);
        deplacerDe(coordonnees.getAbscisse(), coordonnees.getOrdonnee());
    }

    @Override
    public String toString() {
        return coordonnees.toString() + " - " + couleur.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element element)) return false;
        return Objects.equals(coordonnees, element.coordonnees) && couleur == element.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnees, couleur);
    }
}