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
    private Handler<Figura> draggedHandle = null;
    private List<Figure> figures = new ArrayList<Figure>();
    private List<Figure> selectedFigures = new ArrayList<Figure>();
    
    public Brush(){}
    
    public void newBox(){
        Figure f = new Box(60, 80, 60, 40);
	figures.add(f);
    }
    public void draw(Graphics2D g2){	
        for (Figure figure : figures) {
                figure.draw(g2);
        }
    }
    public Figure getFiguraAt(int x, int y)
    {
        for (Figure figure : figures) {
            if (figure.isbeingTouched(x, y)){
                return figure;
            }
        }
        return null;
    }
    public void selectFigura(Figure f)
    {
        for (Figure figure : selectedFigures) {
                figure.setSelected(false);
        }
        selectedFigures.clear();

        if (f == null) {

        } else {
                selectedFigures.add(f);
                f.setSelected(true);
        }
    }
    
    private void removeHandles()
    {
        Iterator<Figure> it = figures.iterator();	
        while (it.hasNext()) {
            Figure figure = it.next();
            if (figure instanceof Handler) {
                    it.remove();
            }
        }
    }
    public void handleMouseDown(int x, int y){
        Figure f = getFiguraAt(x, y);
        if (f == null) {
            removeHandles();
            selectFigura(f);			
            return;
        }

        if (f instanceof Handler) {
            draggedHandle = (Handler<Figura>) f;
            System.out.println("selected handle " + draggedHandle);
            return;
        }

        System.out.println("selected figura " + f);

        if (f.isSelected()) {
            System.out.println("already selected");
            return;
        }

        removeHandles();
        selectFigura(f);

        Figure[] handles = f.createHandlers();
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
