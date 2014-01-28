package army.soldier;

import army.utils.VisitorClassicForArmedUnit;
import army.utils.VisitorFunForArmedUnit;
import army.utils.AgeFactory;

public interface ArmedUnit {
	public String getName();
	public float getHealthPoints();
	public AgeFactory getAge();
	public boolean alive();
	public void heal();
	public boolean parry(float force); // true if the receiver is still alive after the strike
	public float strike();
	public void addEquipment(String weaponType);  
	public void accept(VisitorClassicForArmedUnit v);
	public <T> T accept(VisitorFunForArmedUnit<T> v);
}