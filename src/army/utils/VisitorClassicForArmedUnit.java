package army.utils;
import army.soldier.ArmedUnit;
import army.soldier.ArmedUnitSquad;

public interface VisitorClassicForArmedUnit {
	void visit(ArmedUnit s);
	void visit(ArmedUnitSquad a);
}
 