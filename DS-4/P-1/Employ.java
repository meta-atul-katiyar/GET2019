 public class Employ{
	static int id = 0;
 	private int empId;
 	private String name;
 	private String address;

 	Employ(String name, String address){
 		this.empId = ++id;
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