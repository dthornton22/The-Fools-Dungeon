/*
 * @author Brandon Jett
 * Latest Date Modified: Oct 27, 2020
 * 
 * This class creates item objects that modify the players various values or
 * helps them in some way such as a health pack. 
 * 
 */
package item;
import java.util.Random;


public class Item {
	
	//Variable Declarations
	private int weaponStrength;
	private int armorDefense;
   

	/** This function creates the strength modifier on a weapon
	 *  it takes an input of the current damage modifier on
	 *  the current weapon to ensure that this weapon is better.
	 *  @param int current weapons weapon strength value
	 *  @return none
	*/
	private void setWeaponStrength(int currentStrength)
	{
		Random rand = new Random();
		int n = rand.nextInt(10);				   // Change this number as needed
		weaponStrength = currentStrength + n;   // Current weapon strength + random number
	}
	
	/**
	 * This function returns the current weapons strength.
	 * @param none
	 * @return weaponStrengh the current weapons strength
	 */
	public int getWeaponStrength()
	{
		return weaponStrength;
	}
	
	/** This function creates the defense modifier on a armor
	 *  it takes an input of the current defense modifier on
	 *  the current armor to ensure that this armor is better.
	 *  @param currentDefense current armors armor defense value
	 *  @return none
	*/
	public void setArmorDefense(int currentDefense)
	{
		Random rand = new Random();
		int n = rand.nextInt(10);
		armorDefense = currentDefense + n;
	}
	
	/**
	 * This function returns the current armor defense.
	 * @param none
	 * @return int the current armor defense
	 */
	public int getArmorDefense()
	{
		return armorDefense;
	}
	
	/**
	 * This function determines the type of consumable that drops when called
	 * @param none
	 * @return int 0 = health pack, 1 = strength potion, 2 = defense potion
	 */
	private int determineConsumableType()
	{
		Random rand = new Random();
		int n = rand.nextInt(2);			// I cant recall if it indexes from 0, adjust as needed
		return n;
	}
	
	// This will be edited at some later point. I want to see Player class to 
	// be able to modify this.
	public void healthpack()
	{
		//I feel like I need stuff from player to modify consumables
	}
	
	// This will be edited at some later point. I want to see Player class to 
	// be able to modify this.
	public void strengthPotion()
	{
		//I feel like I need stuff from player to modify consumables
	}
	
	// This will be edited at some later point. I want to see Player class to 
	// be able to modify this.
	public void defensePotion()
	{
		//I feel like I need stuff from player to modify consumables
	}
	
	/**
	 * This function uses a rng to determine what type of item drops in a
	 * given call.
	 * @param none
	 * @return int 0 = weapon, 1 = armor, 2 = other
	 */
	private int determineItemType()
	{
		Random rand = new Random();
		int n = rand.nextInt(2);			// I cant recall if it indexes from 0, adjust as needed
		return n;						   // This return will be given to a function that generates the item
	}
	
	/**
	 * This function will create a item based on the results of determineItemType()
	 * and roll the items stats. As of right now it has no return, I feel like structs
	 * would be good here but luckily Java sucks and doesn't have structs so here we are.
	 * @param none
	 * @return none
	 */
	public void createItem()
	{
		int itemType = determineItemType();
		
		// If the item is to be a weapon, set its weapon strength
		if (itemType == 0)
		{
			setWeaponStrength(weaponStrength);
			// There will be more here to create the item
		}
		
		// If the item is to be armor, set its defense
		if (itemType == 1)
		{
			setArmorDefense(armorDefense);
			// There will be more here to create the item
		}
		
		// If the item is a different thing, do here
		if (itemType == 2)
		{
			//TODO: Determine what other item types are in the game
		}
	}
	
	public static void main(String[] args) {
		// TODO code application logic here
	}
	
}
