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
  ArrayList<Block> blocks = new ArrayList<>();
  Random r = new Random();

  @Override
  public void create() {
    // Drawing context
    shape = new ShapeRenderer();
    // Paddle
    paddle = new Paddle(100, 50, 160, 20);
    Ball startingBall = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 20, 5 + r.nextInt(10),
        5 + r.nextInt(10));
    balls.add(startingBall);

    // Blocks
    for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight() - 50; y += Configuration.BLOCK_HEIGHT
        + 10) {
      for (int x = 50; x < Gdx.graphics.getWidth() - 50; x += Configuration.BLOCK_WIDTH + 10) {
        blocks.add(new Block(x, y, Configuration.BLOCK_WIDTH, Configuration.BLOCK_HEIGHT));
      }
    }
  }

  @Override
  public void render() {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    shape.begin(ShapeRenderer.ShapeType.Filled);
    // Drawing balls
    for (Ball ball : balls) {
      ball.update();
      ball.draw(shape);
      ball.checkCollision(paddle);
      for (Block b : blocks) {
        ball.checkCollision(b);
      }
    }
    // Drawing blocks
    for (int i = 0; i < blocks.size(); i++) {
      Block b = blocks.get(i);
      b.draw(shape);
      if (b.destroyed) {
        blocks.remove(b);
        // we need to decrement i when a ball gets removed, otherwise we skip a ball!
        i--;
      }
    }

    // Drawing paddle
    paddle.update();
    paddle.draw(shape);
    shape.end();
  }
}
