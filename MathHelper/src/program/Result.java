package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Result extends JFrame{
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JLabel l;
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
	  
        if(lu == null) {
        	int j = 0, i=50;
        	while(j < x.length && i<p.getHeight()) {
        		l = new JLabel("X"+(j+1) +" = "+ x[j]);
        		l.setBounds(100, i, 180, 60);
        	    l.setForeground(Color.red);
        	    l.setFont(new Font("atilic",Font.BOLD,40));
        		j++;
        		i += 80;
        		p.add(l);
        	}
        }else {
        	
        }
        
	    this.add(p);


  }
	
	
	 	
}



