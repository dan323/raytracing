package com.dan.geometry.phong.material;

public class Mirror implements Material {

    private Mirror(){}

    public static final Mirror MIRROR=new Mirror();

    @Override
    public Color getAmbientColor() {
        return Color.BLACK;
    }

    @Override
    public boolean isTransparent() {
        return false;
    }

    @Override
    public Color getSpecularColor() {
        return Color.WHITE;
    }

    @Override
    public double getEta() {
        return 0;
    }

    @Override
    public Color getDiffuseColor() {
        return Color.BLACK;
    }

    @Override
    public boolean isReflexive() {
        return true;
    }

    @Override
    public double getShininess() {
        return 10;
    }
}
