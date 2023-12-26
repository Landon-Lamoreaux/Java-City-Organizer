package lamoreaux_landon;

public class FixRoads implements Visitor {

    Tile[][] city;
    int i, j;
    FixRoads(Tile[][] c) {
        city = c;
    }

    /**
     * Remembering where we are in the city.
     * @param empty The Empty tile passed in.
     */
    @Override
    public void visit(Empty empty) {
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }

    /**
     * Remembering where we are in the city.
     * @param building The Building tile passed in.
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
     * @param water The Water tile passed in.
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
     * Changing the shape of the road tile based on where other road tiles are around it.
     * @param road The Road tile passed in.
     */
    @Override
    public void visit(Road road) {
        CheckAdj check = new CheckAdj();
        boolean left = true, top = true, bot = true, right = true;

        // Checking the edges of the city
        if(i == 6) {
            bot = false;
        }
        if(i == 0) {
            top = false;
        }
        if(j == 6) {
            right = false;
        }
        if(j == 0) {
            left = false;
        }

        // GRADING NESTED
        // Checking all the adjacent tiles.
        if(left) {
            city[i][j-1].accept(check);
            left = check.getIsRoad();
        }
        if(right) {
            city[i][j+1].accept(check);
            right = check.getIsRoad();
        }
        if(bot) {
            city[i+1][j].accept(check);
            bot = check.getIsRoad();
        }
        if(top) {
            city[i-1][j].accept(check);
            top = check.getIsRoad();
        }

        // Setting the tile shape based on the adjacent tiles.
        road.setAdjacencies(left, top, bot, right);

        // Remembering where we are in the city.
        j++;
        if(j > 6) {
            j = 0;
            i++;
        }
    }

    /**
     * Remembering where we are in the city.
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
