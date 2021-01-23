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
public class BoxHandler{
    
    Box box;
    
    public BoxHandler(Box b){
        box=b;
    }
    
    public class TopHandler extends Handler<Box>{
        
        public TopHandler(Box b){
            super(b);
        }
        @Override
        public int handlerPositionX() {
            return this.getSomeFigure().getAxisX();
        }

        @Override
        public int handlerPositionY() {
            return this.getSomeFigure().getAxisY();
        }

        @Override
        public void handleDrag(int x, int y) {
            int wh = getSomeFigure().getHeight() + getSomeFigure().getAxisX() - x;
            int hh = getSomeFigure().getHeight() + getSomeFigure().getAxisY() - y;
            getSomeFigure().setAxisX(x);
            getSomeFigure().setAxisY(y);
            getSomeFigure().setHeight(hh);
            getSomeFigure().setWidth(wh);
        }

        @Override
        public void draw(Graphics2D g2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Figure[] createHandlers() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public class DownHandler extends Handler<Box>{
        
        public DownHandler(Box b){
            super(b);
        }
        @Override
        public int handlerPositionX() {
            return getSomeFigure().getAxisX() + getSomeFigure().getWidth();
        }

        @Override
        public int handlerPositionY() {
            return getSomeFigure().getAxisY() + getSomeFigure().getHeight();
        }

        @Override
        public void handleDrag(int x, int y) {
            int w = x - getSomeFigure().getWidth();
            int h = y - getSomeFigure().getHeight();
            getSomeFigure().setWidth(w);
            getSomeFigure().setHeight(h);
            
            
        }

        @Override
        public void draw(Graphics2D g2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Figure[] createHandlers() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}