import java.util.*;
import java.text.DecimalFormat;

public class Marksheet{
	static LinkedList<Integer> stuMarks = new LinkedList<Integer>();
	//upto 2 decimal places
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public static String avgGrade(LinkedList<Integer> stu, int stuNum){
		double avg = 0;
		int count;
		for (int sGrade : stu){
			avg += sGrade;
		}
		return df.format(avg/=stuNum);
	}

	public static int maxMarks(LinkedList<Integer> stu){
		int max = 0;
		for (int sGrade : stu){
			if(sGrade > max){
				max = sGrade;
			}
		}
		return max;
	}

	public static int minMarks(LinkedList<Integer> stu){
		int min = 100;
		for (int sGrade : stu){
			if(sGrade < min){
				min = sGrade;
			}
		}
		return min;
	}

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
		int stuNum = reader.nextInt();
		for (int count = 0; count < stuNum; count++){
			System.out.println("enter Grade: ");
			//Scanner reader1 = new Scanner(System.in);
			int grade = reader.nextInt();
			if(grade < 0 || grade > 100){
				System.out.println("try something between 0 and 100");
				grade = reader.nextInt();
				stuMarks.add(grade);
				
			}
			else{
				stuMarks.add(grade);
			}
			
		}
		System.out.println(avgGrade(stuMarks, stuNum));
	}
}