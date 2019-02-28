package com.dan.geometry.phong.material;

public class Color {

    public static final Color WHITE = new Color(1, 1, 1);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color RED = new Color(1, 0, 0);
    public static final Color GREEN = new Color(0, 1, 0);
    public static final Color BLUE = new Color(0, 0, 1);
    public static final Color YELLOW = new Color(0, 1, 1);
    public static final Color ORANGE = new Color(1, 0.4, 0.4);
    private static final double DELTA = 10E-5;
    private double r;
    private double g;
    private double b;

    public Color(double i, double j, double k) {
        r = i<0?0:i;
        g = j<0?0:j;
        b = k<0?0:k;
        scaleToMax1();
    }

    public double getR() {
        return r;
    }

    public double getG() {
        return g;
    }

    public double getB() {
        return b;
    }

    public boolean equals(Object ob) {
        return (ob instanceof Color) && checkRGB(((Color) ob));
    }

    public int hashCode(){
        return toInteger();
    }

    private boolean checkRGB(Color ob) {
        return Math.abs(ob.r - r)<DELTA && Math.abs(ob.g - g)<DELTA && Math.abs(ob.b - b)<DELTA;
    }

    public int toInteger() {
        return (int) (r * 255) << 16 | (int) (g * 255) << 8 | (int) (b * 255);
    }

    public Color add(Color c) {
        return new Color(r + c.r, g + c.g, b + c.b);
    }

    public Color scale(double e) {
        return new Color(r * e, g * e, b * e);
    }

    public String toString() {
        return "[" + r + "," + g + "," + b + "]";
    }

    private void scaleToMax1() {
        double max = 1;
        if (r > max) {
            max = r;
        }
        if (g > max) {
            max = g;
        }
        if (b > max) {
            max = b;
        }
        r *= 1 / max;
        g *= 1 / max;
        b *= 1 / max;
    }

    public Color multiply(Color computeColor) {
        return new Color(r * computeColor.r, g * computeColor.g, b * computeColor.b);
    }
}
