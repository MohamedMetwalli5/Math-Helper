
public class LU {
	
	static int[] o;
	static Object[] orderedToBePrintedArrays;

	 public static double[] lu(double[] A, int option){

	        switch (option){
	            case 1:
	                break;
	            case 2:
	                break;
	            case 3:
	                break;
	        }
	        return null;
	    }
	 
	 	// LU with pivoting 
	 	public static Object[] myLuDoolitte(double[][] A, double[] B, int n,double tol) {
	 		double[] s = new double[n];
	 		o = new int[n];
	 		double[] x = new double[n];
	 		
	 		int er = 0;
	 		er = myDecompose(A, o, s, tol, n, er);
	 		
	 		//return A;
	 		return convertToLUDoolitte(A, n);
	 		/*if (er != -1)
	 			return mySubstitute(A, o, n, B, x);
	 		else 
	 			return null;*/ 		
	 	}
	 
	 
	 	
	 	public static Object[] convertToLUDoolitte(double[][] A, int n) {
	 		double[][] upper = new double[n][n];
	 		double[][] lower = new double[n][n];
	 		Object[] arr = new Object[2];
	 		
	 		for (int i = 0; i < n; i++)
	 			for (int j = 0; j <= i; j++) {
	 				if (i == j)
	 					lower[i][j] = 1;
	 				else 
	 					lower[i][j] = A[o[i]][j];
	 			}
	 		
	 		for (int i = 0; i < n; i++)
	 			for (int j = i; j < n; j++) {
	 				upper[i][j] = A[o[i]][j];
	 			}

	 		arr[0] = lower;
	 		arr[1] = upper;
	 		return arr;
	 		

	 		
	 	}
	
	 	
	 	 
	    public static double[] mySubstitute(double A[][], int[] o, int n, double[] B, double[] x) {
	    	//forward sub
	    	double[] y = new double[n];
	    	y[o[0]] = B[o[0]];
	    	
	    	for (int i = 1; i < n; i++) {
	    		double sum = B[o[i]];
	    		
	    		for (int j = 0; j < i; j++)
	    			sum = sum - A[o[i]][j] * y[o[j]];
	    		
	    		y[o[i]] = sum;
	    	}
	    	
	    	
	    	//backward sub
	    	// n - 1 in x bec the arrangement of variables hasn't changed (columns hasn't changed)
	    	// while y [o[n - 1]] as the arrangement of equations  had changed 
	    	x[n - 1] = y[o[n - 1]] / A[o[n - 1]][n - 1];
	    	
	    	for (int i = n - 2; i >= 0; i--) {
	    		double sum = 0;
	    		
	    		for (int j = i + 1; j < n; j++)
	    			sum = sum + A[o[i]][j] * x[j];
	    		
	    		x[i] = (y[o[i]] - sum) / A[o[i]][i];	    		
	    	}
	    	
	    	
	    	return x;	    	
	    }
	    
	
	    public static int myDecompose(double[][] A,  int[] o, double[] s, double tol,int n, int er) {
	    	//makes o, s ready
	    	for (int i = 0; i < n; i++) {
	    		o[i] = i;
	    		s[i] = Math.abs(A[i][0]);
	    		
	    		for (int j = 1; j < n; j++)
	    			if (Math.abs(A[i][j]) > s[i])
	    				s[i] = Math.abs(A[i][j]);	
	    	}
	    	
	    	
	    	for (int i = 0; i < n - 1; i++) {
	    		//main diagonal loop
	    		myPivot(A, s, o, n, i);
	    		
	    		if (Math.abs(A[o[i]][i] / s[o[i]]) < tol) {
	    			er = -1;
	    			return -1;
	    		}
	    		
	    		for (int j = i + 1; j < n; j++) {
	    			//column loop
	    			double factor = A[o[j]][i] / A[o[i]][i];
	    			A[o[j]][i] = factor;
	    			
	    			//adjust the other numbers of the row
	    			for (int k = i + 1; k < n; k++) 
	    				A[o[j]][k] = A[o[j]][k] - (A[o[i]][k] * factor);	
	    		}	
	    	}
	    	
	    	if (Math.abs(A[o[n - 1]][n - 1] / s[o[n - 1]]) < tol) {
    			er = -1;
    			return -1;
    		}
	    	return 0;   	
	    }
	    
	  
	    public static void myPivot(double[][] A, double[] s, int[] o, int n, int i) {
	    	int p = i;
	    	double big = Math.abs(A[o[i]][i] / s[o[i]]);
	    	double dummy = 0;
	    	
	    	//determine largest pivot in the column 
	    	for (int k = i + 1; k < n; k++) {
	    		dummy = Math.abs(A[o[k]][i] / s[o[k]]);
	    		
	    		if (dummy > big) {
	    			big = dummy;
	    			p = k;
	    		}
	    	}
	    	
	    	//switch the indices 
	    	int tempIndex = o[p];
	    	o[p] = o[i];
	    	o[i] = tempIndex;	
	    }
	    


