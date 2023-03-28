package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoordonneesTest {
    @Test
    void testGetAbscisse() {
        Coordonnees coord = new Coordonnees(18, 10);
        assertEquals(18, coord.getAbscisse());
    }

    @Test
    void testGetOrdonnee() {
        Coordonnees coord = new Coordonnees(18, 10);
        assertEquals(10, coord.getOrdonnee());
    }

    @Test
    void testSetAbscisse() {
        Coordonnees coord = new Coordonnees(18, 10);
        coord.setAbscisse(16);
        assertEquals(16, coord.getAbscisse());
    }

    @Test
    void testSetOrdonnee() {
        Coordonnees coord = new Coordonnees(18, 10);
        coord.setOrdonnee(12);
        assertEquals(12, coord.getOrdonnee());
    }

    @Test
    void testToString() {
        Coordonnees coord = new Coordonnees(18, 10);
        assertEquals("(18, 10)", coord.toString());
    }

    @Test
    void testEquals() {
        Coordonnees coord = new Coordonnees(18, 10);
        Coordonnees coord2 = new Coordonnees(18, 10);
        Coordonnees coord3 = new Coordonnees(16, 12);
        assertTrue(coord.equals(coord));
        assertTrue(coord.equals(coord2));
        assertFalse(coord.equals(coord3));
    }
}