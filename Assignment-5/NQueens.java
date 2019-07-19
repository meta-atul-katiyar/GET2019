
public class NQueens {
	static int N;
	static int [][] board;
	//crate board
	public static int[][] createBoard(int n){
		N = n;
		board = new int[N][N];
		for(int i = 0; i<N;i++){
			for (int j=0;j<N;j++){
				board[i][j] = 0;
			}
		}
		return board;
	}
	//check the next chosen place is valid or not
	public static boolean isValid(int [][]board, int rowValue, int columnValue, int n){
		int row = 0, column = 0;
		while(row < n && column < n){
			if(board[row][columnValue] == 1 || board[rowValue][column] == 1){
				return false;
			}
			row+=1; column+=1;
		}
		row = rowValue; column = columnValue;
		while(row>=0 && column>=0){
			if(board[row][column] == 1){
				return false;
			}
			row-=1; column-=1;
		}
		row = rowValue; column = columnValue;
		while(row<n && column<n){
			if(board[row][column] == 1){
				return false;
			}
			row+=1; column+=1;
		}
		row = rowValue; column = columnValue;
		while(row<n && column>=0){
			if(board[row][column] == 1){
				return false;
			}
			row += 1;
			column -= 1;
		}
		row = rowValue; column = columnValue;
		while(row>=0 && column<n){
			if(board[row][column] == 1){
				return false;
			}
			row -= 1;
			column += 1;
		}
		return true;
	}
	
	public static void applyValue(int[][] board, int rowValue, int columnValue){
		board[rowValue][columnValue] = 1;
	}
	
	public static void removeValue(int[][] board, int rowValue, int columnValue){
		board[rowValue][columnValue] = 0;
	}
	
	public static void displayBoard(){
		System.out.println("board: ");
		for(int i = 0; i<N;i++){
			for (int j=0;j<N;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix){
		if(dimensionOfMatrix == 0){
			displayBoard();
			return true;
		}
		for (int countRow = startRow; countRow < N; countRow++){
			for (int countColumn = 0; countColumn < N; countColumn++){
				if( isValid(board, countRow, countColumn, N)){
					applyValue(board, countRow, countColumn);
					dimensionOfMatrix -= 1;
					
					if(nQueen(board, countRow, dimensionOfMatrix)){
						return true;
					}
					removeValue(board, countRow, countColumn);
					dimensionOfMatrix += 1;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args){
		createBoard(3);
		System.out.print(nQueen(board, 0, N));
	}
}
