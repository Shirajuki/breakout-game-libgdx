package com.shirajuki.breakoutlibgdx;

// Singleton class configuration
public class Configuration {
  public static final int GAME_WIDTH = 960;
  public static final int GAME_HEIGHT = 640;
  public static final int BLOCK_WIDTH = 135;
  public static final int BLOCK_HEIGHT = 30;
  private static Configuration instance = new Configuration(); // eagerly loads the singleton

  private Configuration() {
    // private to prevent anyone else from instantiating
  }

  public static Configuration getInstance() {
    return instance;
  }
}