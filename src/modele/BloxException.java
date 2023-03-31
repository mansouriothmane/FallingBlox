package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends java.lang.Exception {
    public static int BLOX_COLLISION = 0;
    public static int BLOX_SORTIE_PUITS = 1;
    private int type;

    public BloxException(String message, int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
