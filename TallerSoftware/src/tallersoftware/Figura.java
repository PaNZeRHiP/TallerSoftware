/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersoftware;

import java.awt.Graphics2D;
 
public abstract class Figura implements Comparable<Figura> {
    private boolean seleccionado = false;
    
    protected abstract void draw(Graphics2D g2);
    
    protected abstract boolean hit(int x, int y);

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    public boolean isSelected(){
        return seleccionado;
    }
    
    public abstract Figura[] generateHandles();
    
    private int z = 0;
    
    public void setZ(int z){
        this.z=z;
    }

    @Override
    public int compareTo(Figura o) {
        return this.z-o.z;
    }
    
    @Override
    public int hashCode(){
	final int prime = 31;
	int result = 1;
	result = prime * result + z;
	return result;
    }
}
