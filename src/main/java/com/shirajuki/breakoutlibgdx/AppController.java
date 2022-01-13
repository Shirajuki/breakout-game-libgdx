package com.shirajuki.breakoutlibgdx;

import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class AppController extends Game {
  ShapeRenderer shape;
  Paddle paddle;
  ArrayList<Ball> balls = new ArrayList<>();
  Random r = new Random();

  @Override
  public void create() {
    shape = new ShapeRenderer();
    paddle = new Paddle(100, 50, 160, 20);
    Ball startingBall = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 20, 5 + r.nextInt(10),
        5 + r.nextInt(10));
    // r.nextInt(15)
    balls.add(startingBall);
  }

  @Override
  public void render() {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    shape.begin(ShapeRenderer.ShapeType.Filled);
    for (Ball ball : balls) {
      ball.update();
      ball.checkCollision(paddle);
      ball.draw(shape);
    }
    paddle.update();
    paddle.draw(shape);
    shape.end();
  }
}
