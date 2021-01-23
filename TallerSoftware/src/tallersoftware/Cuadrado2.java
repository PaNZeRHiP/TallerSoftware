/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersoftware;

import java.awt.Graphics2D;

/**
 *
 * @author SrFib
 */
public class Cuadrado2 extends Figura{
    private int x;
    private int y;
    private int w;
    private int h;
    
    public Cuadrado2(int x, int y, int w, int h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
    
    @Override
    protected void draw(Graphics2D g2){
        g2.drawRect(x, y, w, h);
    }

    @Override
    protected boolean hit(int x, int y) {
        return this.x<=x && x<=this.x + this.w && this.y<=y && y<=this.y + this.h;
    }

    @Override
    public Figura[] generateHandles() {
        return new Figura[]{
            new HandleBottomRight(this), new HandleCenter(this)
        };
    }
    
    public class HandleCenter extends Handle<Cuadrado2>{
        public HandleCenter(Cuadrado2 c){
            super(c);
        }

        @Override
        protected int getCX() {
            return getParent().getX() + getParent().getW()/2;
        }

        @Override
        protected int getCY() {
            return getParent().getY() + getParent().getH();
        }

        @Override
        public boolean handleDrag(int x, int y) {
            x -= getParent().getW()/2;
            y -= getParent().getH();
            return getParent().setPosition(x, y);
        }
    }
    
    public class HandleTopLeft extends Handle<Cuadrado2>{

        public HandleTopLeft(Cuadrado2 parent) {
            super(parent);
        }

        
        @Override
        protected int getCX() {
            return getParent().getX();
        }

        @Override
        protected int getCY() {
            return getParent().getY();
        }

        @Override
        public boolean handleDrag(int x, int y) {
            int w = getParent().getW() + getParent().getX() - x;
            int h = getParent().getH() + getParent().getY() - y;
			
            return getParent().setPositionSize(x, y, w, h);
        } 
    }
    
    public class HandleBottomRight extends Handle<Cuadrado2>{

        public HandleBottomRight(Cuadrado2 parent) {
            super(parent);
        }

        
        @Override
        protected int getCX() {
            return getParent().getX() + getParent().getW();
        }

        @Override
        protected int getCY() {
            return getParent().getY() + getParent().getH();
        }

        @Override
        public boolean handleDrag(int x, int y) {
            int w2 = x - getParent().getX();
            int h2 = x - getParent().getX();
			
            return getParent().setSize(w2, h2);
        }
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean setPositionSize(int x, int y, int w, int h){
        if(this.x==x && this.y==y && this.w==w && this.h==h){
            return false;
        }
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        return true;
    }
    
    public boolean setSize(int w, int h){
        if(this.w==w && this.h==h){
            return false;
        }
        this.w=w;
        this.h=h;
        return true;
    }
    
    public boolean setPosition(int x, int y){
        if(this.x==x && this.y==y){
            return false;
        }
        this.x=x;
        this.y=y;
        return true;
    }
    
    public int getW(){
        return w;
    }
    
    public int getH(){
        return h;
    }
}