	    // LU crout
	    public static void myLUCrout() {
	    	//decompose LU in A
	    	//croutDecompose();
	    	
	    	//gives answer in x
	    	//substitute();
	
	    }
	   
	    public static Object[] myCroutDecompose(double[][] A, int n) {
	    	
	    	double[][] l = new double[n][n];
	    	double[][] u = new double[n][n];
	    	
	    	//first column will not be modified
	    	for (int i = 0; i < n; i++)
	    		l[i][0] = A[i][0];
	    	
	    	
	    	for (int i = 1; i < n; i++)
	    		u[0][i] = A[0][i] / l[0][0];
	    	
	    	
	    	for (int i = 0; i < n; i++)
	    		u[i][i] = 1;
	    	
	    	
	    	for (int j = 1; j < n - 1; j++) {
	    		
	    		//updates L value
	    		for (int i = j; i < n; i++) {
	    			double sum = 0;
	    			
	    			for (int k = 0; k <= j - 1; k++)
	    				sum = sum + l[i][k] * u[k][j];
	    			
	    			l[i][j] = A[i][j] - sum;			
	    		}
	    		
	    		
	    		//updates U value
	    		for (int k = j + 1; k < n; k++) {
	    			double sum = 0;
	    			
	    			for (int i = 0; i <= j - 1; i++)
	    				sum = sum + l[j][i] * u [i][k];
	    			
	    			u[j][k] = (1 / l[j][j]) * (A[j][k] - sum);	
	    		}
	    		
	    	}
	    	 
	    	//last pivot
	    	double sum = 0;
	    	
	    	for (int k = 0; k <= n - 1; k++)
	    		sum = sum + l[n - 1][k] * u[k][n - 1];
	    	
	    	l[n - 1][n - 1] = A[n - 1][n - 1] - sum;
	    	
	    	Object[] lu = new Object[2];
	    	
	    	lu[0] = l;
	    	lu[1] = u;
	    	
	    	return lu;	    
	    }
	    
	    public static double[] myCroutSubstitute(double l[][], double u[][], int n, double[] B) {
	    	 double[] x = new double[n];
	    	//forward sub
	    	double[] y = new double[n];
	    	y[0] = B[0] / l[0][0];
	    	
	    	for (int i = 1; i < n; i++) {
	    		double sum = 0;
	    		
	    		for (int j = 0; j < i; j++)
	    			sum = sum + l[i][j] * y[j];
	    		
	    		y[i] = (B[i] - sum) / l[i][i];
	    	}
	    	
	    	
	    	//backward sub
	    	// n - 1 in x bec the arrangement of variables hasn't changed (columns hasn't changed)
	    	// while y [o[n - 1]] as the arrangement of equations  had changed 
	    	
	    	x[n - 1] = y[n - 1];
	    	
	    	for (int i = n - 2; i >= 0; i--) {
	    		double sum = 0;
	    		
	    		for (int j = i + 1; j < n; j++)
	    			sum = sum + u[i][j] * x[j];
	    		
	    		x[i] = (y[i] - sum);	    		
	    	}
	    	
	    	
	    	return x;	    	
	    }
	    
	    
	    
	    //LU Cholesky diagonal
	    public static void myLUCholesky() {
	    	
	    }
	    
	    // returns LDU
	    public static Object[] myCholeskyDecompose(double[][] A, int n) {

	    	Object[] LU = myCroutDecompose(A, n);
	    	double[][] lDash = (double[][]) LU[0];
	    	double[][] u = (double[][]) LU[1];
	    	double[][] d = new double[n][n];
	    	double[][] l = new double[n][n];

	    	for (int i = 0; i < n; i++)
	    		d[i][i] = lDash[i][i];
	    	// d is ready
	    	
	    	for (int i = 0; i < n; i++)
	    		l[i][i] = 1;
	    	
	    	for (int j = 0; j < n - 1; j++) {
	    		for (int i = j + 1; i < n; i++)
	    			l[i][j] = lDash[i][j] / d[j][j]; 			
	    	}
	    	
	    	
	    	
	    	Object[] LDU = new Object[3];
	    	
	    	LDU[0] = l;
	    	LDU[1] = d;
	    	LDU[2] = u;

	    	return LDU;  	
	    }
	    
