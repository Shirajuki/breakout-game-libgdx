package com.shirajuki.breakoutlibgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Entity {
  int x;
  int y;
  int width;
  int height;
  int dx;
  int dy;
  Color color = Color.WHITE;

  public Entity(int x, int y, int width, int height, int dx, int dy) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.dx = dx;
    this.dy = dy;
  }

  public void update() {
  }

  public void draw(ShapeRenderer shape) {
    shape.setColor(color);
    shape.rect(this.x, this.y, this.width, this.height);
  }
}
