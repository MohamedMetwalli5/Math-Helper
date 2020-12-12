package program;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Result extends JFrame{
    JFrame f = new JFrame();
    JPanel p = new JPanel();

	public Result(double[] x, double[][] lu) { 
	    this.setTitle("Math Helper");
        this.setSize(800, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 10);
        p.setSize(800, 800);
        p.setBackground(Color.orange);
        p.setLayout(null);		
	  
	    
	    this.add(p);


  }
	 	
}



