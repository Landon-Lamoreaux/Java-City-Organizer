package lamoreaux_landon;

import javax.management.BadAttributeValueExpException;
import java.util.Scanner;

public class City {

    final private int citySize = 7;
    private Tile[][] city = new Tile[citySize][citySize];

    // Initializing all tiles to start out empty.
    City() {
        int i = 0, j = 0;

        for(i = 0; i < citySize; i++)
        {
            for(j = 0; j < citySize; j++)
            {
                city[i][j] = new Empty();
            }
        }
    }

    /**
     * Putting the city layout into a string to output when someone wants to print the class out.
     * @return A string containing the layout of the city.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0;

        str.append("\n");
        for(i = 0; i < citySize; i++)
        {
            for(j = 0; j < citySize; j++)
            {
                str.append(city[i][j]);
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Setting a spot in the city to a specified type of tile.
     * @param cin The variable that allows us to read in user input.
     */
    public void setSpot(Scanner cin) {
        int tileType = -1;
        int x = -1, y = -1;
        Tile tile = new Empty();
        System.out.print("Input tile type 1) greenspace 2) water 3) road 4) building 5) empty:> ");
        tileType = cin.nextInt();
        if(tileType < 1 || tileType > 5) {
            System.out.println("Number is out of range");
            return;
        }

        // Converting the number entered into a tile type.
        tile = switch (tileType) {
            case 1 -> new GreenSpace();
            case 2 -> new Water();
            case 3 -> new Road();
            case 4 -> new Building();
            case 5 -> new Empty();
            default -> tile;
        };

        System.out.print("Input location (x y): ");
        //System.out.println(this);
        x= cin.nextInt();
        y= cin.nextInt();
        if (x >= 0 && x < 7 && y >= 0 && y < 7) {
            city[y][x] = tile;
            return;
        }
        System.out.println("Number is out of range");
    }

    /**
     * Setting the city to a default layout.
     */
    public void setDefault() {
        String defaultCity = "━━━━━━━━⌂━▫━▫▫━━━━━~~━⌂━▫━░~━⌂▫⌂━░~━⌂⌂⌂━░~━━━━━░~";
        int i = 0, j = 0, k = 0;

        for(i = 0; i < 7; i++) {
            for(j = 0; j < 7; j++) {
                city[i][j] = switch (defaultCity.charAt(k)) {
                    case '━' -> new Road();
                    case '⌂' -> new Building();
                    case '▫' -> new Empty();
                    case '~' -> new Water();
                    case '░' -> new GreenSpace();
                    default -> new Tile();
                };
                k++;
            }
        }
    }

    /**
     * Finding out how many times each tile type appears in the city.
     * Then printing them out to the screen.
     */
    // GRADING COUNT
    public void getCounts() {
        int i = 0, j = 0;
        GetCounts counts = new GetCounts();

        for(i = 0; i < 7; i++) {
            for(j = 0; j < 7; j++) {
                city[i][j].accept(counts);
            }
        }
        System.out.println("Empty: " + counts.getEmptyCount());
        System.out.println("Buildings: " + counts.getBuildingCount());
        System.out.println("Greenspaces: " + counts.getGreenspaceCount());
        System.out.println("Roads: " + counts.getRoadCount());
        System.out.println("Water: " + counts.getWaterCount());
    }

    /**
     * Changing the color of the tiles specified by the user to the color requested by the user.
     * @param cin The variable that lets us read in user input.
     */
    // GRADING COLOR
    public void changeColor(Scanner cin) {
        ChangeColor color;
        int structure = 0, colorChoice;
        int i = 0, j = 0;

        System.out.print("Input tile type 1) building 2) road 3) non-structure:> ");
        structure = cin.nextInt();
        if(structure < 1 || structure > 3) {
            System.out.println("number is out of range");
            return;
        }

        System.out.print("Input color 1) red 2) orange 3) blue 4) green 5) black:> ");
        colorChoice = cin.nextInt();
        if(colorChoice < 1 || colorChoice > 5) {
            System.out.println("number is out of range");
            return;
        }

        color = new ChangeColor(structure, colorChoice);

        for(i = 0; i < 7; i++) {
            for(j = 0; j < 7; j++) {
                city[i][j].accept(color);
            }
        }
    }

    /**
     * Turns empty tiles into greenspace tiles if there are less than 5 empty tiles.
     * @throws BadAttributeValueExpException If there are more than 5 empty tiles.
     */
    // GRADING REZONE
    public void rezone() throws BadAttributeValueExpException {
        int i = 0, j = 0;
        Rezone rezone = new Rezone(city);
        GetCounts counts = new GetCounts();

        for(i = 0; i < 7; i++) {
            for(j = 0; j < 7; j++) {
                city[i][j].accept(counts);
            }
        }

        if(counts.getEmptyCount() >= 5) {
            throw new BadAttributeValueExpException("insufficient open areas");
        }

        for(i = 0; i < 7; i++) {
            for(j = 0; j < 7; j++) {
                city[i][j].accept(rezone);
            }
        }
    }

    /**
     * Fixing the roads so they visually connect to each other in the city layout.
     */
    public void fixRoads() {
        int i, j;
        FixRoads fixRoads = new FixRoads(city);

        for(i = 0; i < 7; i++) {
            for(j = 0; j < 7; j++) {
                city[i][j].accept(fixRoads);
            }
        }

        return;
    }
}
