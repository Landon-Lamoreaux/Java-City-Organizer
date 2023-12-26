package lamoreaux_landon;

public class CheckAdj implements Visitor {

    boolean isRoad;

    @Override
    public void visit(Empty empty) {
        isRoad = false;
    }

    @Override
    public void visit(Building building) {
        isRoad = false;
    }

    @Override
    public void visit(Water water) {
        isRoad = false;
    }

    @Override
    public void visit(GreenSpace greenSpace) {
        isRoad = false;
    }

    @Override
    public void visit(Road road) {
        isRoad = true;
    }

    @Override
    public void visit(Tile tile) {
        isRoad = false;
    }

    public boolean getIsRoad() {
        return isRoad;
    }
}
