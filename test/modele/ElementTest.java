package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementTest {
    @Test
    void testGetCoordonnees() {

        Coordonnees coord = new Coordonnees(3,4);
        Element el;

        el = new Element(coord, Couleur.ROUGE);
        Assertions.assertEquals(coord, el.getCoordonnees());

        el = new Element(3, 4, Couleur.ROUGE);
        Assertions.assertEquals(coord, el.getCoordonnees());

        el = new Element(coord);
        Assertions.assertEquals(coord, el.getCoordonnees());

        el = new Element(3, 4);
        Assertions.assertEquals(coord, el.getCoordonnees());
    }

    @Test
    void testGetCouleur() {
        Coordonnees coord = new Coordonnees(3,4);
        Element el;

        el = new Element(coord, Couleur.BLEU);
        Assertions.assertEquals(Couleur.BLEU, el.getCouleur());

        el = new Element(3, 4, Couleur.VERT);
        Assertions.assertEquals(Couleur.VERT, el.getCouleur());

        el = new Element(coord);
        Assertions.assertEquals(Couleur.ROUGE, el.getCouleur());

        el = new Element(3, 4);
        Assertions.assertEquals(Couleur.ROUGE, el.getCouleur());
    }

    @Test
    void testSetCoordonnees() {
        Coordonnees coord = new Coordonnees(3,4);
        Coordonnees coord2 = new Coordonnees(5,6);
        Element el;

        el = new Element(coord);
        el.setCoordonnees(coord2);
        Assertions.assertEquals(coord2, el.getCoordonnees());

        el = new Element(coord, Couleur.CYAN);
        el.setCoordonnees(coord2);
        Assertions.assertEquals(coord2, el.getCoordonnees());
    }

    @Test
    void testSetCouleur() {
        Coordonnees coord = new Coordonnees(7,1);
        Element el;

        el = new Element(coord);
        el.setCouleur(Couleur.JAUNE);
        Assertions.assertEquals(Couleur.JAUNE, el.getCouleur());

        el = new Element(coord, Couleur.CYAN);
        el.setCouleur(Couleur.BLEU);
        Assertions.assertEquals(Couleur.BLEU, el.getCouleur());
    }

    @Test
    void testToString() {
        Coordonnees coord = new Coordonnees(15,2);
        Element el;

        el = new Element(coord, Couleur.VIOLET);
        Assertions.assertEquals("(15, 2) - VIOLET",  el.toString());

        el = new Element(4, 9, Couleur.ORANGE);
        Assertions.assertEquals("(4, 9) - ORANGE",  el.toString());
    }

    @Test
    void testEquals() {
        Coordonnees coord = new Coordonnees(10,6);
        Element el1, el2, el3, el4;

        el1 = new Element(coord);
        el2 = new Element(coord);
        el3 = new Element(10, 6);
        el4 = new Element(6, 10);

        Assertions.assertTrue(el1.equals(el1));
        Assertions.assertTrue(el1.equals(el2));
        Assertions.assertTrue(el1.equals(el3));
        Assertions.assertFalse(el1.equals(el4));
    }
}