	    public static double[] myCholeskySubstitute(double l[][], double d[][], double u[][], int n, double[] B) {
	    	//forward 
	    	//forward sub
	    	double[] z = new double[n];
	    	z[0] = B[0];
	    	
	    	for (int i = 1; i < n; i++) {
	    		double sum = B[i];
	    		
	    		for (int j = 0; j < i; j++)
	    			sum = sum - l[i][j] * z[j];
	    		
	    		z[i] = sum;
	    	}
	    	
	    	
	    	//diagonal
	    	double[] y = new double[n];
	    	
	    	for (int i = 0; i < n; i++) {
	    		y[i] = z[i] / d[i][i];
	    	}
    	
	    	//backward
	    	
	    	double[] x = new double[n];
	    	x[n - 1] = y[n - 1];
	    	
	    	for (int i = n - 2; i >= 0; i--) {
	    		double sum = 0;
	    		
	    		for (int j = i + 1; j < n; j++)
	    			sum = sum + u[i][j] * x[j];
	    		
	    		x[i] = (y[i] - sum);	    		
	    	}
	    	
	    	
	    	return x;
	    	
	    	
	    
	    }
	    
	    

	    
	    public static boolean isSymmetric(double[][] mat, int n) {
	    	for (int i = 0; i < n; i++)
	    		for (int j = 0; j < n; j++)
	    			if (mat[i][j] != mat[j][i])
	    				return false;
	    	
	    	return true;
	    }
	    	    
	    public static double[] luCholesky(double[][] mat, int n){
	    	if (!isSymmetric(mat, n))
	    		return null;
			return null;
	    	
	    	//logic
	    	
	    	
	    	
	    	
	    	
	    }

	    
	    public static double[][] transposeSquare(double[][] mat, int n){
	    	double[][] ans = new double[n][n];
	    	
	    	for (int i = 0; i < mat.length; i++)
	    		for (int j = 0; j < mat[0].length; j++)
	    			ans[j][i] = mat[i][j];
	    	
	    	return ans;
	    }
	    
	   

	    
	    public static Object[] myLuSymCholesky(double[][] A, int n){
	    
	    	double[][] l = new double[n][n];
	    	
	    	l[0][0] = Math.sqrt(A[0][0]);
	    	
	    	
	    	for (int i = 1 ; i < n; i++)
	    		l[i][0] = A[i][0] / l[0][0];
	    	
	    	
	    	for (int k = 1; k < n; k++) {

	    		// non main diagonal
	    		for (int i = 1; i < k; i++) {
	    			double sum0 = 0;
	    			
	    			for (int j = 0; j < i; j++)
	    				sum0 += l[i][j] * l[k][j];
	    			
	    			l[k][i] = (A[k][i] - sum0) / l[i][i];
	    		}
	    		
	    		//main diagonal
	    		double sum = 0;
	    		for (int i = 0; i < k; i++)
	    			sum += Math.pow(l[k][i], 2);
	    		
	    		l[k][k] = Math.sqrt(A[k][k] - sum);
	    		
	    	}
	    	
	    	double[][] u = new double[n][n];
	    	
	    	u = transposeSquare(l, n);
	    	Object[] LU = new Object[n];
	    	LU[0] = l;
	    	LU[1] = u;
	    	return LU;
	    	
	    
	    }
	    
