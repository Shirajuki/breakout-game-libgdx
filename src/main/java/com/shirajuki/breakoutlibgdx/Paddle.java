package com.shirajuki.breakoutlibgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends Entity {

  public Paddle(int x, int y, int width, int height) {
    super(x, y, width, height, 0, 0);
  }

  public void update() {
    this.x = Gdx.input.getX();
    // this.y = Gdx.graphics.getHeight() - Gdx.input.getY();
  }

  public void draw(ShapeRenderer shape) {
    shape.setColor(color);
    shape.rect(this.x, this.y, this.width, this.height);
  }
}
