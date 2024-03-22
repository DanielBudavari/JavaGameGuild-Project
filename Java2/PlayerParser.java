/* Assignment #: 5
//         Name: Daniel Budavari
//    StudentID: 1224612207
//      Lecture: TU THUR 1:30
//  Description: This program allows users to create and add heroes to their guild, 
//    compute combat points for their heroes, calculate the number of heroes above a 
//    user-specified combat point threshold, and display all the heroes in the guild. 
*/
//PlayerParser is a utility class that creates a player object (mage or fighter) from a parsable string. 
public class PlayerParser {

	public static PlayerEntity parseNewPlayer(String lineToParse) {
		
		String[] parsedString = new String[7];
		parsedString = lineToParse.split("/");
		
		//Checks if the hero is a fighter or a mage
		if(parsedString[0].equals("fighter") || parsedString[0].equals("Fighter")) {
			
			//The Fighter is a melee since parsedString[0] == melee or Melee
			if(parsedString[6].equals("melee") || parsedString[6].equals("Melee")) {
				
				//s + the variable (i.e. sHealth) was chosen to denote String variable
				String sHealth = parsedString[1];
				double uHealth = Double.parseDouble(sHealth);
				
				String sName = parsedString[2];
			
				String sStamina = parsedString[3];
				int uStamina = Integer.parseInt(sStamina);
				
				String sAttack = parsedString[4];
				int uAttack = Integer.parseInt(sAttack);
				
				String sWeapon = parsedString[5];
				
				boolean isRanged = false;
				
				PlayerEntity heroMelee = new Fighter (uHealth, sName, uStamina, uAttack, sWeapon, isRanged);
				return heroMelee;
				
			} else { //The Fighter is a ranger since parsedString[0] =/= melee or Melee
				
				String sHealth = parsedString[1];
				double uHealth = Double.parseDouble(sHealth);
				
				String sName = parsedString[2];
				
				String sStamina = parsedString[3];
				int uStamina = Integer.parseInt(sStamina);
				
				String sAttack = parsedString[4];
				int uAttack = Integer.parseInt(sAttack);
				
				String sWeapon = parsedString[5];
				
				boolean isRanged = true;
				
				PlayerEntity heroRanged = new Fighter (uHealth, sName, uStamina, uAttack, sWeapon, isRanged);
				return heroRanged;
			}
		} //Since parsedString[0] =/= fighter, a mage hero is created
		if(parsedString[0].equals("mage")|| parsedString[0].equals("Mage")) {
			
			String sHealth = parsedString[1];
			double uHealth = Double.parseDouble(sHealth);
			
			String sName = parsedString[2];
			
			String sStamina = parsedString[3];
			int uStamina = Integer.parseInt(sStamina);
			
			String sAttack = parsedString[4];
			int uAttack = Integer.parseInt(sAttack);
			
			String sWeapon = parsedString[5];
			
			String sMana = parsedString[6];
			double uMana = Double.parseDouble(sMana);
			
			PlayerEntity heroMage = new Mage(uHealth, sName, uStamina, uAttack, sWeapon, uMana);
			return heroMage;
		}
		return null;
	}
}
