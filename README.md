# Restaurant Simulator

## Purpose of the project

This project was made to provide the user with a fun little game. The game brings back nostalgic feelings for a great number of players because of the restaurant setting and gameplay which people remember from their childhood.

## How to play

1. Download the zip file in which the game files are.
2. Open terminal and navigate to the root of the project named 'RestaurantSimulator'
3. Ensure you have maven installed. If not, install using chocolately on windows: choco install maven
4. Next up: run the game: Paste this into powershell. If your java jdk lives in a different location, change the path:
   $env:JAVA_HOME="C:\Program Files\Java\jdk-25.0.4.1"
   mvn -f RestaurantSimulator/pom.xml compile exec:java "-Dexec.mainClass=com.mycompany.restaurantsimulator.RestaurantSimulator"

## Gameplay

1. Click the customer at the door to help them to their seat, all green tables are suited for this customer.
2. Click the table at which you put a customer to open the window for that table.
3. Click 'retrieve order'
4. In the bottom left corner you can click the button to view all orders.
5. In the bottom right corner you can click the button to view every food you made.
6. Prepare the food for the order. (drinks and cold food don't have to be made)
7. Once you have made all food you need you can serve the customer (this will include their drinks and cold food automatically)
8. Once you have served a table you can get the check and sent them home, the table is now free for another customer!
9. Make your business great!
