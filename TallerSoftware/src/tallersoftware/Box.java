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
public class Box extends Figure{
    
    private int AxisX,AxisY,height,width;
    
    public Box(int x,int y, int h, int w){
        AxisX=x;
        AxisY=y;
        height=h;
        width=w;
    }

    public int getAxisX() {
        return AxisX;
    }

    public void setAxisX(int AxisX) {
        this.AxisX = AxisX;
    }

    public int getAxisY() {
        return AxisY;
    }

    public void setAxisY(int AxisY) {
        this.AxisY = AxisY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    @Override
    public boolean isbeingTouched(int mouseposX, int mouseposY) {
        boolean inX = (AxisX <= mouseposX) && (AxisX+width >= mouseposX);
        boolean inY = (AxisY <= mouseposY) && (AxisY+height >= mouseposY);
        return inX && inY;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawRect(AxisX, AxisY, width, height);
    }

    @Override
    public Figure[] createHandlers() {
        BoxHandler bH = new BoxHandler(this);
        return null;
    }
    
}
