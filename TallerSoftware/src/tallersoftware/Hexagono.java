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
public class Hexagono extends Figura{
    private int [] x = {20, 40, 48, 40, 20, 15};
    private int [] y = {50, 50, 62, 80, 80, 60};
    @Override
    protected void draw(Graphics2D g2) {
        Color old = g2.getColor();
        g2.setColor(Color.black);
        g2.drawPolygon(x, y, 6);
        g2.setColor(old);
    }

    @Override
    protected boolean hit(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Figura[] generateHandles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
