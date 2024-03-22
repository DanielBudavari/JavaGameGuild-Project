/* Assignment #: 5
//         Name: Daniel Budavari
//    StudentID: 1224612207
//      Lecture: TU THUR 1:30
//  Description: This program allows users to create and add heroes to their guild, 
//    compute combat points for their heroes, calculate the number of heroes above a 
//    user-specified combat point threshold, and display all the heroes in the guild. 
*/
//PlayerEntity is an abstract class. It represents the basic attributes of any player (hero) in the program and is at the root of the player hierarchy. 
import java.text.NumberFormat;
public abstract class PlayerEntity {
	
	NumberFormat pctFmt = NumberFormat.getPercentInstance();
	protected int cCombatPts;
	protected int stamina;
	protected int attack;
	protected double health;
	protected String entityName;
	protected String weapon;

	//The attributes health, entityName, attack, stamina and weapon are initialized to the value of the parameters in the header. 
	//Current combat points should be initialized to zero.
	//u + the variable (i.e. uHealth) was chosen to denote variable info that derives from a user input in Assignment5.java
	public PlayerEntity (double uHealth, String name, int uStamina, int uAttack, String uWeapon) {
		
		health = uHealth;
		entityName = name;
		stamina = uStamina;
		attack = uAttack;
		weapon = uWeapon;
		cCombatPts = 0;
	}
	
	//The following accessor method that returns combat points:
	public int getCombatPoints() {
			return cCombatPts;
	}

	//The PlayerEntity class also has an abstract method that must be implemented by the child classes Mage and Fighter to update the combat power: 
	public abstract void computeCombatPower();


	//Parent toString method, Fighter and Mage add further info
	public String toString() {
			
		return ("Hero name:\t\t" + entityName 
			+ "\nCurrent Health:\t\t" + health 
			+ "\nStamina:\t\t"+ stamina 
			+ "\nAttack Damage:\t\t" + attack
			+ "\nWeapon:\t\t\t" + weapon
			+ "\nCurrent Combat Points:\t" + cCombatPts
			+ "\n");
	}
	
}
