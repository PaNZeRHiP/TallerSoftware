/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersoftware;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class Canvas extends JPanel
{
	private Brush diagrama;

	public Canvas(Brush diagrama)
	{
		this.diagrama = diagrama;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				diagrama.handleMouseDown(e.getX(), e.getY());				
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				diagrama.handleMouseUp(e.getX(), e.getY());				
				repaint();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e)
			{
				if (diagrama.handleMouseMove(e.getX(), e.getY())) 
					repaint();
				
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		diagrama.draw(g2);
	}

	
}
