/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersoftware;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author SrFib
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main m = new Main();
        m.menu();
    }

    private void menu() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 650);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setLayout(new BorderLayout());
        JMenuBar menubar = new JMenuBar();
        menubar.add(new JMenu("File"));
        c.add(menubar);
        {//Panels on RootFrame
            JPanel Panel1 = new JPanel();
            Panel1.setLayout(new GridLayout(2,1));
            c.add(Panel1, BorderLayout.LINE_START);
            {//Panel1 Layout
                JPanel Panel3 = new JPanel();
                Panel3.setLayout(new BorderLayout());
                {//Panel3 Layout
                    {//Panel5
                        JPanel Panel5 = new JPanel();
                        Panel5.setLayout(new GridLayout(1,3));
                        Panel5.add(new JButton("Save"));
                        Panel5.add(new JButton("Back"));
                        Panel5.add(new JButton("Forward"));
                        Panel3.add(Panel5,BorderLayout.PAGE_START);
                    }
                    {//Panel 6
                        JPanel Panel6 = new JPanel();
                        Panel6.setLayout(new GridLayout(3,2));
                        Panel6.add(new JButton("Square"));
                        Panel6.add(new JButton("Triangle"));
                        Panel6.add(new JButton("Circle"));
                        Panel6.add(new JButton("Hexagon"));
                        Panel6.add(new JButton("Rombo"));
                        Panel6.add(new JButton("Triangle squared"));
                        Panel3.add(Panel6,BorderLayout.CENTER);
                    }
                }
                JPanel Panel4 = new JPanel();
                Panel4.setLayout(new BorderLayout());
                {//Panel4 Layout
                    {//7
                       JLabel label = new JLabel("Figure properties");
                       Panel4.add(label,BorderLayout.PAGE_START);
                    }
                    Panel4.add(new JButton("Scrollbar with Comboboxes"),BorderLayout.CENTER);
                }
                Panel1.add(Panel3);
                Panel1.add(Panel4);
            }
            JPanel Panel2 = new JPanel();
            c.add(Panel2, BorderLayout.CENTER);
            Panel2.setLayout(new BorderLayout());
            Panel2.add(new JButton("Draw site"),BorderLayout.CENTER);
            
        }
    }
    
    
}
