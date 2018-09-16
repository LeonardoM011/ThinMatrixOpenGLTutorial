package com.leo.shaders;

public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILE_PATH = "res/shaders/basic.vs.glsl";
    private static final String FRAGMENT_FILE_PATH = "res/shaders/basic.fs.glsl";

    public StaticShader() {

        super(VERTEX_FILE_PATH, FRAGMENT_FILE_PATH);

    }

    @Override
    protected void bindAttributes() {

        super.bindAttribute(0, "position");

    }
}
