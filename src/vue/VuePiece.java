package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import java.util.List;

import java.awt.*;

public class VuePiece {
    public static final int TAILLE_PAR_DEFAUT = 20;
    public static final double MULTIPLIER_TEINTE = 0.5;
    private Piece piece;
    private int taille;

    public VuePiece(Piece piece) {
        this.piece = piece;
        this.taille = TAILLE_PAR_DEFAUT;
    }

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public Color teinte(Color couleur) {
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();
        int rr = (int)(r + (255 - r) * MULTIPLIER_TEINTE);
        int gg = (int)(g + (255 - g) * MULTIPLIER_TEINTE);
        int bb = (int)(b + (255 - b) * MULTIPLIER_TEINTE);
        return new Color(rr, gg, bb);
    }

    public void afficherPiece(Graphics2D g2D) {
        List<Element> elements = piece.getElements();


        g2D.setColor(teinte(elements.get(0).getCouleur().getCouleurPourAffichage()));
        g2D.fill3DRect(elements.get(0).getCoordonnees().getAbscisse() * taille,
                elements.get(0).getCoordonnees().getOrdonnee() * taille, taille, taille, true);
        System.out.println(elements.get(0).getCoordonnees());

        g2D.setColor(elements.get(0).getCouleur().getCouleurPourAffichage());
        for (int i = 1; i < elements.size(); i++) {
            g2D.fill3DRect(elements.get(i).getCoordonnees().getAbscisse() * taille,
                    elements.get(i).getCoordonnees().getOrdonnee() * taille, taille, taille ,true);
        System.out.println(elements.get(i).getCoordonnees());
        }
    }
}