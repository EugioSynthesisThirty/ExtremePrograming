package formation.xp.game.piece;

import java.awt.Color;

public enum ColorPiece {
    ROUGE(222, 49, 99),
    ORANGE(255, 127, 80),
    ORANGE_CLAIR(255, 191, 0),
    JAUNE(223, 255, 0),
    KAKI(87, 204, 142),
    CYAN(28, 168, 154),
    BLEU(38, 105, 230),
    VIOLET(119, 73, 254);

    public final Color color;

    private ColorPiece(int r, int g, int b) {
        color = new Color(r, g, b);
    }
}
