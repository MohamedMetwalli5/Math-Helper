package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
    private int size = 0 , counter = 1 , counterRow = 0,counterColumn = 0, flag = 0 , methodOption = 0 ,numberOfIterations = 0 ;
    private double epsilon;
    private double[][] augmented;
    private JTextField[][] numbers;
    private double[] x = new double[size];
    private double[][] lu = new double[size][size];
    JLabel l1;
    JTextField t;

    JLabel l;
    JButton submit;
    JScrollPane scroll;
	public Input(int methodOption , String n , String epsilon , String numberOfIterations) { 
		this.size = Integer.parseInt(n);
		this.methodOption = methodOption;
		if( this.methodOption==5||this.methodOption==6) {
			this.numberOfIterations = Integer.parseInt(numberOfIterations);
			this.epsilon = Double.parseDouble(epsilon);
		}
		numbers = new JTextField[size][size+1];
		augmented = new double[size][size+1];
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

	    submit = new JButton("Submit");
	    submit.setBounds(600, 50, 150, 60);
	    submit.setBackground(Color.green);
	    submit.setFont(new Font("atilic",Font.BOLD,30));


	    JScrollPane scroll = new JScrollPane (t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    l1.setBounds(160, 50, 700, 60);
	    l1.setForeground(Color.red);
	    l1.setFont(new Font("atilic",Font.BOLD,40));
	    this.add(p);
	    p.add(l1);
	    int r = 0, c = 0;
	    for(int i=130;i<(p.getHeight()-80);i+=100) {
	    	if(counterRow<size) {
	    		counterRow++;
	    		counterColumn=0;
	    		counter = 1;
	    		c = 0;
	    		for(int j=100;j<(p.getWidth()-80);j+=100){
	    			if(counterColumn<=size) {
	    				if(counter != size+1) {
	    					l = new JLabel("x" + counter);
		    				l.setBounds(j-30, i, 60, 60);
						    l.setForeground(Color.blue);
						    l.setFont(new Font("atilic",Font.BOLD,20));
						    counter++;
	    					p.add(l);
	    				}else {
	    					l = new JLabel("=");
		    				l.setBounds(j-30, i, 60, 60);
						    l.setForeground(Color.blue);
						    l.setFont(new Font("atilic",Font.BOLD,20));
						    counter++;
	    					p.add(l);
	    				}				
	    				counterColumn++;
				    	t = new JTextField("");
				    	t.setBounds(j, i, 60, 60);
					    t.setForeground(Color.black);
					    t.setFont(new Font("atilic",Font.BOLD,20));
					    numbers[r][c] = t;
					    c++;
					    p.add(t);
					    
	    			}else {
	    				break;
	    			}
	    		}
	    		r++;
    		}else{
	    		break;
	    	}
	    }
	    p.add(submit);

	    p.add(scroll);
		submit.addActionListener(v);

  }
	 
	 private class eve implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submit) {
				/// check here for valid input

				for(int i=0;i<numbers.length;i++) {
						for(int j=0;j<numbers[0].length;j++) {
							augmented[i][j] = Double.parseDouble(numbers[i][j].getText());
							System.out.print(augmented[i][j] + " ");
						}
						System.out.println();
				}
				Operation op = new Operation();
				if(methodOption == 1) {
					op.GaussEliminationUsingPivoting(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size));
				}else if(methodOption == 2) {
					op.GaussElimination(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size));
				}else if(methodOption == 3) {
					op.GaussJordan(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size));
				}else if(methodOption == 4) {
					//LU result = new LU();
				}else if(methodOption == 5) {
					op.GaussSeidalSolver(augmented, new double[]{0,0,0}, numberOfIterations, epsilon);
				}else if(methodOption == 6) {
					op.jacobi(augmented, new double[]{0,0,0}, numberOfIterations, epsilon);
				}

				op.GaussEliminationUsingPivoting(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size));

				for(int i=0;i<numbers.length;i++) {
						System.out.println(op.GaussEliminationUsingPivoting(op.getFirstNColumn(augmented, size), op.getColumn(augmented, size))[i] + " ");
				}

				Result r = new Result(x,lu); // sending the result to the result panel
				f.setVisible(false);
				f.dispose();
			}
		}
	}
	 
}



