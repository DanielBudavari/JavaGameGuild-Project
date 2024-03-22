/* Assignment #: 5
//         Name: Daniel Budavari
//    StudentID: 1224612207
//      Lecture: TU THUR 1:30
//  Description: This program allows users to create and add heroes to their guild, 
//    compute combat points for their heroes, calculate the number of heroes above a 
//    user-specified combat point threshold, and display all the heroes in the guild. 
*/
//Creates a mage hero, extending the PleyerEntity class, computes Mage combat power, has Mage toString
public class Mage extends PlayerEntity{
	
	private double mana;
	
	//	Initializes mage's stats using the Super constructor of the PlayerEntity class. Mana is initialized with a 6th variable.
	public Mage(double uHealth, String name, int uStamina, int uAttack, String uWeapon, double uMana) {
			
			super(uHealth, name, uStamina, uAttack, uWeapon);
			mana = uMana;
	}
	
    //	Calculates a mage's combat points and uses type-casting in the formula
	public void computeCombatPower() {
		
		//	if a Mage is wielding a Staff, it adds an additional 30 to combatPoints. No other weapon changes the combatPoints.
		if (weapon.equals("Staff")) {
			
			cCombatPts = (int) ( (attack + health) * (1 + mana) + 30 ); 
			
		} else { //Mage does not have a Staff
			
			cCombatPts = (int) ( (attack + health) * (1 + mana) );
		}
	}

	//The toString() method inherited from the PlayerEntity class, creates a new String and display mage information in the following format:
	public String toString() {
		
		return ( ("\nMage Hero:\n") 
				+ (super.toString()) 
				+ ("Mana:\t\t\t" + pctFmt.format(mana) 
				+ "\n") );
	}
}
