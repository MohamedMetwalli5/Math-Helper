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
import javax.swing.JTextField;

public class MainMenu extends JFrame{
	private int systemOption = 0 , methodOption = 0;
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    eve v = new eve();
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JTextField t1;
    JTextField t2;
    JButton submit;
    
    JComboBox methods;
    private String[] s = {"","Gauss Elimination using pivoting","Gauss Elimination","Gauss Jordan","LU Decomposition","Gauss Seidil","Jacobi Iteration"};
	public MainMenu() {
	    this.setTitle("Math Helper");
        this.setSize(800, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 10);
        p.setSize(800, 800);
        p.setBackground(Color.yellow);
        p.setLayout(null);		
	    l1 = new JLabel("Choose the number of rows");
	    l2 = new JLabel("Choose the number of columns");
	    l3 = new JLabel("Choose the required operation");
	    submit = new JButton("Submit");
	    t1 = new JTextField("");
	    t2 = new JTextField("");
	    methods = new JComboBox();
	    
	    l1.setBounds(100, 50, 700, 60);
	    l1.setForeground(Color.red);
	    l1.setFont(new Font("atilic",Font.BOLD,40));
	    
	    t1.setBounds(170, 150, 500, 60);
	    t1.setForeground(Color.blue);
	    t1.setFont(new Font("atilic",Font.BOLD,30));
	    
	    l2.setBounds(100, 250, 700, 60);
	    l2.setForeground(Color.red);
	    l2.setFont(new Font("atilic",Font.BOLD,40));
	    
	    t2.setBounds(170, 310, 500, 60);
	    t2.setForeground(Color.blue);
	    t2.setFont(new Font("atilic",Font.BOLD,30));
	    
	    l3.setBounds(120, 420, 600, 60);
	    l3.setForeground(Color.magenta);
	    l3.setFont(new Font("atilic",Font.BOLD,40));
	   
	    
	    methods.setBounds(160, 500, 500, 40);
	    methods.setBackground(Color.cyan);
	    methods.setForeground(Color.DARK_GRAY);
	    methods.setFont(new Font("atilic",Font.BOLD,30));   
	    
	    submit.setBounds(260, 600, 250, 60);
	    submit.setBackground(Color.green);
	    submit.setForeground(Color.DARK_GRAY);
	    submit.setFont(new Font("atilic",Font.BOLD,30));
	    
	    
	    methods.addItem(s[0]);
	    methods.addItem(s[1]);
	    methods.addItem(s[2]);
	    methods.addItem(s[3]);
	    methods.addItem(s[4]);
	    methods.addItem(s[5]);
	    
	    
	    
	    this.add(p);
	    p.add(l1);
	    p.add(t1);
	    p.add(l2);
	    p.add(l3);
	    p.add(t2);
	    p.add(submit);
	    p.add(methods);
	    
	    submit.addActionListener(v);
	    methods.addActionListener(v);
	    
  }
	 private class eve implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) methods.getSelectedItem();
				if(item.equals(s[1])) { 
				   methodOption = 1;
				}else if(item.equals(s[2])) { 
					   methodOption = 2;
				}else if(item.equals(s[3])) { 
					   methodOption = 3;
				}else if(item.equals(s[4])) { 
					   methodOption = 4;
				}else if(item.equals(s[5])) { 
					   methodOption = 5;
				}else if(item.equals(s[6])) { 
					   methodOption = 6;
				}
				
				
				if(e.getSource() == submit && t1.getText().length() > 0 && t2.getText().length() > 0 && methodOption != 0) { 
					if(!t1.getText().equals(t2.getText())) {
						t1.setText("rows & columns must be equal");
						t2.setText("rows & columns must be equal");
					}else {
						int flag = 0;
						for(int i=0;i<t1.getText().length();i++) {
						  if(t1.getText().contains("-") || t1.getText().charAt(0) == '0' || !Character.isDigit(t1.getText().charAt(i)) ) {
							 t1.setText("Enter only positive numberes");
							 flag = 1;
						  }
						  if(t2.getText().contains("-") || t2.getText().charAt(0) == '0' || !Character.isDigit(t2.getText().charAt(i)) ) {
							  t2.setText("Enter only positive numberes");
							  flag = 1;
						  }
						}
						if(flag != 1) {
						  Input inp = new Input(methodOption , t1.getText());
						  //op.setVisible(true);
						  f.setVisible(false);
						  f.dispose();
						}
						
					}
				}
				
				
				
			}
			
		
	    }
	 
 
}
