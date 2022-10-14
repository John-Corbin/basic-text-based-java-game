package text_game;

import java.util.Scanner;
import java.util.Random;
public class my_text_game {
	
	public static void cPrintln(String message, int n) {  		// code for system.out shortcut
		  for (int i = 0; i < n; i++)
		    System.out.println(message);
		}
	public static void main(String[] args) {

		// System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		// Game variables
		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;

		// weapon type variables
		
//	String[] weapon_small = {"Dagger"};
//		int maxWeapSDamage = 25;
		
//		String[] weapon_mid = {"Longsword"};
//		int maxWeapMDamage = 40;
		
//		String[] weapon_large = {"Greatsword"};
//		int MaxWeapLDamage = 50;
		
		
		
		// Player variables
		int health = 100;
		int attackDmg = 50;
		int numHealthPots = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; // Percentage

		boolean running = true;

		cPrintln("Welcome to the dungeon!", 1);

		// Label
		GAME:
		while (running) {
			cPrintln("--------------------------------------------------", 1);
			
			
			
			
			cPrintln("You have entered the dungeon what will you do now?", 1);
			cPrintln("1. Venture Forth", 1);
			cPrintln("2. Run away in terror", 1);
			String Binput = in.nextLine();
			if (Binput.equals("1")) {
				cPrintln("You move forward into the dark tunnels .", 1);
			}
			
			else if (Binput.equals("2")) {
				cPrintln("You flee from the dungeon like a coward.", 1);
				break;
			}
			else {
				cPrintln("\tInvalid command", 1);
			}
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			cPrintln("A " + enemy + " has appeared!", 1);
			cPrintln("What do you wish to do", 1);
			cPrintln("1. Attack the " + enemy , 1);
			cPrintln("2. Run away in fear", 1);
			String Einput = in.nextLine();
			if (Einput.equals("1")) {
				cPrintln("You ready yourself for combat", 1);
			}
			else if (Einput.equals("2")) {
				cPrintln("You flee from the " + enemy + " like a coward.", 1);
				break;
			}
			else {
				cPrintln("\tInvalid command", 1);
			}
			while (enemyHealth > 0) {
				cPrintln("Your HP: " + health, 1);
				cPrintln("" + enemy + "'s HP: " + enemyHealth, 1);
				cPrintln("What would you like to do?", 1);
				cPrintln("1. Attack", 1);
				cPrintln("2. Drink health potion", 1);
				cPrintln("3. Run", 1);

				String input = in.nextLine();
				if (input.equals("1")) {
					int damageDealt = rand.nextInt(attackDmg);
					int damageTaken = rand.nextInt(enemyAttackDamage);

					enemyHealth -= damageDealt;
					health -= damageTaken;

					cPrintln("> You strike the " + enemy + " with your "  + " For " + damageDealt + " damage", 1);
					cPrintln("> You recieved " + damageTaken + " in retaliation", 1);

					if (health < 1) {
						cPrintln("\t You have taken too much damage, you are too weak to go on", 1);
						break;
					}
				} else if (input.equals("2")) {

					if (numHealthPots > 0) {
						health += healthPotionHealAmount;
						numHealthPots--;
						cPrintln("> You drank a health potion, healed for: " + healthPotionHealAmount + "."
								+ "> You now have" + health + "HP."
								+ "> You now have" + numHealthPots + " health potions left.", 1);
					} else {
						cPrintln("> You have no health potions, defeat enemies for a chance to get one", 1);
					}

				} else if (input.equals("3")) {
					cPrintln("> You run away from the " + enemy, 1);
					continue GAME;
				} else {
					cPrintln("\tInvalid command", 1);
				}
			}
			if (health < 1) {
				cPrintln("You collapse in a heap on the floor eventually dying of your wounds.", 1);
				break;
			}
			cPrintln("--------------------------------------", 1);
			cPrintln(" # " + enemy + " was defeated! # ", 1);
			cPrintln(" # You have " + health + "HP left # ", 1);
			// If the random number is less than 50 it drops
			if (rand.nextInt(100) < healthPotionDropChance) {
				numHealthPots++;
				cPrintln(" # The " + enemy + " dropped a health potion. # ", 1);
				cPrintln(" # You now have " + numHealthPots + " health potion(s). # ", 1);
			}
			cPrintln("--------------------------------------", 1);
			cPrintln("What would you like to do now?", 1);
			cPrintln("1. Continue exploring", 1);
			cPrintln("2. Exit the dungeon", 1);
			String input = in.nextLine();

			while (!input.equals("1") && !input.equals("2")) {
				cPrintln("invalid command", 1);
				input = in.nextLine();

			}
			if (input.equals("1")) {
				cPrintln("You continue your adventure.", 1);
			} else if (input.equals("2")) {
				cPrintln("You exit the dungeon.", 1);
				break;
			}
		}
		cPrintln("######################", 1);
		cPrintln("# THANKS FOR PLAYING #", 1);
		cPrintln("######################", 1);
	}
}