
public class StudentList {
	private String name;
	private int rank;
	private int [] prefList = new int[5];
	private int progId = -1;
	
	StudentList(String name, int rank, int[] prefList){
		this.name = name;
		this.rank = rank;
		this.prefList = prefList;
	}
	
	String getName(){
		return name;
	}
	int getRank(){
		return rank;
	}
	int[] prefrenceOrder(){
		return prefList;
	}
	void setProgID(int id){
		this.progId = id;
	}
	int programId(){
		return progId;
	}
}
