package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



public class Input extends JFrame{
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    eve v = new eve();
    private int size = 0;
    private double[] x = new double[size];
    private double[][] lu = new double[size][size];
    JLabel l1;
    JTextArea t;
    JButton submit;
    JScrollPane scroll;
	public Input(int methodOption , String n) { 
		this.size = Integer.parseInt(n);
	    this.setTitle("Math Helper");
        this.setSize(800, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 10);
        p.setSize(800, 800);
        p.setBackground(Color.orange);
        p.setLayout(null);		
	  
        l1 = new JLabel("Enter the equations");
	    t = new JTextArea("");
	    submit = new JButton("Submit");
	    
	    submit.setBounds(600, 50, 150, 60);
	    submit.setBackground(Color.green);
	    submit.setFont(new Font("atilic",Font.BOLD,30));
	    
	    t.setBounds(120, 150, 600, 550);
	    t.setForeground(Color.blue);
	    t.setFont(new Font("atilic",Font.BOLD,20));
	    JScrollPane scroll = new JScrollPane (t, 
	    		   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    l1.setBounds(160, 50, 700, 60);
	    l1.setForeground(Color.red);
	    l1.setFont(new Font("atilic",Font.BOLD,40));
	    
	    this.add(p);
	    p.add(l1);
	    p.add(t);
	    p.add(submit);
	    p.add(scroll);
	    
	    submit.addActionListener(v);
  }
	 
	 private class eve implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == submit) {
					/// check here for valid input
					
					
					// perform the operation using the operation class
					
					
					Result r = new Result(x,lu); // sending the result to the result panel
					f.setVisible(false);
					f.dispose();
				}
				
				
				
			}
			
		
	    }
	 
}



