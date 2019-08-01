import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.*;
import jxl.write.Number;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Counselling {
	
	 private static  String STUDENT_DATA;
	 private static  String PROGRAM_LIST;
	 private static  String COUNSELLING_RESULT;
	 private static int studentNumber;
	 private static int programNumber;
	 static StudentQueue studentList;
	 static CollegeProgramList[] progList;
	 static Workbook workbook = null;
	 static WritableWorkbook counselResultWBook = null;
	
	 Counselling(String studentData, String programList, String result){
		 STUDENT_DATA = studentData;
		 PROGRAM_LIST = programList;
		 COUNSELLING_RESULT = result;
	 }
	 
	 
	 /**
	 * @param studentList
	 * @return list of students
	 */
	public static StudentQueue importStudentData(StudentQueue studentList){
		  try {
	        	try{
	        		workbook = Workbook.getWorkbook(new File(STUDENT_DATA));
	        	}
	        	catch(java.io.FileNotFoundException e){
	        		e.printStackTrace();
	        	}
	            Sheet sheet = workbook.getSheet(0);
	            studentNumber = sheet.getRows();
	            if(studentNumber < 1){
	            	throw new AssertionError("empty student file.");
	            }
	            System.out.println(studentNumber);
	            studentList = new StudentQueue(studentNumber-1);
	            for (int rowNum = 1; rowNum < studentNumber; rowNum++) {
					Cell[] row = sheet.getRow(rowNum);
					String name;
					int rank;
					int[] prefOrder = new int[5];
					name = row[0].getContents();
					rank = Integer.parseInt(row[1].getContents());
					String[] order = row[2].getContents().split(",");
					for(int count = 0; count < 5; count++){
						prefOrder[count] = Integer.parseInt(order[count]);
					}
					//System.out.println(name);
					StudentList sLObj = new StudentList(name,rank,prefOrder);
					studentList.insert(sLObj);
				}
		  }
		  catch (IOException e) {
			  e.printStackTrace();
		 } 
		  catch (BiffException e) {
			  e.printStackTrace();
		 }
		 finally {
			 if (workbook != null) {
				 workbook.close();
			 }
		 }
		  workbook = null;
		  return studentList;
	 }
	 
	 /**
	 * @param progList
	 * @return list of program
	 */
	public static CollegeProgramList[] importProgramList(CollegeProgramList[] progList){
		 try{
         	workbook = Workbook.getWorkbook(new File(PROGRAM_LIST));
         }
         catch(java.io.FileNotFoundException e){
         	e.printStackTrace();
         }
		 catch (BiffException e) {
			e.printStackTrace();
		 }
		 catch (IOException e) {
			e.printStackTrace();
		}
         Sheet programSheet = workbook.getSheet(0);
         programNumber = programSheet.getRows();
         if(programNumber < 1){
         	throw new AssertionError("empty student file.");
         }
         progList = new CollegeProgramList[programNumber];
         
         for (int rowNum = 1; rowNum < programNumber; rowNum++) {
				Cell[] row = programSheet.getRow(rowNum);
				String name;
				int id;
				int capacity;
				
				name = row[0].getContents();
				//
				id = Integer.parseInt(row[1].getContents());
				capacity = Integer.parseInt(row[2].getContents());
				//System.out.println(capacity);
				progList[rowNum-1] = new CollegeProgramList(name,id,capacity);
				
			}
         return progList;
	 }
	 
	
	/**
	 * @param studentList
	 * @param progList
	 * create excel sheet
	 */
	public static void allotment(StudentQueue studentList ,CollegeProgramList[] progList){
		studentList = importStudentData(studentList);
		progList = importProgramList( progList);
		//writing the alloted program directly in excel sheet
        try{
        	counselResultWBook = Workbook.createWorkbook(new File(COUNSELLING_RESULT));
	           WritableSheet excelSheet = counselResultWBook.createSheet("Sheet 1", 0);
	           int row = 1;
	           while(!studentList.isEmpty()){
	            	 StudentList stuList = studentList.peep();
	            	 int[] prefList = stuList.prefrenceOrder();
	            	 for(int pref = 0; pref < 5; pref++){
	            		 int flag = 0;
	            		 for (int program = 0; program < programNumber-1; program++){
	            			int progId = progList[program].getId();
	 	            		if(prefList[pref] == progId){
	 	            			if(progList[program].reduceCapacity()){
	 	            				stuList.setProgID(progId);
	 	            				flag = 1;
	 	            			}
	 	            		}
	 	            	}if(flag == 1){
	 	            		break;
	 	            	}
	            	 }
	            	 Label label = new Label(0, row, stuList.getName());
	                 try{
	                	 excelSheet.addCell(label);
	                 }catch(Exception e){
	                	 e.printStackTrace();
	                 }

	                 Number rank = new Number(1, row, stuList.getRank());
	                 try{
	                	 excelSheet.addCell(rank);
	                 }catch(Exception e){
	                	 e.printStackTrace();
	                 }
	                 Label pref = new Label(2, row, Arrays.toString(stuList.prefrenceOrder()));
	                 try{
	                	 excelSheet.addCell(pref);
	                 }catch(Exception e){
	                	 e.printStackTrace();
	                 }
	                 Number progId = new Number(3, row, stuList.programId());
	                 try{
	                	 excelSheet.addCell(progId);
	                 }catch(Exception e){
	                	 e.printStackTrace();
	                 }
	                 row++;
	            	 studentList.delete();
	            }
	           counselResultWBook.write();
	            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (counselResultWBook != null) {
                try {
                	counselResultWBook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
         }
	 }
	 public static void main(String[]args){
		 String stu = "C:\\Users\\Atul\\Downloads\\studentData.xls",
				 prog = "C:\\Users\\Atul\\Downloads\\programList.xls",
				 result = "C:\\Users\\Atul\\Downloads\\counselResult1.xls";
		 
		 
		 Counselling counsel = new Counselling(stu, prog, result);
		 counsel.allotment(studentList, progList);
	 }
}
