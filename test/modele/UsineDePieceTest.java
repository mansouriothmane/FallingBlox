package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsineDePieceTest {

    @Test
    public void testModeCyclic() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece;

        int nbCycles = 10;
        for (int i=0; i<nbCycles; i++) {
            piece = UsineDePiece.genererPiece();
            Assertions.assertEquals(
                    new OPiece(new Coordonnees(2, 3), Couleur.ROUGE).toString(),
                    piece.toString()
            );

            piece = UsineDePiece.genererPiece();
            Assertions.assertEquals(
                    new IPiece(new Coordonnees(2, 3), Couleur.JAUNE).toString(),
                    piece.toString());
        }
    }
}