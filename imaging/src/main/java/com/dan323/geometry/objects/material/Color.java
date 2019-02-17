package com.dan323.geometry.objects.material;

public class Color {
	
	private double r,g,b;

	public Color(double i, double j, double k) {
		r=i;
		g=j;
		b=k;
		scaleToMax1();
	}

	public static Color WHITE=new Color(1,1,1);
	public static Color BLACK=new Color(0,0,0);
	public static Color RED=new Color(1,0,0);
	public static Color GREEN=new Color(0,1,0);
	public static Color BLUE=new Color(0,0,1);
	public static Color YELLOW=new Color(0,1,1);
	public static Color ORANGE=new Color(1,0.4,0.4);

	public double getR() {
		return r;
	}

	public double getG() {
		return g;
	}

	public double getB() {
		return b;
	}
	
	public int toInteger() {
		return (int)(r*255)<<16|(int)(g*255)<<8|(int)(b*255);
	}
	
	public void add(Color c) {
		r+=c.r;
		g+=c.g;
		b+=c.b;
		scaleToMax1();
	}
	
	public void scale(double e) {
		r*=e;
		g*=e;
		b*=e;
		scaleToMax1();
	}

	public String toString(){
		return "["+r+","+g+","+b+"]";
	}

	private void scaleToMax1(){
		double max=1;
		if (r>max){
			max=r;
		}
		if (g>max){
			max=g;
		}
		if (b>max){
			max=b;
		}
		r*=1/max;
		g*=1/max;
		b*=1/max;
	}
}
