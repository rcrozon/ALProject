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

public class Tree implements Drawable, MoveBlocker, GameEntity {
	protected static DrawableImage image = null;
	int x, y;
	public static final int RENDERING_SIZE = 16;

	public Tree(Canvas defaultCanvas, int xx, int yy) {
		image = new DrawableImage("images/tree.png", defaultCanvas);
		x = xx;
		y = yy;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE, null);
	}

	public Point getPos() {
		return (new Point(x, y));
	}

	public Rectangle getBoundingBox() {
		return (new Rectangle(x, y, RENDERING_SIZE, RENDERING_SIZE));
	}
}