package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;

public class UsineDePiece {
    enum PieceType { OPIECE, IPIECE }
    public static final int ALEATOIRE_COMPLET = 0;
    public static final int ALEATOIRE_PIECE = 1;
    public static final int CYCLIC = 2;
    private static int mode = ALEATOIRE_PIECE;
    private static PieceType current = null;

    private UsineDePiece() {}

    public static void setMode(int mode_) {
        mode = mode_;
    }

    public static Piece genererPiece() {
        return switch (mode) {
            case ALEATOIRE_COMPLET -> genererPieceAleatoireComplet();
            case ALEATOIRE_PIECE -> genererPieceAleatoirePiece();
            case CYCLIC -> genererPieceCyclic();
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        };
    }

    private static Piece genererPieceAleatoireComplet() {
        Random rand = new Random();
        PieceType pieceType = PieceType.values()[rand.nextInt(PieceType.values().length)];
        Couleur couleur = Couleur.values()[rand.nextInt(Couleur.values().length)];
        return newPiece(pieceType, couleur);
    }

    private static Piece genererPieceAleatoirePiece() {
        Random rand = new Random();
        PieceType pieceType = PieceType.values()[rand.nextInt(PieceType.values().length)];
        return newPieceDefaultColor(pieceType);
    }

    private static Piece genererPieceCyclic() {
        if (current == null) {
            current = PieceType.OPIECE;
        } else {
            current = PieceType.values()[(current.ordinal() + 1) % PieceType.values().length];
        }
        return newPieceDefaultColor(current);
    }

    private static Piece newPiece(PieceType pieceType, Couleur couleur) {
        return switch (pieceType) {
            case OPIECE -> new OPiece(new Coordonnees(2, 3), couleur);
            case IPIECE -> new IPiece(new Coordonnees(2, 3), couleur);
        };
    }

    private static Piece newPieceDefaultColor(PieceType pieceType) {
        return switch (pieceType) {
            case OPIECE -> new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
            case IPIECE -> new IPiece(new Coordonnees(2, 3), Couleur.JAUNE);
        };
    }
}