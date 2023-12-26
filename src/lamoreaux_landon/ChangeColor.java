package lamoreaux_landon;

public class ChangeColor implements Visitor {
    private ColorText colorText;
    private ColorText.Color color;
    private int tileType;

    ChangeColor(int tile, int colorChoice) {
        colorText = new ColorText();
        color = switch (colorChoice) {
            case 1 -> ColorText.Color.RED;
            case 2 -> ColorText.Color.ORANGE;
            case 3 -> ColorText.Color.BLUE;
            case 4 -> ColorText.Color.GREEN;
            default -> ColorText.Color.BLACK;
        };
        tileType = tile;
    }
    @Override
    public void visit(Empty empty) {
        return;
    }

    @Override
    public void visit(Building building) {
        if(tileType == 1) {
            building.charRep = colorText.colorString("⌂", color);
        }
    }

    @Override
    public void visit(Water water) {
        if(tileType == 3) {
            water.charRep = colorText.colorString("~", color);
        }
    }

    @Override
    public void visit(GreenSpace greenSpace) {
        if(tileType == 3) {
            greenSpace.charRep = colorText.colorString("░", color);
        }
    }

    @Override
    public void visit(Road road) {
        if(tileType == 2) {
            road.charRep = colorText.colorString("━", color);
        }
    }

    @Override
    public void visit(Tile tile) {
        return;
    }
}
