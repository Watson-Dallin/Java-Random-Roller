import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Define the player's stats in a map.
        HashMap<String, Integer> player = new HashMap<String, Integer>();
        player.put("Melee", roll(1,6));
        player.put("Ranged", roll(1,6));
        player.put("Magic", roll(1,6));
       

        // Define the enemy's somewhat random stats in a map.
        HashMap<String, Integer> enemy = new HashMap<String, Integer>();
        enemy.put("Melee", roll(1,3));
        enemy.put("Ranged", roll(1,4));
        enemy.put("Magic", 1);
        
        System.out.println("You encounter an angry goblin in the woods! What do you do?");

        // Run the menu loop.
        menu(player, enemy);
    }

    static void menu(HashMap<String, Integer> player, HashMap<String, Integer> enemy) {
        Scanner cin = new Scanner(System.in); // "cin" after my C++ habits.

        boolean done = false;
        while (!done){
            System.out.println("1. Attack the goblin with melee. ("+player.get("Melee")+" vs "+ enemy.get("Melee")+")");
            System.out.println("2. Attack the goblin at range.("+player.get("Ranged")+" vs "+ enemy.get("Ranged")+")");
            System.out.println("3. Attack the goblin with magic.("+player.get("Magic")+" vs "+ enemy.get("Magic")+")");
            System.out.println("4. Flee the encounter! (tip: Goblin has infinite health)");
            System.out.println("Enter the number of your choice: ");
            
            int choice = 0;

            try {
                choice = cin.nextInt(); 
            } catch (Exception e) {
                System.out.println("Error");
                choice = 4;
            }
            
            if (choice == 1) { 
               faceoff(player.get("Melee"), enemy.get("Melee"));
            }
            else if (choice == 2) {
                faceoff(player.get("Ranged"), enemy.get("Ranged"));
            }
            else if (choice == 3) {
                faceoff(player.get("Magic"), enemy.get("Magic"));
            }
            else if (choice == 4) {
                done = true;
                System.out.println("\nYou have left the encounter.\n");
                cin.close();
            }
        }

        
    }

    static int roll(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    static void faceoff(int atkStat, int defStat) {
        int atk = 0;
        for (int i = 0; i < atkStat; i++) {
            atk += roll(1,6);
        }

        int def = 0;
        for (int i = 0; i < defStat; i++) {
            def += roll(1,6);
        }

        if (atk > def) {
            System.out.println("\nYou Dealt "+(atk-def)+" Damage!\n" );
        }
        else {
            System.out.println("\nYour attack failed\n");
        }
    }
}