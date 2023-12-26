package lamoreaux_landon;

public interface Visitor {
    void visit(Empty empty);
    void visit(Building building);
    void visit(Water water);
    void visit(GreenSpace greenSpace);
    void visit(Road road);
    void visit(Tile tile);
}
