import java.util.*;
import java.text.DecimalFormat;

public class Marksheet{ 
	static LinkedList<Integer> stuMarks = new LinkedList<Integer>();
	//upto 2 decimal places
	private static DecimalFormat df = new DecimalFormat("0.00");
	//input:list of student grade and number of students  output: average of all
	public static String avgGrade(LinkedList<Integer> marks){
		double avg = 0;
		int stuNum = 0;
		for (int sGrade : marks){
			avg += sGrade;
			stuNum+=1;
		}
		return df.format(avg/=stuNum);
	}
	//input:list of student grade  output:maximum of all
	public static int maxMarks(LinkedList<Integer> marks){
		int max = 0;
		for (int sGrade : marks){
			if(sGrade > max){
				max = sGrade;
			}
		}
		return max;
	}
	//input:list of student grade  output:minimum of all
	public static int minMarks(LinkedList<Integer> marks){
		int min = 100;
		for (int sGrade : marks){
			if(sGrade < min){
				min = sGrade;
			}
		}
		return min;
	}
	//input:list of student grade and number of students  output:percent of students passed
	public static String percentStuPass(LinkedList<Integer> marks){
		int pass =0, stuNum = 0;
		for (int sGrade : marks){
			count += 1;
			if (sGrade >= 40){
				pass += 1;
			}
		}
		return df.format(((pass)*100.0)/stuNum);
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
