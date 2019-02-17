package com.dan323.geometry.objects.material;

public class Matte implements Material {

    private Color c;

    public Matte(Color c) {
        this.c = c;
    }

    public Color getColor() {
        return c;
    }

}
