/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersoftware;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author SrFib
 */
public class Brush {
    private Handle<Figura> draggedHandle = null;
    private List<Figura> figures = new ArrayList<Figura>();
    private List<Figura> selectedFigures = new ArrayList<Figura>();
    
    public Brush(){}
    
    public void newBox(){
        Figura f = new Cuadrado(60, 80, 60, 40);
	figures.add(f);
    }
    public void newCircle(){
        Figura f = new Circulo(50,50,30);
        figures.add(f);
    }
    public void draw(Graphics2D g2){	
        for (Figura figure : figures) {
                figure.draw(g2);
        }
    }
    public Figura getFiguraAt(int x, int y)
    {
        for (Figura figure : figures) {
            if (figure.hit(x, y)){
                return figure;
            }
        }
        return null;
    }
    public void selectFigura(Figura f)
    {
        for (Figura figure : selectedFigures) {
                figure.setSeleccionado(false);
        }
        selectedFigures.clear();

        if (f == null) {

        } else {
                selectedFigures.add(f);
                f.setSeleccionado(true);
        }
    }
    
    private void removeHandles()
    {
        Iterator<Figura> it = figures.iterator();	
        while (it.hasNext()) {
            Figura figure = it.next();
            if (figure instanceof Handle) {
                    it.remove();
            }
        }
    }
    public void handleMouseDown(int x, int y){
        Figura f = getFiguraAt(x, y);
        if (f == null) {
            removeHandles();
            selectFigura(f);			
            return;
        }

        if (f instanceof Handle) {
            draggedHandle = (Handle<Figura>) f;
            
            return;
        }


        if (f.isSelected()) {
            return;
        }

        removeHandles();
        selectFigura(f);

        Figura[] handles = f.generateHandles();
        figures.addAll(Arrays.asList(handles));
    }
    public boolean handleMouseMove(int x, int y)
	{
            if (draggedHandle == null) return false;

            draggedHandle.handleDrag(x,y);
            return true;
	}

    public void handleMouseUp(int x, int y)
    {
        draggedHandle = null;
    }
}
