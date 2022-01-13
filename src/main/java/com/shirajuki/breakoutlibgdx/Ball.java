package com.shirajuki.breakoutlibgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends Entity {

  public Ball(int x, int y, int size, int dx, int dy) {
    super(x, y, size, size, dx, dy);
  }

  public void update() {
    this.x += this.dx;
    this.y += this.dy;
    if (x < 0 || x > Gdx.graphics.getWidth()) {
      this.dx = -this.dx;
    }
    if (y < 0 || y > Gdx.graphics.getHeight()) {
      this.dy = -this.dy;
    }
  }

  public void checkCollision(Paddle paddle) {
    if (collidesWith(paddle)) {
      this.color = Color.GREEN;
      this.dy = -this.dy;
    } else {
      this.color = Color.WHITE;
    }
  }

  // http://jeffreythompson.org/collision-detection/circle-rect.php
  private boolean collidesWith(Paddle paddle) {
    // temporary variables to set edges for testing
    double testX = this.x;
    double testY = this.y;

    // which edge is closest?
    if (this.x < paddle.x)
      testX = paddle.x; // test left edge
    else if (this.x > paddle.x + paddle.width)
      testX = paddle.x + paddle.width; // right edge
    if (this.y < paddle.y)
      testY = paddle.y; // top edge
    else if (this.y > paddle.y + paddle.height)
      testY = paddle.y + paddle.height; // bottom edge

    // get distance from closest edges
    double distX = this.x - testX;
    double distY = this.y - testY;
    double distance = Math.sqrt((distX * distX) + (distY * distY));

    // if the distance is less than the radius, collision!
    return distance <= this.width;
  }

  public void draw(ShapeRenderer shape) {
    shape.setColor(this.color);
    shape.circle(this.x, this.y, this.width);
  }
}
