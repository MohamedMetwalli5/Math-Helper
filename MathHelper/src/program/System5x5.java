package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class System5x5 extends JFrame{
	private double[][] a = new double[5][5];
	private double[] b = new double[3];
	private double[] x = new double[3];
	private int methodOperation = 0;
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    eve v = new eve();
    JLabel l;
    JButton submit;
    
	public System5x5(int methodOperation) {
		this.methodOperation = methodOperation;
	    this.setTitle("Math Helper");
        this.setSize(800, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 10);
        p.setSize(800, 800);
        p.setBackground(Color.yellow);
        p.setLayout(null);		
        
	    l = new JLabel("Enter the coefficients");
	    submit = new JButton("Submit");
	    
	    
	    submit.setBounds(180, 610, 110, 40);
	    submit.setForeground(Color.red);
	    submit.setFont(new Font("atilic",Font.BOLD,20));
	    
	    l.setBounds(180, 100, 600, 80);
	    l.setForeground(Color.blue);
	    l.setFont(new Font("atilic",Font.BOLD,40));
	    
	    
	    this.add(p);
	    p.add(submit);
	    p.add(l);
	
	    submit.addActionListener(v);
	    
  }
	
	 private class eve implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b) {
					Operation op = new Operation();
					if(methodOperation != 4) {
						if(methodOperation == 1) {
							x = op.GaussEliminationUsingPivoting(a, b); // must take a & b from the user
						}else if(methodOperation == 2) {
							x = op.GaussElimination(a, b); // must take a & b from the user
						}else if(methodOperation == 3) {
							x = op.GaussJordan(a, b); // must take a & b from the user
						}else if(methodOperation == 5) {
							x = op.GaussSeidil(a, b); // must take a & b from the user
						}else if(methodOperation == 6) {
							x = op.JacobiIteration(a, b); // must take a & b from the user
						}
						Result r = new Result(x,null);
					}else {
						Result r = new Result(null,a);
					}

				   f.setVisible(false);
				   f.dispose();
				}
				
			}
	    
	    }
	 
	 
}
