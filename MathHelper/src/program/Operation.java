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
		return b;
		
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
	
	public static void GaussSeidalSolver(double [][] augmentedMatrix,int iterations,double epsilon){
        int matrixSize = augmentedMatrix.length;
        int currIterations = 1;
        //double epsilon = 1e-15;
        double [] xNew = new double[matrixSize];
        double [] xOld = new double[matrixSize];
        //initialize xNew Array with initial values {0,0,0,0,0}
        Arrays.fill(xNew,0);
        int counter = 0;
        while(counter < iterations){
            for (int i = 0; i<matrixSize; i++){
                double sum = augmentedMatrix[i][matrixSize];
                for (int j = 0; j<matrixSize; j++){
                    if (j != i) {
                        sum = sum - augmentedMatrix[i][j] * xNew[j];
                    }
                }
                xNew[i] = 1 / augmentedMatrix[i][i] * sum;
            }
            System.out.println(currIterations + " - Approximation" );
            for(int i = 0; i<matrixSize; i++){
                System.out.println("x" + (i+1) + " = " + xNew[i]);
            }
            System.out.println("");
            currIterations++;
            counter++;
            boolean stop = true;
            for (int i = 0; i < matrixSize && stop; i++)
                if (Math.abs(xNew[i] - xOld[i]) > epsilon)
                    stop = false;
            if (stop || iterations == 100)
                break;
            xOld = xNew.clone();
        }
    }

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static void jacobi(double[][] matrix, int numOfIterations, double epsilon) {
		int iterationsCount = 0;
		int size = matrix.length;
		double[] InitialGuess = new double[size];
		Arrays.fill(InitialGuess,0);
		double[][] results = new double[size][numOfIterations];
		while (iterationsCount < numOfIterations) {
			for (int i = 0; i < size; i++) {
				double sum = matrix[i][size];
				for (int j = 0; j < size; j++) {
					if (j != i) {
						sum -= matrix[i][j] * InitialGuess[j];
					}
				}
				sum = 1 / matrix[i][i] * sum;
				// To store results in an array.
				results[i][iterationsCount] = sum;
			}

			// To update initialGuess array with the new one.
			for (int i = 0; i < size; i++) {
				InitialGuess[i] = results[i][iterationsCount];
			}

			// just for printing each result
			 System.out.println((iterationsCount+1) + " - Approximation" );
	            for(int i = 0; i<size; i++){
	                System.out.println("x" + (i+1) + " = " + InitialGuess[i]);
	            }
	            System.out.println("");
			// end printing

			// Test stop
			if (iterationsCount > 0) {
				boolean stop = true;
				for (int i = 0; i < size && stop; i++) {
					if (Math.abs(InitialGuess[i] - results[i][iterationsCount - 1]) > epsilon) {
						stop = false;
					}
				}
				if (stop || iterationsCount + 1 == 100)
					break;
			}
			
			iterationsCount++;
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}

