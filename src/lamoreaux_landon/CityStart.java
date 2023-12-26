package lamoreaux_landon;

/**
 * Grading tags in for all lines marked with *		        Yes
 *
 * The visitor pattern is used 				                Yes
 * Handles bad input with 1 try-catch			            Yes
 * Threw the exception in tier 8 (rezone)			        Yes
 *
 * Tier 1: running and menu working 			            Yes
 * Tier 2: set any object at 0, 0 				            Yes
 * Tier 3: set any object a anywhere			            Yes
 * Tier 4: handles bad input at this point			        Yes
 * Tier 5: default grid displays properly 			        Yes
 * Tier 6: count types * 					                Yes
 * Tier 7: coloring and menus completed*			        Yes
 * Tier 8: Rezone *					                        Yes
 * Tier 9: Fix roads*			  		                    Yes
 *      All adjacent pullable objects removed		        Yes
 *      At least one pullable objects are pulled inwards	Yes
 */


import javax.management.BadAttributeValueExpException;
import java.util.Scanner;

public class CityStart {
    public static Scanner cin;

    /**
     * The entry point to the program.
     *
     * @param args The arguments passed in.
     */
    public static void main(String[] args) {
        boolean badInput = false;
        String test;
        GetCounts visitor = new GetCounts();

        City c = new City();
        cin = new Scanner(System.in);
        String menu =
                "1) Set Tile\n"+
                "2) Make Default City\n"+
                "3) Count Zones\n"+
                "4) Set Tile Color\n"+
                "5) Rezone\n"+
                "6) Fix Roads\n"+
                "0) Quit\n";
        int input = -1;

        while(input != 0) {

            // Printing out the city layout and the menu.
            System.out.println(c);
            System.out.println(menu);

            try {
                System.out.print("Choice:> ");
                input = cin.nextInt();

                // Checking if the number is a menu option or not.
                if (input < 0 || input > 6) {
                    System.out.println("number is out of range");
                    continue;
                }

                // Deciding what to do with the users input.
                switch (input) {
                    case 1:
                        c.setSpot(cin);
                        break;
                    case 2:
                        c.setDefault();
                        break;
                    case 3:
                        c.getCounts();
                        break;
                    case 4:
                        c.changeColor(cin);
                        break;
                    case 5:
                        c.rezone();
                        break;
                    case 6:
                        c.fixRoads();
                }
            }
            // Catching any exeptions that may arrise.
            catch(NumberFormatException e) {
                System.out.println("Please input an integer");
            }
            catch(BadAttributeValueExpException e) {
                System.out.println("insufficient open areas");
            }
            catch(Exception e) {
                test = cin.next();
                System.out.println("Please input an integer");
            }
        }
    }
}
