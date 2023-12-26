package lamoreaux_landon;

public class Road extends Tile {

    Road() {
        charRep = colorText.colorString("━", ColorText.Color.BLACK);
    }

    /**
     * Accepts the visitor.
     * @param v The visitor.
     */
    public void accept(Visitor v) {
        v.visit(this);
    }
}
