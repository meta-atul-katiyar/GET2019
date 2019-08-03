 public class Employ{
 	private int empId;
 	private String name;
 	private String address;

 	Employ(int id, String name, String address){
 		this.empId = id;
 		this.name = name;
 		this. address = address;
 	}

 	String getName(){
 		return this.name;
 	}

 	String getAddress(){
 		return this.address;
 	}

 	int getEmpId(){
 		return empId;
 	}
 }
