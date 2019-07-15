import java.util.*;
import java.text.DecimalFormat;

public class Marksheet{
	static LinkedList<Integer> stuMarks = new LinkedList<Integer>();
	//upto 2 decimal places
	private static DecimalFormat df = new DecimalFormat("0.00");
	//input:list of student grade and number of students  output: average of all
	public static String avgGrade(LinkedList<Integer> stu, int stuNum){
		double avg = 0;
		int count;
		for (int sGrade : stu){
			avg += sGrade;
		}
		return df.format(avg/=stuNum);
	}
	//input:list of student grade  output:maximum of all
	public static int maxMarks(LinkedList<Integer> stu){
		int max = 0;
		for (int sGrade : stu){
			if(sGrade > max){
				max = sGrade;
			}
		}
		return max;
	}
	//input:list of student grade  output:minimum of all
	public static int minMarks(LinkedList<Integer> stu){
		int min = 100;
		for (int sGrade : stu){
			if(sGrade < min){
				min = sGrade;
			}
		}
		return min;
	}
	//input:list of student grade and number of students  output:percent of students passed
	public static String percentStuPass(LinkedList<Integer> stu, int stuNum){
		int fail =0;
		for (int sGrade : stu){
			if (sGrade <= 40){
				fail += 1;
			}
		}
		return df.format(((stuNum - fail)*100.0)/stuNum);
	}
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("enter number of students: ");
		try{
			int stuNum = reader.nextInt();
		}catch(NumberFormatException e){
	  		System.out.println("Number format exception occurred");
       		}
		for (int count = 0; count < stuNum; count++){
			System.out.println("enter Grade: ");
			try{
				int grade = reader.nextInt();
			}catch(NumberFormatException e){
	  			System.out.println("Number format exception occurred");
       			}
			if(grade < 0 || grade > 100){
				System.out.println("try something between 0 and 100");
				try{
					grade = reader.nextInt();
				}catch(NumberFormatException e){
	  				System.out.println("Number format exception occurred");
       				}
				stuMarks.add(grade);	
			}
			else{
				stuMarks.add(grade);
			}
		}
		System.out.println(avgGrade(stuMarks, stuNum));
	}
}
