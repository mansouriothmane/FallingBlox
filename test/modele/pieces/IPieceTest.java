package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IPieceTest {
    @Test
    void testGetElements() {
        Coordonnees coord = new Coordonnees(14,2);
        Piece ipiece = new IPiece(coord, Couleur.VERT);
        List<Element> elements = ipiece.getElements();
        int x = coord.getAbscisse();
        int y = coord.getOrdonnee();
        assertEquals(4, elements.size());
        assertEquals(new Element(coord, Couleur.VERT), elements.get(0));
        assertTrue(elements.contains(new Element(x, y-1, Couleur.VERT)));
        assertTrue(elements.contains(new Element(x, y+1, Couleur.VERT)));
        assertTrue(elements.contains(new Element(x, y+2, Couleur.VERT)));
    }

    @Test
    void testToString() {
        Coordonnees coord = new Coordonnees(14,2);
        Piece ipiece = new IPiece(coord, Couleur.JAUNE);
        assertEquals("""
                IPiece :
                \t(14, 2) - JAUNE
                \t(14, 1) - JAUNE
                \t(14, 3) - JAUNE
                \t(14, 4) - JAUNE
                """, ipiece.toString());
    }

    @Test
    void testSetPosition() {
        Coordonnees coord = new Coordonnees(14,14);
        Piece ipiece = new IPiece(coord, Couleur.CYAN);
        ipiece.setPosition(7, 2);
        List<Element> elements = ipiece.getElements();
        assertEquals(4, elements.size());
        assertEquals(new Element(7, 2, Couleur.CYAN), elements.get(0));
        assertTrue(elements.contains(new Element(7, 1, Couleur.CYAN)));
        assertTrue(elements.contains(new Element(7, 2, Couleur.CYAN)));
        assertTrue(elements.contains(new Element(7, 3, Couleur.CYAN)));
    }

    @Test
    void testDeplacerDe() {
        Piece piece = new IPiece(new Coordonnees(2, 3), Couleur.ROUGE);
        piece.deplacerDe(2, 1);
        assertEquals(new Coordonnees(4, 4), piece.getElements().get(0).getCoordonnees());
        piece.deplacerDe(-3, 2);
        assertEquals(new Coordonnees(1, 6), piece.getElements().get(0).getCoordonnees());
        assertThrows(IllegalStateException.class, () -> piece.deplacerDe(2, -1));
    }
}