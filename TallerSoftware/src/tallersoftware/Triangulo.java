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
public class Triangulo extends Figura{
    //{segundo punto, primer punto, tercer punto}
    private int X[]= {100,70,130};
    //private int x[]= {100,70,130};
    private int[]Y = {50,100,100};
    //private int[]y = {50,100,100};
    private int PMx;
    private int PMy;
    
    @Override
    protected void draw(Graphics2D g2) {
        Color old = g2.getColor();
        g2.setColor(Color.black);
        g2.drawPolygon(X,Y,3);
        g2.setColor(old);
    }
    @Override
    protected boolean hit(int x, int y) {
        boolean Xs = x>=X[1] && x<=X[2];
        boolean Ys = y<=Y[2] && y>=Y[0];
        return Xs && Ys;
    }
    
    public int getPMx(){
        PMx = X[0]+(X[2]-X[0])/2;
        return PMx;
    }
    
    public int getPMy(){
        PMy = Y[0]/2;
        return PMy;
    }

    @Override
    public Figura[] generateHandles() {
        return new Figura[]{ new HandleCenter(this)};
    }
    
    public class HandleCenter extends Handle<Triangulo>{

        public HandleCenter(Triangulo parent) {
            super(parent);
        }

        @Override
        protected int getCX() {
            return getParent().getPMx();
        }

        @Override
        protected int getCY() {
            return 2*getParent().getPMy();
        }

        @Override
        public boolean handleDrag(int x, int y) {
            for (int i = 0; i < 3; i++) {
                X[i] -= x;
                Y[i] -= y;
            }
            return true;
        }
    }
}
