package com.leo.main;

import com.leo.renderengine.DisplayManager;
import com.leo.renderengine.Loader;
import com.leo.renderengine.RawModel;
import com.leo.renderengine.Renderer;

public class Main {

    public static void main(String[] args) {

        DisplayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        // OpenGL expects vertices to be defined counter clockwise because of backface culling
        float[] vertices = {
                // Left bottom triangle
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                // Right top triangle
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f,
                -0.5f, 0.5f, 0f
        };

        RawModel model = loader.loadToVAO(vertices);

        while(!DisplayManager.shouldClose()) {

            renderer.prepare();

            renderer.render(model);

            DisplayManager.updateDisplay();

        }

        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}