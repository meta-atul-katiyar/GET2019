import java.util.*;

public class Marksheet{
	static int numOfSubjects = 5;		//Subjects: hindi, english, socialScience, maths, science;
	static Scanner reader = new Scanner(System.in);
	static LinkedList<StudentMarks> stuobj = new LinkedList<StudentMarks>();

	public static double avgGrade(int[] stuMarksArray){
		double avg = 0;
		int count;
		for (count = 0; count < stuMarksArray.length; count++){
			avg += stuMarksArray[count];
		}
		return (avg/=count);
	}

	public static int maxMarks(int[] stuMarksArray){
		int max = 0;
		for (int count = 0; count < stuMarksArray.length; count++){
			int marks = stuMarksArray[count];
			if(marks > max){
				max = marks;
			}
		}
		return max;
	}

	public static int minMarks(int[] stuMarksArray){
		int min = 100;
		for (int count = 0; count < stuMarksArray.length; count++){
			int marks = stuMarksArray[count];
			if(marks < min){
				min = marks;
			}
		}
		return min;
	}

	public static double percentStuPass(LinkedList<StudentMarks> stu, int stuNum){
		int fail =0;
		for (StudentMarks s : stuobj){
			for (int count = 0; count < numOfSubjects; count++){
				System.out.println("ma "+s.subjectMarks[count]);
				if (s.subjectMarks[count] <= 40){
					fail += 1;
					//System.out.println(marksArray.subjectMarks[count]);
					//break;
				}
			}
		}
		return (double)((stuNum - fail)*100.0)/stuNum;
	}
	public static void addToObj (StudentMarks stu){
		stuobj.add(stu);
	}

	
	public static void main(String[] args){
		
		System.out.println("enter number of students: ");
		int stuNum = reader.nextInt();
		//StudentMarks[] stuobj = new StudentMarks[stuNum];
		for (int count = 0; count < stuNum; count++){
			System.out.println("enter marks space separated: ");
			Scanner reader1 = new Scanner(System.in);
			String strMarks = reader1.nextLine();
			//StudentMarks sobj = new StudentMarks();
			Marksheet mSheet = new Marksheet();
			Marksheet.addToObj (StudentMarks.insertMarks(strMarks, numOfSubjects));
		}
		for (StudentMarks s : stuobj){
			for (int count1 = 0; count1<numOfSubjects; count1++){
				System.out.println("m"+s.subjectMarks[count1]);
			}
		}

		System.out.println(percentStuPass(stuobj, stuNum));
	}
}