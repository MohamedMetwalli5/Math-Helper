package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MainMenu extends JFrame{
	private int systemOption = 0 , methodOption = 0;
    JFrame f = new JFrame();
    JPanel p2 = new JPanel();
    eve v = new eve();
    JLabel l1;
    JLabel l2;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JComboBox methods;
    private String[] s = {"","Gauss Elimination using pivoting","Gauss Elimination","Gauss Jordan","LU Decomposition","Gauss Seidil","Jacobi Iteration"};
	public MainMenu() {
	    this.setTitle("Math Helper");
        this.setSize(800, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 10);
        p2.setSize(800, 800);
        p2.setBackground(Color.yellow);
        p2.setLayout(null);		
	    l1 = new JLabel("Choose the size of system");
	    l2 = new JLabel("Choose the required operation");
        b1 = new JButton("3X3");
	    b2 = new JButton("4X4");
	    b3 = new JButton("5X5");
	    b4 = new JButton("6X6");
	    methods = new JComboBox();
	    
	    
	    l1.setBounds(120, 30, 600, 60);
	    l1.setForeground(Color.red);
	    l1.setFont(new Font("atilic",Font.BOLD,40));
	    
	    b1.setBounds(230, 120, 250, 60);
	    b1.setBackground(Color.green);
	    b1.setForeground(Color.DARK_GRAY);
	    b1.setFont(new Font("atilic",Font.BOLD,30));
	    
	    b2.setBounds(230, 220, 250, 60);
	    b2.setBackground(Color.green);
	    b2.setForeground(Color.DARK_GRAY);
	    b2.setFont(new Font("atilic",Font.BOLD,30));
	    
	    b3.setBounds(230, 320, 250, 60);
	    b3.setBackground(Color.green);
	    b3.setForeground(Color.DARK_GRAY);
	    b3.setFont(new Font("atilic",Font.BOLD,30));

	    b4.setBounds(230, 420, 250, 60);
	    b4.setBackground(Color.green);
	    b4.setForeground(Color.DARK_GRAY);
	    b4.setFont(new Font("atilic",Font.BOLD,30));    
	   
	    l2.setBounds(120, 500, 600, 60);
	    l2.setForeground(Color.magenta);
	    l2.setFont(new Font("atilic",Font.BOLD,40));
	    
	    methods.setBounds(160, 580, 500, 40);
	    methods.setBackground(Color.cyan);
	    methods.setForeground(Color.DARK_GRAY);
	    methods.setFont(new Font("atilic",Font.BOLD,30));   
	    
	    methods.addItem(s[0]);
	    methods.addItem(s[1]);
	    methods.addItem(s[2]);
	    methods.addItem(s[3]);
	    methods.addItem(s[4]);
	    methods.addItem(s[5]);
	    
	    this.add(p2);
	    p2.add(l1);
	    p2.add(b1);
	    p2.add(b2);
	    p2.add(b3);
	    p2.add(b4);
	    p2.add(l2);
	    p2.add(methods);
	    
	    b1.addActionListener(v);
	    b2.addActionListener(v);
	    b3.addActionListener(v);
	    b4.addActionListener(v);
	    methods.addActionListener(v);
  }
	 private class eve implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b1) { 
				  systemOption = 1;
				  //op.setVisible(true);
				  f.setVisible(false);
				  f.dispose();
				}else if(e.getSource() == b2) { 
					systemOption = 2;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}else if(e.getSource() == b3) { 
					systemOption = 3;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}else if(e.getSource() == b4) { 
					systemOption = 4;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}
				
				String item = (String) methods.getSelectedItem();
				if(item.equals(s[1])) { 
				   methodOption = 1;
				  //op.setVisible(true);
				  f.setVisible(false);
				  f.dispose();
				}else if(item.equals(s[2])) { 
					  methodOption = 2;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}else if(item.equals(s[3])) { 
					methodOption = 3;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}else if(item.equals(s[4])) { 
					methodOption = 4;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}else if(item.equals(s[5])) { 
					methodOption = 5;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}else if(item.equals(s[6])) { 
					methodOption = 6;
					  //op.setVisible(true);
					  f.setVisible(false);
					  f.dispose();
				}
				
				
				if(systemOption != 0 && methodOption != 0) {
					if(systemOption == 1) {
					   System3x3 op = new System3x3(methodOption);
					}else if(systemOption == 2) {
						   System4x4 op = new System4x4(methodOption);
					}else if(systemOption == 3) {
						   System5x5 op = new System5x5(methodOption);
					}else if(systemOption == 4) {
						   System6x6 op = new System6x6(methodOption);
					}
				}
				
			}
			
		
	    }
	 
 
}
