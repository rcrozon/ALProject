package army.weapon;

import static army.weapon.Sword.image;
import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.game.GameEntity;
import gameframework.game.MoveBlocker;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Shield extends WeaponAbstract implements Drawable, MoveBlocker, GameEntity{
	private static final float DEFENSE = 10;
	private static final float ATTACK = 0;
	private static final float RESISTANCE = 1;

        protected static DrawableImage image = null;
        int x, y;
        public static final int RENDERING_SIZE = 16;
    
        public Shield() {
            super(DEFENSE, ATTACK, RESISTANCE);
	}
        
	public Shield(Canvas defaultCanvas, int xx, int yy) {
            super(DEFENSE, ATTACK, RESISTANCE);
            image = new DrawableImage("images/shield.png", defaultCanvas);
            x = xx;
            y = yy;
	}

	public void fix() {
            resistance = RESISTANCE;
	}
        
        public void draw(Graphics g) {
            g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE,null);
        }

        public Point getPos() {
            return (new Point(x, y));
        }

        public Rectangle getBoundingBox() {
            return (new Rectangle(x, y, RENDERING_SIZE, RENDERING_SIZE));
        }
}	