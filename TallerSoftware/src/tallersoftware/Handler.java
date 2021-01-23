/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersoftware;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SrFib
 */
public abstract class Handler<SomeFigure> extends Figure{
    int height;
    int width;
    SomeFigure figure;
    
    public Handler(SomeFigure f){
        figure=f;
        height=10;
        width=10;
    }
    
    /**
     * Next three methods will be implemented on the handlers by side depending of the figure
     */
    public abstract int handlerPositionX();
    public abstract int handlerPositionY();
    public abstract void handleDrag(int x, int y);
    
   
    public void drawHandler(Graphics2D g2){
        //Draw the box handler
        Color actual = g2.getColor();
        g2.setColor(new Color(21, 98, 69));//its like green
        g2.drawRect(this.handlerPositionX() - (width / 2), handlerPositionY() - (height / 2), width, height);
        g2.setColor(actual);
    }
    @Override
    public boolean isbeingTouched(int x, int y){
        //Check if "SomeFigure" is being touched
        boolean inX = (this.handlerPositionX() - (width / 2))<=x && (this.handlerPositionX() + (width / 2))>=x;
        boolean inY = (this.handlerPositionY() - (height / 2))<=x && (this.handlerPositionY() + (height / 2))>=x;
        return inX && inY;
    }
    public SomeFigure getSomeFigure(){
        return figure;
    }
}
