package com.leo.main;

import com.leo.renderengine.DisplayManager;
import com.leo.renderengine.Loader;
import com.leo.renderengine.RawModel;
import com.leo.renderengine.Renderer;
import com.leo.shaders.StaticShader;

public class Main {

    public static void main(String[] args) {

        DisplayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        // OpenGL expects vertices to be defined counter clockwise because of backface culling
        float[] vertices = {
                -0.5f, 0.5f, 0f,  // V0
                -0.5f, -0.5f, 0f, // V1
                0.5f, -0.5f, 0f,  // V2
                0.5f, 0.5f, 0f,   // V3
        };

        int[] indices = {
                0, 1, 3, // Top left triangle     (V0, V1, V3)
                3, 1, 2  // Bottom right triangle (V3, V1, V2)
        };

        RawModel model = loader.loadToVAO(vertices, indices);

        while(!DisplayManager.shouldClose()) {

            renderer.prepare();

            shader.start();
            renderer.render(model);
            shader.start();

            DisplayManager.updateDisplay();

        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();

    }

}