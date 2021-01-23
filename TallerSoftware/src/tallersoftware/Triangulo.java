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
    
    @Override
    protected void draw(Graphics2D g2) {
        Color old = g2.getColor();
        g2.setColor(Color.black);
        g2.drawPolygon(X,Y,3);
        g2.setColor(old);
    }
    @Override
    protected boolean hit(int x, int y) {
        boolean Xs = x>=X[0] && x<=X[2];
        boolean Ys = y>=Y[1] && y<=Y[2];
        return Xs && Ys;
    }

    @Override
    public Figura[] generateHandles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
