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
 * @param <T>
 */
public abstract class Handle<T> extends Figura {
    
    private static final int w = 10, h = 10;
    private T parent;
    
    protected Handle(T parent){
        this.parent=parent;
        this.setZ(Integer.MAX_VALUE);
    }
    
    protected abstract int getCX();
    protected abstract int getCY();
    
    @Override
    protected void draw(Graphics2D g2){
        Color old = g2.getColor();
        g2.setColor(Color.cyan);
        g2.drawRect(this.getCX()-(w/2), this.getCY()-(h/2), w, h);
        g2.setColor(old);
    }
    
    @Override
    protected boolean hit(int x, int y){
        return (this.getCX() - (w/2))<= x && (this.getCX()+(w/2))>=x && (this.getCY()-(h/2))<=y && (this.getCY()+(h/2))>=y;
    }
    
    @Override
    public Figura[] generateHandles(){
        return null;
    }
    
    protected T getParent(){
        return parent;
    }
    
    public abstract boolean handleDrag(int x, int y);
}
