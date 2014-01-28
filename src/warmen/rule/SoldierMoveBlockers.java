package warmen.rule;

import gameframework.game.IllegalMoveException;
import gameframework.game.MoveBlockerRulesApplierDefaultImpl;
import warmen.entity.Mountain;
import warmen.entity.Tree;

public class SoldierMoveBlockers extends MoveBlockerRulesApplierDefaultImpl {

	public void moveBlockerRule(Tree t, Mountain m) throws IllegalMoveException {
		// The default case is when a ghost is active and not able to cross a
		// wall
//		if (g.isActive()) {
//			throw new IllegalMoveException();
//			// When a ghost is not active, it is able to cross a wall
//		}
	}
}
