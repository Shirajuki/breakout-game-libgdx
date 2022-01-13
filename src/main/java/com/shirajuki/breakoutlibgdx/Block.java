package com.shirajuki.breakoutlibgdx;

public class Block extends Entity {
  boolean destroyed = false;

  public Block(int x, int y, int width, int height) {
    super(x, y, width, height, 0, 0);
  }

}
