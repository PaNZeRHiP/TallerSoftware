/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersoftware;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author dougl
 */
public class Circulo extends Figura{
    private int radio;
    private int cx;
    private int cy;
    
    public Circulo(int cx, int cy, int radio){
        this.radio=radio;
        this.cx=cx;
        this.cy=cy;
    }

    @Override
    protected void draw(Graphics2D g2) {
        Color old = g2.getColor();
        g2.setColor(Color.black);
        g2.drawOval(cx - radio, cy - radio, radio*2, radio*2);
        g2.setColor(old);
    }

    @Override
    protected boolean hit(int x, int y) {
        double d = Math.sqrt(Math.pow(x - this.cx, 2) + Math.pow(y - this.cy, 2));
        return d<=this.radio;
    }

    @Override
    public Figura[] generateHandles() {
        return new Figura[]{
            new HandleCenter(this), new HandleRadio(this)
        };
    }
    
    public class HandleRadio extends Handle<Circulo>{

        public HandleRadio(Circulo parent) {
            super(parent);
        }

        @Override
        protected int getCX() {
            return getParent().getCX() + getParent().getRadio();
        }

        @Override
        protected int getCY() {
            return getParent().getCY();
        }

        @Override
        public boolean handleDrag(int x, int y) {
            Circulo parent = this.getParent();
            double r = Math.sqrt(Math.pow(parent.cx - x, 2) + Math.pow(parent.cy - y, 2));
            
            return parent.setRadio(r);
        }
    }
    
    public class HandleCenter extends Handle<Circulo>{

        public HandleCenter(Circulo parent) {
            super(parent);
        }

        @Override
        protected int getCX() {
            return getParent().getCX();
        }

        @Override
        protected int getCY() {
            return getParent().getCY()+getParent().getRadio();
        }

        @Override
        public boolean handleDrag(int x, int y) {
            return this.getParent().setPosition(x, y-getParent().getRadio());
        }
    }
    
    public boolean setPosition(int x, int y){
        if(this.cx==x && this.cy==y){
            return false;
        }
        this.cx=x;
        this.cy=y;
        return true;
    }
    
    public int getRadio(){
        return this.radio;
    }
    
    public int getCX(){
        return this.cx;
    }
    
    public int getCY(){
        return this.cy;
    }
    
    public boolean setRadio(double r){
        if(this.radio==(int)r){
            return false;
        }
        this.radio=(int)r;
        return true;
    }
}
