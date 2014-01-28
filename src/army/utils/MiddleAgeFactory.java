package army.utils;

import army.soldier.SoldierAbstract;
import army.soldier.InfantryMan;
import army.soldier.Horseman;
import army.soldier.Soldier;
import army.weapon.SoldierWithSword;
import army.weapon.SoldierWithShield;

public class MiddleAgeFactory implements AgeFactory {
    
	public SoldierAbstract getSimpleSoldier(String name) {
		return new InfantryMan(name);
	}
 
	public SoldierAbstract getComplexSoldier(String name) {
		return new Horseman(name);
	}
 
	public Soldier getDefensiveWeapon(Soldier s) {
		return new SoldierWithShield(s);
	}
 
	public Soldier getOffensiveWeapon(Soldier s) {
		return new SoldierWithSword(s);
	}
}
