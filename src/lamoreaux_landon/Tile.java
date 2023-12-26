package lamoreaux_landon;

public class Tile {
    protected String charRep;
    protected int adjCode;

    protected ColorText colorText = new ColorText();

    public String getChar() {
        return charRep;
    }

    @Override
    public String toString() {
        return charRep;
    }

    /**
     * Accepts the visitor.
     * @param v The visitor.
     */
    public void accept(Visitor v) {
        v.visit(this);
    }

    /**
     * \brief Indicate the road tiles adjacent to this one
     *
     * The road time image chosen is dependent on the surrounding tiles.
     * This is where the adjacency of road tiles is indicated.
     *
     * \param left True if road tile to left
     * \param top True if road tile to top
     * \param bot True if road tile to lower left
     * \param right True if road tile to lower right
     */
    public void setAdjacencies(boolean left, boolean top, boolean bot, boolean right) {
        // Create the adjacency code
        int code = (left ? 1 : 0) | (top ? 2 : 0) | (bot ? 4 : 0) | (right ? 8 : 0);
        if (adjCode == code) {
            // We are already set. Do nothing
            return;
        }

        //unicode starts at 2510
        char[] symbols = {
                '━',      // 0 right
                '━',      // 1 right
                '┃',      // 2 ud
                '┛',      // 3 lu
                '┃',      // 4 ud
                '┓',      // 5 ld
                '┃',      // 6 ud
                '┫',     // 7 lud
                '━',      // 8 right
                '━',      // 9 right
                '┗',      // 10 top
                '┻',     // 11 lur
                '┏',      // 12 dr
                '┳',    // 13 ldr
                '┣',     // 14 udr
                '╋'    // 15 ludr
        };

        // Select the appropriate image
        adjCode = code;
        charRep = colorText.colorString(symbols[code], ColorText.Color.BLACK);
    }
}
