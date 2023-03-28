package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PuitsTest {
    @Test
    void testSetPieceSuivante() {
    }

    @Test
    void testSetProfondeur() {
    }

    @Test
    void testToString() {
        Coordonnees coord1 = new Coordonnees(7,7);
        Coordonnees coord2 = new Coordonnees(15,10);
        Piece piece1 = new IPiece(coord1, Couleur.VERT);
        Piece piece2 = new OPiece(coord2, Couleur.BLEU);
        Puits puits = new Puits(10, 10);

        puits.setPieceSuivante(piece1);
        assertEquals("""
                        Puits : Dimension 10 x 10
                        Piece Actuelle : <aucune>
                        Piece Suivante : IPiece :
                        \t(7, 7) - VERT
                        \t(7, 6) - VERT
                        \t(7, 8) - VERT
                        \t(7, 9) - VERT
                        """, puits.toString());

        puits.setPieceSuivante(piece2);
        assertEquals("""
                        Puits : Dimension 10 x 10
                        Piece Actuelle : IPiece :
                        \t(5, -4) - VERT
                        \t(5, -5) - VERT
                        \t(5, -3) - VERT
                        \t(5, -2) - VERT
                        Piece Suivante : OPiece :
                        \t(15, 10) - BLEU
                        \t(15, 11) - BLEU
                        \t(16, 10) - BLEU
                        \t(16, 11) - BLEU
                        """, puits.toString());
     }
}
