import java.util.*;

public class Node{

	private String dirName;
	LinkedList<Node> innerDir = new LinkedList<Node>();
	Date createTime;
	Node parent = null;
	
	Node(String name){
		for(int count = 0; count < name.length(); count++){
			if(name.charAt(count) == '\\' || name.charAt(count) == '/' || name.charAt(count) == '|' ||
				name.charAt(count) == '<' || name.charAt(count) == '>' || name.charAt(count) == ':'){
					throw new AssertionError("can not include \\/><:\"");
				}
		}
		this.dirName = name;
		Date date = new Date();
		this.createTime = date;
	}
	
	String getDirName(){
		return this.dirName;
	}
	Date getDate(){
		return this.createTime;
	}
}