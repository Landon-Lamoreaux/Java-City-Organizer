package lamoreaux_landon;

public class GetCounts implements Visitor {
    private int emptyCount;
    private int buildingCount;
    private int waterCount;
    private int greenspaceCount;
    private int roadCount;

    GetCounts() {
        emptyCount = waterCount = buildingCount = greenspaceCount = roadCount = 0;
    }
    @Override
    public void visit(Empty empty) {
        emptyCount++;
    }

    @Override
    public void visit(Building building) {
        buildingCount++;
    }

    @Override
    public void visit(Water water) {
        waterCount++;
    }

    @Override
    public void visit(GreenSpace greenSpace) {
        greenspaceCount++;
    }

    @Override
    public void visit(Road road) {
        roadCount++;
    }

    @Override
    public void visit(Tile tile) {
        return;
    }

    public int getEmptyCount() {
        return emptyCount;
    }

    public int getBuildingCount() {
        return buildingCount;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public int getGreenspaceCount() {
        return greenspaceCount;
    }

    public int getRoadCount() {
        return roadCount;
    }
}
