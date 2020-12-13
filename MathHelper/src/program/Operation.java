package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Operation{
	
	public static double[] GaussElimination(double[][] a, double[]b) {
		double[] x = new double[b.length];
		double factor = 1;
		
		///the forward elimination
		for(int k=0;k<b.length-1;k++) {
			for(int i=k+1;i<b.length;i++) {
				factor = a[i][k] / a[k][k];
				for(int j=k+1;j<b.length;j++) {
					a[i][j] = a[i][j] - factor * a[k][j];
				}
				b[i] = b[i] - (factor * b[k]);
			}		
		}
		
		///the backward substitution
		x[b.length-1] = b[b.length-1] / a[b.length-1][b.length-1]; 
		for(int i=b.length-2;i>=0;i--) {
			double sum = 0;
			for(int j=i+1;j<b.length;j++){
			  sum += a[i][j] * x[j];
			}
			x[i] = (b[i] - sum) / a[i][i];
		}
				
		return x;
	}
		
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
		
	public double[] GaussEliminationUsingPivoting(double[][] a, double[]b) {
		double[] x = new double[b.length];
		double tol = .00001;
		double er = 0; 
		double s[] = new double[b.length]; // as an n-element array for storing scaling factors
		// si = the largest coef. of row i
		for (int i=0;i<b.length;i++){
			s[i] = Math.abs(a[i][1]);
			for(int j=1;j<b.length;j++){
				if (Math.abs(a[i][j]) > s[i]) {
					s[i] = Math.abs(a[i][j]);
				}
			}
		}
		Eliminate(a, s, b.length-1, b, tol, er); // Forward Elimination
		if (er != -1) { // If not singular
			Substitute(a, b.length-1, b, x); // Back Substitution
		}
		
		return x;
		
	}
	
	
	
	private static void Substitute(double[][] a, int n, double[] b, double[] x) {

		x[n] = b[n] / a[n][n];
		for(int i=n-1;i >= 0;i--) {
			double sum = 0;
			for (int j=i+1;j <= n;j++) {
				sum += a[i][j] * x[j];
			}
			x[i] = (b[i] - sum) / a[i][i];
		}	
	}



	private static void Eliminate(double[][] a, double[] s, int n, double[] b, double tol, double er) {
		
		for(int k=0;k <= n-1;k++) {
				Pivot(a, b, s, n, k); // Partial Pivoting
				if (Math.abs(a[k][k]/s[k]) < tol) { // Check for singularity
					er = -1;
					return;
				}
				for (int i=k+1;i<=n;i++) {
					double factor = a[i][k] / a[k][k];
					for (int j=k+1;j<=n;j++)
					a[i][j] = a[i][j] - factor * a[k][j];
					b[i] = b[i] - factor * b[k];
				}
		}
		if (Math.abs(a[n][n] / s[n]) < tol) { // Check for singularity
			er = -1;
		}
		
	}

	private static void Pivot(double[][] a, double[] b, double[] s, int n, int k) {
		
		double dummy = 1;
		int p = k;      // Assume row k is the pivot row
		// Find the largest scaled coefficient in column k
		double big = Math.abs(a[k][k] / s[k]);
		for(int i=k+1;i <= n;i++){
	        dummy = Math.abs(a[i][k] / s[i]);
			if (dummy > big) {
				big = dummy;
				p = i;      // Record new pivoting row
			}
		}
		if (p != k) {
			// Swap row p and row [k]
			for(int j=k;j <= n;j++) {
				dummy = a[p][j];
				a[p][j] = a[k][j];
				a[k][j] = dummy;
			}
			// swap b[p] and b[k]
			dummy = b[p];
			b[p] = b[k];
			b[k] = dummy;
			// swap s[p] and s[k]
			dummy = s[p];
			s[p] = b[k];
			s[k] = dummy;
		}
	}

	
	

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static double[] GaussJordan(double[][] a, double[]b) {
		double[] x = new double[b.length];
		double factor = 1;
		///the forward elimination
		for(int k=0;k<b.length-1;k++) {
			for(int i=k+1;i<b.length;i++) {
				factor = a[i][k] / a[k][k];
				a[i][k]=0;
				for(int j=k+1;j<b.length;j++) {
					a[i][j] = a[i][j] - factor * a[k][j];
				}
				b[i] = b[i] - (factor * b[k]);
			}
		}
		///the backward elimination
		for(int k=b.length-1;k>0;k--) {
			for(int i=k-1;i>=0;i--) {
				factor = a[i][k] / a[k][k];
				a[i][k]=0;
				for(int j=k+1;j<b.length;j++) {
					a[i][j] = a[i][j] - factor * a[k][j];
				}
				b[i] = b[i] - (factor * b[k]);
			}
		}
		///the forward substitution
		for(int i=0;i<b.length;i++) {
			x[i]=b[i]/a[i][i];
		}
		return x;
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static double[][] LUDecomposition(double[][] a, int option) {
		if(option == 1) {
			
		}else if(option == 2) {
			
		}else {
			
		}
		return a;
		
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static double[] GaussSeidil(double[][] a, double[]b) {
		double[] x = new double[b.length];
		return b;
		
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static double[] JacobiIteration(double[][] a, double[]b) {
		double[] x = new double[b.length];
		return b;
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}

