package army.weapon;

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.game.GameEntity;
import gameframework.game.MoveBlocker;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import static warmen.entity.Mountain.RENDERING_SIZE;

public class Sword extends WeaponAbstract implements Drawable, MoveBlocker, GameEntity{
    
    private static final float DEFENSE = 1;
    private static final float ATTACK = 15;
    private static final float RESISTANCE = 1;
    
    protected static DrawableImage image = null;
    int x, y;
    public static final int RENDERING_SIZE = 16;
    
    
    public Sword() {
        super(DEFENSE, ATTACK, RESISTANCE);
    }

    public Sword(Canvas defaultCanvas, int xx, int yy) {
        super(DEFENSE, ATTACK, RESISTANCE);
        image = new DrawableImage("images/sword.png", defaultCanvas);
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
