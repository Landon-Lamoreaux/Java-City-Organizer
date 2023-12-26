package lamoreaux_landon;

public class Rezone implements Visitor{

    private Tile[][] city;
    private int i, j;
    Rezone(Tile[][] c) {
        city = c;
        i = j = 0;
    }

    /**
     * Remembering where we are in the city, and turning the empty tile passed in into a Greenspace tile.
     * @param empty The empty tile passed in.
     */
    @Override
    public void visit(Empty empty) {
        city[i][j] = new GreenSpace();
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }

    /**
     * Remembering where we are in the city.
     * @param building The building tile passed in.
     */
    @Override
    public void visit(Building building) {
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }

    /**
     * Remembering where we are in the city.
     * @param water The water tile passed in.
     */
    @Override
    public void visit(Water water) {
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }

    /**
     * Remembering where we are in the city.
     * @param greenSpace The Greenspace tile passed in.
     */
    @Override
    public void visit(GreenSpace greenSpace) {
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }

    /**
     * Remembering where we are in the city.
     * @param road The Road tile passed in.
     */
    @Override
    public void visit(Road road) {
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }

    /**
     * Remembering where we are in the city.
     * @param tile The tile passed in.
     */
    @Override
    public void visit(Tile tile) {
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }
}
