package warmen;

import army.weapon.Shield;
import army.weapon.Sword;
import gameframework.base.MoveStrategyKeyboard;
import gameframework.base.MoveStrategyRandom;
import gameframework.game.CanvasDefaultImpl;
import gameframework.game.Game;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.game.GameMovableDriverDefaultImpl;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.game.GameUniverseViewPortDefaultImpl;
import gameframework.game.MoveBlockerChecker;
import gameframework.game.MoveBlockerCheckerDefaultImpl;
import gameframework.game.OverlapProcessor;
import gameframework.game.OverlapProcessorDefaultImpl;

import java.awt.Canvas;
import java.awt.Point;
import warmen.entity.Mountain;
import warmen.entity.Soldier;
import warmen.entity.Tree;
import warmen.rule.GhostMovableDriver;
import warmen.rule.SoldierMoveBlockers;
import warmen.rule.SoldierOverlapRules;


public class GameLevelOne extends GameLevelDefaultImpl {
    
    Canvas canvas;
    // 0 : Background; 1 : Mountains; 2 : Tree; 3 : soldier ; 4 : sword ; 5 : shield ; 
    static int[][] tab = { 
                    { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6, 6, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6, 6, 6, 6, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6, 6, 6, 6, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6, 6, 6, 6, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6, 6, 6, 6, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6, 6, 6, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 7, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
    public static final int SPRITE_SIZE = 16;
    //public static final int NUMBER_OF_GHOSTS = 5;

    public GameLevelOne(Game g) {
            super(g);
            canvas = g.getCanvas();
    }

    @Override
    protected void init() {
        OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();

        MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
        moveBlockerChecker.setMoveBlockerRules(new SoldierMoveBlockers());

        SoldierOverlapRules overlapRules = new SoldierOverlapRules(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE),
                        new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE), life[0], score[0], endOfGame);
        overlapProcessor.setOverlapRules(overlapRules);

        universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
        overlapRules.setUniverse(universe);

        gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
        ((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);


        // Filling up the universe with basic non movable entities and inclusion in the universe
        for (int i = 0; i < 31; ++i) {
            for (int j = 0; j < 28; ++j) {
                switch(tab[i][j]){
                    case 0 :/*universe.addGameEntity(new Soldier(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));*/
                        break;
                    case 1 : universe.addGameEntity(new Mountain(true, canvas, j * SPRITE_SIZE, i * SPRITE_SIZE));
                        break;
                    case 2 : universe.addGameEntity(new Tree(canvas, j * SPRITE_SIZE, i * SPRITE_SIZE));
                        break;
                    case 7 : /*universe.addGameEntity(new Soldier(canvas, j * SPRITE_SIZE, i * SPRITE_SIZE));*/
                        break;
                    case 6 : universe.addGameEntity(new Mountain(false, canvas, j * SPRITE_SIZE, i * SPRITE_SIZE));
                        break;
                    default: universe.addGameEntity(new Mountain(false, canvas, j * SPRITE_SIZE, i * SPRITE_SIZE)); 
                        break;
                }
            }
        }
        //initPlayerArmies(moveBlockerChecker, 10);
        initEnnemyArmy(moveBlockerChecker, 10);
        initAccessories(10, 10);
    }


    public void initAccessories(int nbShields, int nbSwords){
        int shields = nbShields;
        int swords = nbSwords;
        int x, y;
        while(shields > 0){ //  + assert places disponibles supérieure à nb de bouclier à placer
            x = (int)(Math.random() * 31);
            y = (int)(Math.random() * 28);
            if (tab[x][y] == 0){
                shields--;
                universe.addGameEntity(new Sword(canvas, y * SPRITE_SIZE, x * SPRITE_SIZE));// SHIELDS
            }
        }
        while(swords > 0){ //  + assert places disponibles supérieure à nb d'épées à placer
            x = (int)(Math.random() * 31);
            y = (int)(Math.random() * 28);
            if (tab[x][y] == 0){
                swords--;
                universe.addGameEntity(new Shield(canvas, y * SPRITE_SIZE, x * SPRITE_SIZE));// SWORDS
            }
        }
    }

    public void initEnnemyArmy(MoveBlockerChecker moveBlockerChecker, int nbSoldiers){
        int x = 3;
        int mod = nbSoldiers%3;
        int nbColumns = 25-(nbSoldiers/3);
        for(int y = nbColumns; y < 25; y++){
            x = nbSoldiers/3;
            while (x > 0){
                // Army definition and inclusion in the universe
                Soldier soldier = new Soldier(canvas);
                tab[28-x][28-y] = 3;
                soldier.setPosition(new Point((28-y) * SPRITE_SIZE, (28-x) * SPRITE_SIZE));
                
                GameMovableDriverDefaultImpl ghostDriv = new GhostMovableDriver();
                MoveStrategyRandom ranStr = new MoveStrategyRandom();
                ghostDriv.setStrategy(ranStr);
                ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
                soldier.setDriver(ghostDriv);
                universe.addGameEntity(soldier);
                x--;
            }
        }
        for(int i = 0; i < 31; i++){
            for(x = 0; x < 28; x++){
                System.err.print(tab[i][x] + " ");
            }
            System.err.println("");
        }
    }
}
