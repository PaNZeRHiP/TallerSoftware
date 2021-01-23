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
public class Rombo extends Figura{
    private int [] x = {150, 240, 150, 65};
    private int [] y = {50, 125, 200, 125};
    @Override
    protected void draw(Graphics2D g2) {
        Color old = g2.getColor();
        g2.setColor(Color.black);
        g2.drawPolygon(x, y, 4);
    }

    @Override
    protected boolean hit(int x, int y) {
        return false;
    }

    @Override
    public Figura[] generateHandles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