	    public static double[] myLuSymCholeskyDec(double[][] l, double[][] u, double[] B,int n){

	    	double[] x = new double[n];
	    	//forward sub
	    	double[] y = new double[n];
	    	y[0] = B[0] / l[0][0];
	    	
	    	for (int i = 1; i < n; i++) {
	    		double sum = 0;
	    		
	    		for (int j = 0; j < i; j++)
	    			sum = sum + l[i][j] * y[j];
	    		
	    		y[i] = (B[i] - sum) / l[i][i];
	    	}
	    	
	    	
	    	//back sub
	    	
	    	
	    	
	    	x[n - 1] = y[n - 1] / u[n - 1][n - 1];
	    	
	    	for (int i = n - 2; i >= 0; i--) {
	    		double sum = 0;
	    		
	    		for (int j = i + 1; j < n; j++)
	    			sum = sum + u[i][j] * x[j];
	    		
	    		x[i] = (y[i] - sum) / u[i][i];	    		
	    	}
	    	
	    	
	    	return x;	    	
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    
	 	
	 	
	    
	 
	    
	   
	    
	   


	  

	   

	    public static void main(String[] args){

	      /*  double A[][] = {
	                {1, 5, 2},
	                {2, 4, 3},
	                {1, 2, 3}
	        };
	        double mat2[][] = {
	                {3, 2, 1},
	                {0, 4, 2},
	                {0, 0, 1}
	        };
	        
	        double B[] = {0, 1, 2};
	        //double[][] x1 = myLuDoolitte(A, B, 3, 0.1);
	       // double[] x2 = backSub(mat2, b, 3);
	        //double[][] a = (double[][]) (myLuDoolitte(A, B, 3, 0.1));
	        Object[] obj = myLuDoolitte(A, B, 3, 0.1);
	        double[][] l = (double[][]) (obj[0]);
	        double[][] u = (double[][]) (obj[1]);

	        for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(u[i][j] + " ");//System.out.print(x1[o[i]][j] + " ");
	        	System.out.println();
	        }

/*
	        for (int i = 0; i < 3; i++)
	        	System.out.println(x2[i]);
*/

	    	// crout test
	    	
	    	/*double A[][] = {
	                {1, 3, 2},
	                {5, 1, 0},
	                {3, 2, 2}
	        };
	        double b[] = {1, 1, 1};
	        */
	    	/*double A[][] = {
	                {2, 74, 2},
	                {50, 11, 22},
	                {1, 3, 0}
	        };
	        double b[] = {11, 12, 13};
	    	
	    	
	    	Object[] LU = myCroutDecompose(A, 3);
	    	double[][] l = (double[][]) LU[0];
	    	double[][] u = (double[][]) LU[1];
	    	
	    	double x[] = myCroutSubstitute(l, u, 3, b);
	    	
	    	
	    	for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(l[i][j] + " ");
	        	System.out.println();
	        }
	    	
	    	System.out.println();

	    	for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(u[i][j] + " ");
	        	System.out.println();
	        }
	    	System.out.println();
	    	
	    	for (int j = 0; j < 3; j++)
        		System.out.print(x[j] + " ");
*/
	    	
	    	
	    	//choleskey
	    	
	    	/*double A[][] = {
	                {1, 3, 2},
	                {5, 1, 0},
	                {3, 2, 2}
	        };
	        double b[] = {1, 1, 1};
	        */
	     /*
	    	double A[][] = {
	                {2, 74, 2},
	                {50, 11, 22},
	                {1, 3, 0}
	        };
	        double b[] = {11, 12, 13};
	    	 
	    	
	    	Object[] LDU = myCholeskyDecompose(A, 3);
	    	double[][] l = (double[][]) LDU[0];
	    	double[][] d = (double[][]) LDU[1];
	    	double[][] u = (double[][]) LDU[2];
	    	double[] x = myCholeskySubstitute(l, d, u, 3, b);




	    	for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(l[i][j] + " ");
	        	System.out.println();
	        }
	    	
	    	System.out.println();

	    	for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(d[i][j] + " ");
	        	System.out.println();
	        }
	    	System.out.println();
	    	
	    	for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(u[i][j] + " ");
	        	System.out.println();
	        }
	    	System.out.println();
	    	
	    	
	    	
	    	for (int j = 0; j < 3; j++)
        		System.out.print(x[j] + " ");
	    	
	    	*/
	    	double A[][] = {
			            {1, 5, 3},
			            {5, 26, 2},
			            {3, 2, 179}
		   	};
		    double b[] = {1, 1, 1};
		    
		    Object[] lc = myLuSymCholesky(A, 3); 
	    	double[][] l =  (double[][]) lc[0];
	    	double[][] u = (double[][]) lc[1];
	    	
	    	double[] x = myLuSymCholeskyDec(l, u, b, 3);
	    	
	    	for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(l[i][j] + " ");
	        	System.out.println();
	        }
	    	System.out.println();
	    	
	    	
	    	for (int i = 0; i < 3; i++) {
	        	for (int j = 0; j < 3; j++)
	        		System.out.print(u[i][j] + " ");
	        	System.out.println();
	        }
	    	System.out.println();
	    	
	    	for (int j = 0; j < 3; j++)
        		System.out.print(x[j] + " ");
	    	
	    		
	    	
	    	
	        
	    }




	    
	    
	    


}
