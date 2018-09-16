package com.leo.renderengine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {

    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;
    private static final int GL_MAJOR_VERSION = 3;
    private static final int GL_MINOR_VERSION = 2;
    private static final int FPS_CAP = 120;
    private static final String TITLE = "ThinMatrixTutorial";

    public static void createDisplay() {

        // GL Major and Minor versions are OpenGL version numbers
        ContextAttribs attribs = new ContextAttribs(GL_MAJOR_VERSION, GL_MINOR_VERSION).withForwardCompatible(true).withProfileCore(true);

        try {

            Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle(TITLE);

        } catch(LWJGLException e) {
            e.printStackTrace();

        }

        // Setting GL Viewport to use the whole window
        GL11.glViewport(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

    }

    public static void updateDisplay() {

        Display.sync(FPS_CAP);
        Display.update();

    }

    public static void closeDisplay() {

        Display.destroy();

    }

    public static boolean shouldClose() {

        return Display.isCloseRequested();

    }

}
