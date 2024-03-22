/* Assignment #: 5
//         Name: Daniel Budavari
//    StudentID: 1224612207
//      Lecture: TU THUR 1:30
//  Description: This program allows users to create and add heroes to their guild, 
//    compute combat points for their heroes, calculate the number of heroes above a 
//    user-specified combat point threshold, and display all the heroes in the guild. 
*/
//Creates a Fighter hero, extending the PleyerEntity class, computes Fighter combat power, has Fighter toString
public class Fighter extends PlayerEntity{
	
	private double armor;
	private int maxAttack;
	private boolean isRanged;

	//fighter constructor, super constructor from PlayerEntity class, user input to decide if fighter is a ranger.
	//if fighter is ranged, the stats are altered from a melee fighter.
	public Fighter(double uHealth, String name, int uStamina, int uAttack, String uWeapon, boolean uisRanged) {
		
		super(uHealth, name, uStamina, uAttack, uWeapon);
		isRanged = uisRanged;
		
		if (isRanged == true) { //fighter is ranged
			
			armor = 0.25;
			maxAttack = 125;
			
		} else {					//fighter is melee
			
			armor = 0.5;
			maxAttack = 100;
		}
	}
	
    //	Calculates a Fighter's combat points and uses type-casting in the formula
	public void computeCombatPower() {
		
		//If maxAttack is smaller than or equal to the damage a fighter can do with an attack 
		if (maxAttack <= attack) {
			
			cCombatPts = (int) ((maxAttack + health) * (1 - armor));
			
		} else { //If maxAttack is larger
			
			cCombatPts = (int) ((attack + health) * (1 - armor));
		}
		
		//If the fighter is both ranged and equipped with a Rock add an additional 50 to combatPower.
		if(isRanged == true && weapon.equals("Rock")) {
			cCombatPts += 50;
		}
		
		//If the fighter is both melee and equipped with a Sword, double the combatPoints.
		if (isRanged == false && weapon.equals("Sword")){
			cCombatPts *= 2;
		}
	}
	
	//The toString() method inherited from the PlayerEntity class, creates a new String and display fighter information in the following format:
	public String toString() {
			
			if (isRanged == true) {
				
				return("\nFighter Hero:\t\tRanged Type\n") 
						+ (super.toString()) 
						+ ("Armor:\t\t\t" + pctFmt.format(armor) 
						+ "\n");
			} else {
			
				return (("\nFighter Hero:\t\tMelee Type\n") 
						+ (super.toString()) 
						+ ("Armor:\t\t\t" + pctFmt.format(armor) 
						+ "\n"));
			}
	}
}
