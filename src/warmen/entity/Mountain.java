/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warmen.entity;

/**
 *
 * @author Romain
 */

import gameframework.base.Drawable;
import gameframework.base.DrawableImage;
import gameframework.game.GameEntity;
import gameframework.game.MoveBlocker;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Mountain implements Drawable, MoveBlocker, GameEntity {
    
    protected static DrawableImage image = null;
    int x, y;
    public static final int RENDERING_SIZE = 16;

    public Mountain(boolean isBorderMountain, Canvas defaultCanvas, int xx, int yy) {
        if (isBorderMountain)
            image = new DrawableImage("images/mountain3.png", defaultCanvas);
        else
            image = new DrawableImage("images/mountain4.png", defaultCanvas);
        x = xx;
        y = yy;
    }

    public void draw(Graphics g) {
        g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE,
                            null);
    }

    public Point getPos() {
        return (new Point(x, y));
    }

    public Rectangle getBoundingBox() {
        return (new Rectangle(x, y, RENDERING_SIZE, RENDERING_SIZE));
    }
}
