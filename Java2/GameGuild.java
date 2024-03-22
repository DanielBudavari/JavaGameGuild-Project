/* Assignment #: 5
//         Name: Daniel Budavari
//    StudentID: 1224612207
//      Lecture: TU THUR 1:30
//  Description: This program allows users to create and add heroes to their guild, 
//    compute combat points for their heroes, calculate the number of heroes above a 
//    user-specified combat point threshold, and display all the heroes in the guild. 
*/

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5 {
    public static void main(String[] args){
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the hero objects
        ArrayList<PlayerEntity> playerList = new ArrayList<>();

        try{ System.out.println("Welcome to the battle stats simulator!");
             printMenu();

             // creates a BufferedREader object to read input from a keyboard
             InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader stdin = new BufferedReader(isr);

            do{ System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                
                if(line.length() == 1){
                    switch (input){
                        case 'A': // adds hero to the guild
                            System.out.println("Please enter your hero stats:");
                            inputInfo = stdin.readLine().trim();
                           
                            PlayerEntity newHero = PlayerParser.parseNewPlayer(inputInfo);
                            playerList.add(newHero);
                            break;

                        case 'C': // calculates combat points of all heros in list via calling computeCombatPower from PlayerEntity
                  
                        	for(int loopControl = 0; loopControl < playerList.size(); loopControl++) {
                        		
                        		playerList.get(loopControl).computeCombatPower();
                        	}
                        	
                            System.out.println("Combat points computed");
                            break;

                        case 'D': // Checks how many heros have more than or equal to the minimum combat points by calling getCombatPoints from PlayerEntity and displays it
                            System.out.print("Please enter a minimum combat points you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;
       
                            for(int loopControl = 0; loopControl < playerList.size(); loopControl++) {
                        		
                        		if(playerList.get(loopControl).getCombatPoints() >= min) {
                        			count++;
                        		}
                        	}
                            
                            System.out.println("The number of heroes with " + min
                                    + " combat points or more is: " + count);
                            break;

                        case 'L': // lists heroes if there are no heros, displays message "No heros in guild yet"
                           
                        	if(playerList.size() <= 0) {
                        		
                        		System.out.print("No heroes in guild yet.\n");
                        		
                        	} else {
                        	
                        		for (int i = 0; i < playerList.size(); i++) {
                        			
                        			System.out.print((playerList.get(i).toString() + "\n"));
                        		}
                        	}
                            break;

                        case 'Q':
                            break;

                        case '?':
                            printMenu();
                            break;

                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                }
                else
                    System.out.println("Unknown action");

            }while (input != 'Q');
            System.out.println("Thanks for playing!");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }

    public static void printMenu(){
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Hero\n" +
                "C\t\tCompute Combat Points\n" +
                "D\t\tCount Heroes with Minimum Combat Points\n" +
                "L\t\tList Heroes\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
