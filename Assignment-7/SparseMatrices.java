import java.util.*;
public final class SparseMatrices {
	final int[] row;
	final int[] column;
	final int[] value;
	
	public SparseMatrices(int[]arrRow, int[]arrColumn, int[]arrValue){
		int arrRowLength = arrRow.length;// arrColumnLength = arrColumn.length, arrValueLength = arrValue.length;
		if((arrRowLength == arrColumn.length) && ( arrRowLength== arrValue.length)){
			this.row = arrRow;
			this.column = arrColumn;
			this.value = arrValue;
		}
		else{
			throw new AssertionError("not valid data.");
		}
	}
	
	public static int[][] transpose(SparseMatrices sm){
		int valueLength = sm.value.length;
		int[][] sparseMatrix = new int[3][valueLength];
		for (int count=0; count < valueLength; count++){
			int tempVar = sm.row[count];
			sm.row[count] = sm.column[count];
			sm.column[count] = tempVar;
			
			System.out.println(sm.row[count]+" "+sm.column[count]+" "+sm.value[count]);
		}
		return sparseMatrix;
	}
	
	public static boolean isSymmetric(SparseMatrices sm){
		int valueLength = sm.value.length, checkLength = 0;
		for (int indexRow = 0; indexRow < valueLength; indexRow++){
			for (int indexColumn = 0; indexColumn < valueLength; indexColumn++){
				if(sm.row[indexRow] == sm.column[indexColumn] && sm.row[indexColumn] == sm.column[indexRow]){
					if(sm.value[indexRow] == sm.value[indexColumn]){
						checkLength += 1;
						System.out.println(checkLength);
					}
				}
			}
		}
		if(checkLength == valueLength){
			return true;
		}
		return false;
	}
	
	private static int[] matrixSize(SparseMatrices sm){
		int[] arr = new int[]{0,0,0};
		arr[2] = sm.value.length;
		for (int indexRow = 0; indexRow < arr[2]; indexRow++){
			if(sm.row[indexRow] > arr[0]){
				arr[0] = sm.row[indexRow];
			}
			if(sm.column[indexRow] > arr[1]){
				arr[1] = sm.column[indexRow];
			}
		}
		return arr;
	}
	public static int[][] addTwoMatrices(SparseMatrices sm1, SparseMatrices sm2){
		int	newLength = 0;
		int [] matrixParam1 = matrixSize(sm1);
		int [] matrixParam2 = matrixSize(sm2);
		System.out.println("atul "+matrixParam1[0]+" "+matrixParam2[0]);
		LinkedList <Integer> rowList = new LinkedList <Integer> ();
		LinkedList <Integer> columnList = new LinkedList <Integer> ();
		LinkedList <Integer> valueList = new LinkedList <Integer> ();
		if(matrixParam1[0] == matrixParam2[0] && matrixParam1[1] == matrixParam2[1]){
			for (int indexRow = 0; indexRow < matrixParam1[2]; indexRow++){
				for (int indexColumn = 0; indexColumn < matrixParam2[2]; indexColumn++){
					if(sm1.row[indexRow] == sm2.row[indexColumn] && sm2.column[indexColumn] == sm1.column[indexRow]){
						rowList.add(sm1.row[indexRow]);
						columnList.add(sm1.column[indexRow]);
						valueList.add(sm1.value[indexRow] + sm2.value[indexColumn]);
						indexRow += 1;
						indexColumn = 0;
						newLength += 1;
						
					}
					else if(indexColumn == matrixParam2[2]-1) {
						rowList.add(sm1.row[indexRow]);
						columnList.add(sm1.column[indexRow]);
						valueList.add(sm1.value[indexRow]);
						
						rowList.add(sm2.row[indexColumn]);
						columnList.add(sm2.column[indexColumn]);
						valueList.add(sm2.value[indexColumn]);
						
						newLength += 2;
					}
				}
				//System.out.println(newLength);
			}
		}
		else{
			throw new AssertionError("addition of these matrices not possible.");
		}
		int array[][] = new int [3][newLength];
		for(int columnNum = 0; columnNum < newLength; columnNum++){
			array[0][columnNum] = rowList.removeFirst();
			array[1][columnNum] = columnList.removeFirst();
			array[2][columnNum] = valueList.removeFirst();
			System.out.println(array[0][columnNum]+" "+array[1][columnNum]+" "+array[2][columnNum]);
		}
		return array;
	}
	
	public static int[][] multiplyMatrices(SparseMatrices sm1, SparseMatrices sm2){
		int	newLength = 0;
		int [] matrixParam1 = matrixSize(sm1);
		int [] matrixParam2 = matrixSize(sm2);
		
		LinkedList <Integer> rowList = new LinkedList <Integer> ();
		LinkedList <Integer> columnList = new LinkedList <Integer> ();
		LinkedList <Integer> valueList = new LinkedList <Integer> ();
		if(matrixParam1[1] == matrixParam2[1]){
			for (int indexRow = 0; indexRow < matrixParam1[2]; indexRow++){
				for (int indexColumn = 0; indexColumn < matrixParam2[2]; indexColumn++){
					if(sm1.row[indexRow] == sm2.column[indexColumn] && sm2.row[indexColumn] == sm1.column[indexRow]){
						rowList.add(sm1.row[indexRow]);
						columnList.add(sm2.column[indexColumn]);
						valueList.add(sm1.value[indexRow] * sm2.value[indexColumn]);
						newLength += 1;
					}
				}
			}
		}
		else{
			throw new AssertionError("multiplication of these matrices not possible.");
		}
		int array[][] = new int [3][newLength];
		for(int columnNum = 0; columnNum < newLength; columnNum++){
			array[0][columnNum] = rowList.removeFirst();
			array[1][columnNum] = columnList.removeFirst();
			array[2][columnNum] = valueList.removeFirst();
			System.out.println(array[0][columnNum]+" "+array[1][columnNum]+" "+array[2][columnNum]);
		}
		return array;
	}
	
	public static void main(String[] args){
		int[] row = new int[]   {0,1,4,3,4,5};
		int[] column = new int[]{0,1,0,3,4,5};
		int[] value = new int[] {1,2,3,4,5,6};
		
		int[] row1 = new int[]   {0,0,1,4,5,2};
		int[] column1 = new int[]{2,4,1,5,1,0};
		int[] value1 = new int[] {3,4,5,4,5,3};
		
		SparseMatrices sm1 = new SparseMatrices(row, column, value);
		SparseMatrices sm2 = new SparseMatrices(row1, column1, value1);
		//int[][] arr= transpose(sm1);
		int[][] arr1 = multiplyMatrices(sm1,sm2);
		//System.out.println(isSymmetric(sm1));
		
	}
	
}
