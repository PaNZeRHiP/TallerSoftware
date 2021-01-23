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
public abstract class Figure {
    int axisZ=0;
    boolean selected;
    boolean isTouchedByAnother;
    
    public void setAxisZ(int z){
        axisZ=z;
    }
    public int getAxisZ(){
        return axisZ;
    }
    
    public void setSelected(boolean s){
        selected=s;
    }
    
    public boolean isSelected(){
        return selected;
    }
    
    public int compareWith(Figure f){
        if (f.getAxisZ()>axisZ){
            return 1;
        }
        if (f.getAxisZ()<axisZ){
            return -1;
        }else{
            return 0;
        }
    }
    
    public abstract boolean isbeingTouched(int mouseposX,int mouseposY);//hit
    public abstract void draw(Graphics2D g2);
    public abstract Figure[] createHandlers();
}
