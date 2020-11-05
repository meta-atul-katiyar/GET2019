public class Employee{
 	private int empId;
 	private String name;
 	private int salary;
 	private String dob;

 	Employee(int id, String name, int salary, String dob){
 		String[] str = dob.split("-");
 		int [] dobInt = new int[]{
 				Integer.parseInt(str[0]),
 				Integer.parseInt(str[1]),
 				Integer.parseInt(str[2])
 		};
 		if(dobInt[2]<1950 ){
 			throw new AssertionError("wrong date");
 		}
 		if(dobInt[1] > 0 && dobInt[1] < 13){
 			if(dobInt[1] == 2){
 				if(dobInt[0] < 0 && dobInt[0] > 29){
 					throw new AssertionError("wrong date");
 				}
 			}
 			else if (dobInt[1] == 4 || dobInt[1] == 6 || dobInt[1] == 9||
 					dobInt[1] == 11){
					if(dobInt[0]< 0 && dobInt[0] > 30){
						throw new AssertionError("wrong date");
					}
			}
 			else{
 				if(dobInt[0]< 0 && dobInt[0] > 31){
					throw new AssertionError("wrong date");
				}
 			}
 		}
 		this.empId = id;
 		this.name = name;
 		this. salary = salary;
 		this. dob = dob;
 	}

 	String getName(){
 		return this.name;
 	}

 	String getdob(){
 		return this.dob;
 	}
 	
 	int getSalary(){
 		return this.salary;
 	}

 	int getEmpId(){
 		return empId;
 	}
 	
 	int getAge(){
 		String[] str = this.dob.split("-");
 		return Integer.parseInt(str[2]);
 	}
 }
