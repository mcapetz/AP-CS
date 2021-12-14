/* 
 * The constructor takes a single parameter: String name. 
 * The constructor should create a FantasyCharacter with 
 * 200 energy, 30 attackAccuracy, and 40 healingSkill.
 * 
 * The attack method must be overridden so that the Giant 
 * attacks twice every time the attack method is called.
 * 
 * The specialMove method has the Giant attack and then heal.
 */
public class Giant extends FantasyCharacter {
	
	public Giant(String name) {
		super(name, 200, 30, 40);
	}
	
	public void specialMove(FantasyCharacter c) {
		super.heal();
		super.attack(c);
	}
	
	@Override
	public void attack(FantasyCharacter c) {
		for(int i = 0; i < 2; i++) {
			super.attack(c);
		}
	}
}
