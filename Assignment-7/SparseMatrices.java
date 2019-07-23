import java.util.*;

public final class SparseMatrices {
	private final int immutableMatrix[][];
	
	/**
	 * @param matrix
	 * 
	 */
	public SparseMatrices(int[][] matrix){
		if(matrix.length == 0){
			throw new AssertionError("null matrix");
		}
		this.immutableMatrix = matrix;
	}
	
	/**
	 * @param object of class
	 * @return transpose of matrix (as 2d matrix)
	 */
	public static int[][] transpose(SparseMatrices sm){
		int valueLength = sm.immutableMatrix.length;
		for (int count=0; count < valueLength; count++){
			int tempVar = sm.immutableMatrix[count][0];
			sm.immutableMatrix[count][0] = sm.immutableMatrix[count][1];
			sm.immutableMatrix[count][1] = tempVar;
			
			System.out.println(sm.immutableMatrix[count][0]+" "+sm.immutableMatrix[count][1]+" "+sm.immutableMatrix[count][2]);
		}
		return sm.immutableMatrix;
	}
	
	/**
	 * @param object of class
	 * @return true if symmetric else false
	 */
	public static boolean isSymmetric(SparseMatrices sm){
		int valueLength = sm.immutableMatrix.length, checkLength = 0;
		for (int indexRow = 0; indexRow < valueLength; indexRow++){
			for (int indexColumn = 0; indexColumn < valueLength; indexColumn++){
				if(sm.immutableMatrix[indexRow][0] == sm.immutableMatrix[indexColumn][1] && sm.immutableMatrix[indexRow][1] == sm.immutableMatrix[indexColumn][0]){
					if(sm.immutableMatrix[indexRow][2] == sm.immutableMatrix[indexColumn][2]){
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
	
	/**
	 * @param object of class
	 * @return matrix size and number of entries in sparse matrix
	 */
	private static int[] matrixSize(SparseMatrices sm){
		int[] arr = new int[]{0,0,0};
		arr[2] = sm.immutableMatrix.length;
		for (int indexRow = 0; indexRow < arr[2]; indexRow++){
			if(sm.immutableMatrix[indexRow][0] > arr[0]){
				arr[0] = sm.immutableMatrix[indexRow][0];
			}
			if(sm.immutableMatrix[indexRow][1] > arr[1]){
				arr[1] = sm.immutableMatrix[indexRow][1];
			}
		}
		return arr;
	}
	
	/**
	 * @param sparse matrix as HashMap with HashMap<Integer[], Integer>
	 * @return sparse matrix as 2d array
	 */
	private static int[][] hashmapToArray(HashMap<Integer[], Integer> map){
		int [][] array = new int[map.size()][3];
		int index = 0;
		for(Integer[] key : map.keySet()){
			array[index][0] = key[0];
			array[index][1] = key[1];
			array[index][2] = map.get(key);
			index += 1;
		}
		return array;
	}
	
	/**
	 * @param class object
	 * @param class object
	 * @return sum of two sparse matrix
	 */
	public static int[][] addTwoMatrices(SparseMatrices sm1, SparseMatrices sm2){
		int	newLength = 0;
		int [] matrixParam1 = matrixSize(sm1);
		int [] matrixParam2 = matrixSize(sm2);
		HashMap<Integer[], Integer> map = new HashMap<>();
		if(matrixParam1[0] == matrixParam2[0] && matrixParam1[1] == matrixParam2[1]){
			for (int indexRow = 0; indexRow < matrixParam1[2]; indexRow++){
				for (int indexColumn = 0; indexColumn < matrixParam2[2]; indexColumn++){
					if(sm1.immutableMatrix[indexRow][0] == sm2.immutableMatrix[indexColumn][0] && 
							sm2.immutableMatrix[indexColumn][1] == sm1.immutableMatrix[indexRow][1]){
						
						Integer[] key = new Integer[] {sm1.immutableMatrix[indexRow][0],
								sm1.immutableMatrix[indexRow][1]};
						map.put(key, sm1.immutableMatrix[indexRow][2]+sm2.immutableMatrix[indexRow][2]);
						indexRow += 1;
						indexColumn = 0;
						newLength += 1;
						
					}
					else if(indexColumn == matrixParam2[2]-1) {
						Integer[] key = new Integer[] {sm1.immutableMatrix[indexRow][0],
								sm1.immutableMatrix[indexRow][1]};
						map.put(key, sm1.immutableMatrix[indexRow][2]);
						
						key = new Integer[] {sm2.immutableMatrix[indexRow][0],
								sm2.immutableMatrix[indexRow][1]};
						map.put(key, sm2.immutableMatrix[indexRow][2]);
						
						newLength += 2;
					}
				}
			}
		}
		else{
			throw new AssertionError("addition of these matrices not possible.");
		}
		return hashmapToArray(map);
	}
	
	/**
	 * @param class object
	 * @param class object
	 * @return multiplication of sparse matrix
	 */
	public static int[][] multiplyMatrices(SparseMatrices sm1, SparseMatrices sm2){
		int	newLength = 0;
		int [] matrixParam1 = matrixSize(sm1);
		int [] matrixParam2 = matrixSize(sm2);

        HashMap<Integer[], Integer> map = new HashMap<>();
		if(matrixParam1[1] == matrixParam2[1]){
			for (int indexRow = 0; indexRow < matrixParam1[2]; indexRow++){
				for (int indexColumn = 0; indexColumn < matrixParam2[2]; indexColumn++){
					if(sm2.immutableMatrix[indexColumn][0] == sm1.immutableMatrix[indexRow][1]){
						Integer arr[]= new Integer[]{sm1.immutableMatrix[indexRow][0],
								sm2.immutableMatrix[indexColumn][1]};
						int num = sm1.immutableMatrix[indexRow][2] * sm2.immutableMatrix[indexColumn][2];
						if(map.get(arr) == null){
							map.put(arr, num);
						}
						else{
							map.replace(arr, map.get(arr)+num);
						}
					}
				}
			}
		}
		else{
			throw new AssertionError("multiplication of these matrices not possible.");
		}
		return hashmapToArray(map);
	}
	
	public static void main(String[] args){
		int[][] matrix = new int[][] {
				{0,0,1},
				{1,1,2},
				{2,2,3},
				{3,3,4},
				{4,4,5},
				{5,5,6}
		};
		int [][] matrix1 = new int[][]{
				{0,2,3},
				{0,4,4},
				{1,1,5},
				{4,5,4},
				{5,1,5},
				{2,0,3}
		};
		
		SparseMatrices sm1 = new SparseMatrices(matrix);
		SparseMatrices sm2 = new SparseMatrices(matrix1);
		int[][] arr = multiplyMatrices(sm1,sm2);
		int length = arr.length;
		System.out.println("multiplication:");
		for(int i =0; i<length; i++){
			System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
		}	
	}
}
