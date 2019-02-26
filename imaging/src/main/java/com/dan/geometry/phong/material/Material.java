package com.dan.geometry.phong.material;

public interface Material {

    Color getAmbientColor();

    boolean isTransparent();

    Color getSpecularColor();

    double getEta();

    Color getDiffuseColor();

    boolean isReflexive();

    double getShininess();

}
