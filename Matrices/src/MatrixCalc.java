/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.Scanner;
public class MatrixCalc {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean stat = true;
		
		int option;
		
		while(stat){
		System.out.println(  "Za vuvejdane na matrica natisnete  1 a za izlizane 2");
			option = in.nextInt();
			switch(option){
			case 1: 
				
				// User chooses 
					stat = createProblem(option);
					break;
			case 2:
				// User leaves 
					stat = false;
					break;
			default:
				
					stat = false;
					break;
			}
		}
			System.out.println("Calculatora e sprqn");
	}
	// Calculator opens
	
	public static boolean createProblem(int i){
		Scanner in = new Scanner(System.in);
		boolean condition;
		
		int contStat;
		boolean statusC;
		// Matrix size
		int frows;
		int fcolumns;
		int srows;
		int scolumns;
		// Matrixs
		int[][] matrix1;
		int[][] matrix2;
		int[][] matrix1Values;
		int[][] matrix2Values;
		// User puts matrix's size
		System.out.println("vuvedete redica v purva matrica");
		frows = in.nextInt();
		String operator;
		System.out.println("vuvedete koloni v purva matrica");
		fcolumns = in.nextInt();
		System.out.println("vuvedete redica v vtora matrica");
		srows = in.nextInt();
		System.out.println("vuvedete koloni v vtora matrica");		
		scolumns = in.nextInt();
		// Creating of matrixes
		matrix1 = createMatrix(frows, fcolumns);
		matrix2 = createMatrix(srows, scolumns);
		// Adding data 
		matrix1Values = setMatrixValues(matrix1,"purva");
		matrix2Values = setMatrixValues(matrix2, "vtora");
		
		statusC = true;
		while(statusC){
			System.out.println(" + za subirane, - za izvajdane , * umnojenie:");
			operator = in.next();
			statusC = performOperation(operator, matrix1Values, matrix2Values);
		}
		// Allows Users to go to main menu
		System.out.println(" 1 za produljavane,\n  2 za izlizane");
		contStat = in.nextInt();
		switch(contStat){
		case 1:
			condition = true;
			break;
		case 2:
			condition = false;
			break;
		default:
			condition = false;
			break;
		}
		return condition;
		
	}
	
	public static boolean performOperation(String operator, int[][] matrix1, int[][] matrix2){
		Scanner in = new Scanner(System.in);
		int optSelected;
		boolean status = false;
		switch(operator){
		case "*":
			multiplyMatrices(matrix1, matrix2);
			break;
		case "+":
			addMatrices(matrix1, matrix2);
			break;
		case "-":
			subtractMatrices(matrix1, matrix2);
			break;
		default:
			System.out.println("Operatora e nevaliden");
			break;
		}
		
		System.out.println("Ako iskate drugi presmqtanie izpolzvaite "+
		" napishete  1, ako iskate razlichni matrici napishete 2"+
		"da izlezete napishete 3");
		optSelected = in.nextInt();
		switch(optSelected){
		case 1:
			status = true;
			break;
		case 2:
			status = false;
			break;
		case 3:
			status = false;
			break;
		}
		return status;
	}
	
	public static int[][] setMatrixValues(int[][] matrix, String label){
		Scanner in = new Scanner(System.in);
		int dataEntered;
		int rows = matrix.length;
		int columns = matrix[0].length;
		for(int i=0; i<rows; i++){
			
			for(int j=0; j< columns; j++){
				System.out.println("vuvedete "+label+" na matrica na red: "+i+" i kolona:"+j+" :");
				dataEntered = in.nextInt();
				matrix[i][j] = dataEntered;
			}
		}
		return matrix;
	}
	// Matrix size
	public static int[][] createMatrix(int numRows, int numColumns){
		int[][] matrix = new int[numRows][numColumns];
		return matrix;
	}
	// Operations
	public static void multiplyMatrices(int[][] matrix1, int[][] matrix2){
		boolean status = checkIfValidMult(matrix1, matrix2);
		if(status == true){
			
			for(int i=0; i<matrix1.length; i++){
				int total = 0;
				for(int j = 0; j<matrix2[0].length; j++){
					int fnum = matrix1[i][j];
					int snum = matrix2[j][i];
					int product = fnum*snum;
					total += product;
				}
				System.out.print(total+" ");
				
			}
		}
		else
		{
			System.out.println("nevalidno vuvejdane");
		}
	}
	public static void addMatrices(int[][] matrix1, int[][] matrix2){
		boolean status = checkIfValidAddSub(matrix1, matrix2);
		if(status == true){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					int charM1 = matrix1[i][j];
					int charM2 = matrix2[i][j];
					int resultant = charM1 + charM2;
					System.out.print(resultant+" ");
				}
				System.out.print("\n");
			}
		}
		else
		{
			System.out.println("Za da presmetnete matricite trqbva da sa s ednakvi paramteri");
		}
	}
	public static void subtractMatrices(int[][] matrix1, int[][] matrix2){
		boolean status = checkIfValidAddSub(matrix1, matrix2);
		if(status == true){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					int charM1 = matrix1[i][j];
					int charM2 = matrix2[i][j];
					int resultant = charM1 - charM2;
					System.out.print(resultant+ " ");
				}
				System.out.print("\n");
			}
		}
		else
		{
			System.out.println("Za da presmetnete matricite trqbva da sa s ednakvi parametri");
		}
	}
	
	
	public static boolean checkIfValidAddSub(int[][] matrix1, int[][] matrix2){
		boolean status;
		int numRows1 = matrix1.length;
		int numColumns1 = matrix1[0].length;
		int numRows2 = matrix2.length;
		int numColumns2 = matrix2[0].length;
                status = numRows1 == numRows2 && numColumns1 == numColumns2;
		return status;
	}
	public static boolean checkIfValidMult(int[][] matrix1, int[][] matrix2){
		boolean status;
		int columns = matrix1[0].length;
		int rows = matrix2.length;
                status = columns == rows;
		return status;
	}

}