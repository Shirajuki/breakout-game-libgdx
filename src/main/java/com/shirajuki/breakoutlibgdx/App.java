package com.shirajuki.breakoutlibgdx;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class App {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setIdleFPS(60);
        config.useVsync(true);
        config.setTitle("Tutorial");

        config.setWindowedMode(960, 640);
        // config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        new Lwjgl3Application(new AppController(), config);
    }
}
