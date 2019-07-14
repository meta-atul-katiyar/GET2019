import java.util.*;

public class StudentMarks{
	static int numOfSubjects = 5;
	static int[] subjectMarks = new int[numOfSubjects];
	public static StudentMarks insertMarks(String str, int numOfSubjects){
		StudentMarks stuobj = new StudentMarks();
		String [] marks =  str.split(" ");
		for (int count1 = 0; count1 < numOfSubjects; count1++){
			System.out.println("marks: "+(marks[count1]));
		}
		for (int count1 = 0; count1 < numOfSubjects; count1++){
			stuobj.subjectMarks[count1] = Integer.parseInt(marks[count1]);
		}
		return stuobj;
	}
}