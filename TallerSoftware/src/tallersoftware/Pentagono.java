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
public class Pentagono extends Figura {
    private int [] x = {260, 498, 407, 113, 22};
    private int [] y = {10, 183, 462, 462, 183};
            
    @Override
    protected void draw(Graphics2D g2) {
        Color old = g2.getColor();
        g2.setColor(Color.black);
        g2.drawPolygon(x,y,5);
        g2.setColor(old);
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
