package com.dan.geometry.phong.material;

public class Matte implements Material {

    private Color c;

    public Matte(Color c) {
        this.c = c;
    }

    private Color getColor(){
        return c;
    }

    @Override
    public Color getAmbientColor() {
        return getColor();
    }

    @Override
    public boolean isTransparent() {
        return false;
    }

    @Override
    public Color getSpecularColor() {
        return Color.BLACK;
    }

    @Override
    public double getEta() {
        return 0;
    }

    @Override
    public Color getDiffuseColor() {
        return getColor();
    }

    @Override
    public boolean isReflexive() {
        return false;
    }

    @Override
    public double getShininess() {
        return 0;
    }
}
