# Java City Organizer

This project was created for my Programming Languages class to learn Java and the visitor pattern.

CityStart.java is the starting point of the program. RunTests.java will run a series of tests then exit the program.

There is a menu in the program, the current city grid is also printed out above the menu each time. <br />
```
1) Set Tile
2) Make Default City
3) Count Zones
4) Set Tile Color
5) Rezone
6) Fix Roads
0) Quit
```
Set tile allows the user to change a tile in the city.<br />
Option 2 will set up the city to a default map.<br />
Count Zones will tell the user how many of each tile is in the city at that time.<br />
Option 4 allows the user to change the color of different types of tiles. (Your terminal needs to support ANSII text coloring.)<br />
Rezone will convert empty tiles to a greenspace tile if there is sufficent open areas in the city.<br />
Option 6 will fix how the roads look so they will all look connected with eachother.<br />
Finally option 0 will exit the program.<br />

The different tiles are represented like so: <br />
Greenspace: ░ <br />
Building: ⌂ <br />
Road: ━ <br />
Empty: ▫ <br />
Water: ~ <br />
