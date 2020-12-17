package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MainMenu extends JFrame{
	private int  methodOption = 0 , LUOption = 0;
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    eve v = new eve();
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JTextField t1;
    JTextField t2;
    JLabel l4;
    JLabel l5;
    JTextField epsilon;
    JTextField numberOfIterations;
	JButton readFromFile;
	JTextField url;
    JButton submit;
    JComboBox methods;
	JComboBox LUmethods;
    private String[] s = {"","Gauss Elimination using pivoting","Gauss Elimination","Gauss Jordan","LU Decomposition","Gauss Seidil","Jacobi Iterative"};
	private String[] LUs = {"","Downlittle","Crout","Cholesky"};
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
	    l4 = new JLabel("Epsilon");
	    l5 = new JLabel("Number of iterations");
	    submit = new JButton("Submit");
		readFromFile = new JButton("Read Of File");

	    t1 = new JTextField("");
	    t2 = new JTextField("");
	    epsilon = new JTextField();
	    numberOfIterations = new JTextField();
	    methods = new JComboBox();
		LUmethods = new JComboBox();
	    l1.setBounds(100, 50, 700, 60);
	    l1.setForeground(Color.red);
	    l1.setFont(new Font("atilic",Font.BOLD,40));
	    t1.setBounds(170, 120, 400, 50);
	    t1.setForeground(Color.blue);
	    t1.setFont(new Font("atilic",Font.BOLD,20));
	    l2.setBounds(100, 180, 700, 60);
	    l2.setForeground(Color.red);
	    l2.setFont(new Font("atilic",Font.BOLD,40));
	    t2.setBounds(170, 250, 400, 50);
	    t2.setForeground(Color.blue);
	    t2.setFont(new Font("atilic",Font.BOLD,20));
	    l3.setBounds(120, 450, 600, 60);
	    l3.setForeground(Color.magenta);
	    l3.setFont(new Font("atilic",Font.BOLD,40));
	    methods.setBounds(160, 520, 520, 40);
	    methods.setBackground(Color.cyan);
	    methods.setForeground(Color.DARK_GRAY);
	    methods.setFont(new Font("atilic",Font.BOLD,30));
	    l4.setBounds(120, 550, 110, 60);
	    l4.setForeground(Color.black);
	    l4.setFont(new Font("atilic",Font.BOLD,20));
	    epsilon.setBounds(210, 560, 400, 40);
	    epsilon.setForeground(Color.blue);
	    epsilon.setFont(new Font("atilic",Font.BOLD,20));
	    l5.setBounds(120, 600, 200, 60);
	    l5.setForeground(Color.black);
	    l5.setFont(new Font("atilic",Font.BOLD,20));
		numberOfIterations.setBounds(330, 610, 350, 40);
	    numberOfIterations.setForeground(Color.blue);
	    numberOfIterations.setFont(new Font("atilic",Font.BOLD,20));
		LUmethods.setBounds(210, 560, 400, 40);
		LUmethods.setBackground(Color.pink);
		LUmethods.setForeground(Color.blue);
		LUmethods.setFont(new Font("atilic",Font.BOLD,20));
	    submit.setBounds(260, 660, 250, 60);
	    submit.setBackground(Color.green);
	    submit.setForeground(Color.DARK_GRAY);
	    submit.setFont(new Font("atilic",Font.BOLD,30));
		url = new JTextField("OR put valid url of file");
		url.setBounds(250, 310, 230, 60);
		url.setForeground(Color.black);
		url.setFont(new Font("atilic",Font.BOLD,20));
		p.add(url);
		readFromFile.setBounds(250, 380, 230, 60);
		readFromFile.setBackground(Color.green);
		readFromFile.setForeground(Color.DARK_GRAY);
		readFromFile.setFont(new Font("atilic",Font.BOLD,30));
	    methods.addItem(s[0]);
	    methods.addItem(s[1]);
	    methods.addItem(s[2]);
	    methods.addItem(s[3]);
	    methods.addItem(s[4]);
	    methods.addItem(s[5]);
	    methods.addItem(s[6]);
		LUmethods.addItem(LUs[0]);
		LUmethods.addItem(LUs[1]);
		LUmethods.addItem(LUs[2]);
		LUmethods.addItem(LUs[3]);
	    l4.setVisible(false);
	    epsilon.setVisible(false);
	    l5.setVisible(false);
	    numberOfIterations.setVisible(false);
	    this.add(p);
	    p.add(l1);
	    p.add(t1);
	    p.add(l2);
	    p.add(l3);
	    p.add(t2);
	    p.add(l4);
	    p.add(epsilon);
	    p.add(l5);
	    p.add(numberOfIterations);
	    p.add(submit);
		p.add(readFromFile);
	    p.add(methods);
		p.add(LUmethods);
	    submit.addActionListener(v);
	    methods.addActionListener(v);
		readFromFile.addActionListener(v);
		LUmethods.addActionListener(v);
  }
	 private class eve implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String item = (String) methods.getSelectedItem();
			String LUitem = (String) LUmethods.getSelectedItem();
			if(item.equals(s[0])) {
			   methodOption = 0;
			   l4.setVisible(false);
			   epsilon.setVisible(false);
			   l5.setVisible(false);
			   numberOfIterations.setVisible(false);
			   LUmethods.setVisible(false);
			   return;
			}else if(item.equals(s[1])) {
			   methodOption = 1;
			   l4.setVisible(false);
			   epsilon.setVisible(false);
			   l5.setVisible(false);
			   numberOfIterations.setVisible(false);
			   LUmethods.setVisible(false);
			}else if(item.equals(s[2])) {
			   methodOption = 2;
			   l4.setVisible(false);
			   epsilon.setVisible(false);
			   l5.setVisible(false);
			   numberOfIterations.setVisible(false);
			   LUmethods.setVisible(false);
			}else if(item.equals(s[3])) {
			   methodOption = 3;
			   l4.setVisible(false);
			   epsilon.setVisible(false);
			   l5.setVisible(false);
			   numberOfIterations.setVisible(false);
			   LUmethods.setVisible(false);
			}else if(item.equals(s[4])) {
			   methodOption = 4;
			   l4.setVisible(false);
			   epsilon.setVisible(false);
			   l5.setVisible(false);
			   numberOfIterations.setVisible(false);
				LUmethods.setVisible(false);
			}else if(item.equals(s[5])) {
			   methodOption = 5;
			   l4.setVisible(true);
			   epsilon.setVisible(true);
			   l5.setVisible(true);
			   numberOfIterations.setVisible(true);
				LUmethods.setVisible(false);
			}else if(item.equals(s[6])) {
			   methodOption = 6;
			   l4.setVisible(true);
			   epsilon.setVisible(true);
			   l5.setVisible(true);
			   numberOfIterations.setVisible(true);
				LUmethods.setVisible(false);
			}
			if(LUitem.equals(LUs[0])) {
				LUOption = 0;
			}else if(LUitem.equals(LUs[1])) {
				LUOption = 1;
			}else if(LUitem.equals(LUs[2])) {
				LUOption = 2;
			}else if(LUitem.equals(LUs[3])) {
				LUOption = 3;
			}
			if(e.getSource() == submit) {
				JTextField[] array = {t1,t2,epsilon,numberOfIterations};
				if(!t1.getText().equals(t2.getText())) {
					t1.setText("rows & columns must be equal");
					t2.setText("rows & columns must be equal");
				}else {
					int flag = 0;
					for(int i=0;i<array.length;i++) {
						if(array[i].getText().contains("-")) {
							array[i].setText("Enter only positive numberes");
							flag = 1;
						}
						for(int j=0;j<array[i].getText().length();j++) {
							if(i != 2 && i != 3 && !Character.isDigit(array[i].getText().charAt(j))) {
								array[i].setText("Enter only positive integer numberes");
								flag = 1;
							}
							if(i == 2 || i == 3) {
								if(!Character.isDigit(array[i].getText().charAt(j)) && array[i].getText().charAt(j) != '.') {
									array[i].setText("Enter only positive numberes");
									flag = 1;
								}
							}
						}
					}
					if(methodOption == 4 && LUOption != 0) {
						if (flag != 1 && methodOption != 0 && t1.getText().length() > 0 && t2.getText().length() > 0) {
							if (methodOption == 5 || methodOption == 6) {
								if (epsilon.getText().length() > 0 && numberOfIterations.getText().length() > 0) {
									Input inp = new Input(methodOption, t1.getText(), epsilon.getText(), numberOfIterations.getText(), LUOption);
									//op.setVisible(true);
									f.setVisible(false);
									f.dispose();
								}
							} else {
								Input inp = new Input(methodOption, t1.getText(), epsilon.getText(), numberOfIterations.getText(), LUOption);
								//op.setVisible(true);
								f.setVisible(false);
								f.dispose();
							}
						}
					}
					else if(methodOption != 4) {
						if(flag != 1 && methodOption != 0 && t1.getText().length() > 0 && t2.getText().length() > 0) {
							if(methodOption == 5 || methodOption == 6) {
								if(epsilon.getText().length() > 0 && numberOfIterations.getText().length() > 0){
									Input inp = new Input(methodOption , t1.getText() , epsilon.getText() , numberOfIterations.getText() , 0);
									//op.setVisible(true);
									f.setVisible(false);
									f.dispose();
								}
							}else {
								Input inp = new Input(methodOption , t1.getText() , epsilon.getText() , numberOfIterations.getText() , 0);
								//op.setVisible(true);
								f.setVisible(false);
								f.dispose();
								dispose();
							}
						}
					}
				}
			}
			if(e.getSource() == readFromFile) {
				double[][] augmented;
				///////////////////////////////
				JTextField[] array = {epsilon,numberOfIterations};
				int flag = 0;
				for(int i=0;i<array.length;i++) {
					if(array[i].getText().contains("-")) {
						array[i].setText("Enter only positive numberes");
						flag = 1;
					}
					for(int j=0;j<array[i].getText().length();j++) {
						if(i != 2 && i != 3 && !Character.isDigit(array[i].getText().charAt(j))) {
							array[i].setText("Enter only positive integer numberes");
							flag = 1;
						}
						if(i == 2 || i == 3) {
							if(!Character.isDigit(array[i].getText().charAt(j)) && array[i].getText().charAt(j) != '.') {
								array[i].setText("Enter only positive numberes");
								flag = 1;
							}
						}
					}
				}
				if(methodOption == 4 && LUOption != 0) {
					if (flag != 1 && methodOption != 0 && t1.getText().length() > 0 && t2.getText().length() > 0) {
						if (methodOption == 5 || methodOption == 6) {
							if (epsilon.getText().length() > 0 && numberOfIterations.getText().length() > 0) {
								Input inp = new Input(methodOption, t1.getText(), epsilon.getText(), numberOfIterations.getText(), LUOption);
								//op.setVisible(true);
								f.setVisible(false);
								f.dispose();
							}
						} else {
							Input inp = new Input(methodOption, t1.getText(), epsilon.getText(), numberOfIterations.getText(), LUOption);
							//op.setVisible(true);
							f.setVisible(false);
							f.dispose();
						}
					}
				}
				else if(methodOption != 4) {
					if(flag != 1 && methodOption != 0 && t1.getText().length() > 0 && t2.getText().length() > 0) {
						if(methodOption == 5 || methodOption == 6) {
							if(epsilon.getText().length() > 0 && numberOfIterations.getText().length() > 0){
								Input inp = new Input(methodOption , t1.getText() , epsilon.getText() , numberOfIterations.getText() , 0);
								//op.setVisible(true);
								f.setVisible(false);
								f.dispose();
							}
						}else {
							Input inp = new Input(methodOption , t1.getText() , epsilon.getText() , numberOfIterations.getText() , 0);
							//op.setVisible(true);
							f.setVisible(false);
							f.dispose();
						}
					}
				}
				///////////////////////////
				/// check here for valid input
				//reading from the file
				File file = new File(url.getText());
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException fileNotFoundException) {
					url.setText("put valid url of file");
					fileNotFoundException.printStackTrace();
					return;
				}
				String st="";
				int n=0;
				int size=0;
				while (true) {
					try {
						if (!((st = br.readLine()) != null)) break;
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
					size++;
					//System.out.println(st);
				}
				augmented=new double[size][size+1];
				try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException fileNotFoundException) {
					url.setText("put valid url of file");
					fileNotFoundException.printStackTrace();
					return;
				}
				while (true) {
					try {
						if (!((st = br.readLine()) != null)) break;
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
					String[] splited = st.split("\\s+");
					for (int i=0;i<splited.length;i++){
						augmented[n][i]=Double.parseDouble(splited[i]);
					}
					n++;
					//System.out.println(st);
				}
				//////////////////////////////////////
				Operation op = new Operation();
				if(methodOption == 1) {
					Result r = new Result(op.GaussEliminationUsingPivoting(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size)) , null);
					op.GaussEliminationUsingPivoting(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size));
				}else if(methodOption == 2) {
					Result r = new Result(op.GaussElimination(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size)), null);
					op.GaussElimination(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size));
				}else if(methodOption == 3) {
					Result r = new Result(op.GaussJordan(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size)),null);
					op.GaussJordan(op.getFirstNColumn(augmented, size+1), op.getColumn(augmented, size));
				}else if(methodOption == 4) {
					LU result = new LU();
				}else if(methodOption == 5) {
					//Result r = new Result(op.GaussSeidalSolver(augmented, numberOfIterations, epsilon) , null);
					op.GaussSeidalSolver(augmented, new double[]{0,0,0}, Integer.parseInt(numberOfIterations.getText()), Integer.parseInt(epsilon.getText()));
				}else if(methodOption == 6) {
					//Result r = new Result(op.jacobi(augmented, numberOfIterations, epsilon) , null);
					op.jacobi(augmented, new double[]{0,0,0}, Integer.parseInt(numberOfIterations.getText()), Integer.parseInt(epsilon.getText()));
				}
				//Result r = new Result(x,lu); // sending the result to the result panel
				f.setVisible(false);
				f.dispose();
				dispose();
			}
		}
	}
}
