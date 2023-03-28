package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

class CouleurTest {

    @Test
    void testGetCouleurPourAffichage() {
        assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
        assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
        assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
        assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
        assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
        assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
        assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());
    }
}