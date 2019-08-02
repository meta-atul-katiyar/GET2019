import java.util.*;

public class VirtualCommandPrompt{
	 static Node root = new Node("root");
	 static Node currentDir = root;
	
	public static void ls(Node currDir){
		
		for(Node node : currDir.innerDir){
			System.out.println(node.getDirName());
		}
	}
	
	/**
	 * @param dirList
	 * change directory
	 */
	public void cd(String dirList){
		if(dirList.equals("")){
			throw new AssertionError("mkdir: missing operand");
		}
		String[] dir = dirList.split("/");
		
		int dirLength = dir.length, index = 0;
		
		if(dir[dirLength - 1].equals("")){
			if(dir[dirLength - 2].equals("")){
				throw new AssertionError("mkdir:"+dirList+" invalid");
			}
			dirLength -= 1;
		}
		Node tempCurrDir = this.currentDir;
		if(dir[0].equals("")){
			tempCurrDir = root;
			
		}
		Node currNode = tempCurrDir;
		
		 while(index < dirLength-1){
			 Node lastNode = isDirExist(currNode, dir[index]);
			 if(lastNode == null){
				 throw new AssertionError("mkdir:"+dir[index]+" not exist");
			 }
			 index+=1;
			 currNode = lastNode;
		 }
		 Node lastNode = isDirExist(currNode, dir[index]);
		 if(lastNode != null){
			 this.currentDir = lastNode;
			 System.out.println("dir changed");
		 }
	
	}
	/**
	 * to go back to parent
	 */
	public static void bk(){
		if(!currentDir.getDirName().equals("root")){
			currentDir = currentDir.parent;
		}
	}
	/**
	 * @param tempCurrDir
	 * @param dirName
	 * @param address
	 * @return nodes list of address
	 */
	public static LinkedList<String> find(Node tempCurrDir, String dirName, LinkedList<String> address){
		address.add(tempCurrDir.getDirName());
		for(Node node:tempCurrDir.innerDir){
			find(node, dirName, address);
			if(tempCurrDir.getDirName().equals(dirName)){
				address.add(tempCurrDir.getDirName());
				return address;
			}
			else if(node.innerDir.peek() == null){
				address.removeLast();
			}
		}
		if(tempCurrDir.getDirName().equals(dirName)){
			address.add(tempCurrDir.getDirName());
		}
		
		return address;
		
	}

	/**
	 * @param exit
	 */
	public void exit(String exit){
		if(exit.equals("exit")){
			System.exit(0);
		}
	}
	
	
	/**
	 * @param input
	 * @return true for proper input
	 */
	private static boolean validation(String input){
		String[] splitedStr = input.split("/");
		for(int count = 1; count < splitedStr.length; count++){
			if(splitedStr[count-1].equals(splitedStr[count]) && splitedStr[count].equals("")){
				return false;
			}
		}
		return true;
	}

	/**
	 * @param node
	 * @param name
	 * @return return node if dir exist else null
	 */
	private Node isDirExist(Node node, String name){
		
		if(node.getDirName().equals(name)){
			return node;
		}
		LinkedList<Node> currNodeList = node.innerDir;
		for(Node tempNode : currNodeList){
			if(tempNode.getDirName().equals(name)){
				return tempNode;
			}
		}
		 return null;
	}
	
	/**
	 * @param dirList
	 * create directory
	 */
	public void mkdir(String dirList){
		if(dirList.equals("")){
			throw new AssertionError("mkdir: missing operand");
		}
		String[] dir = dirList.split("/");
		int dirLength = dir.length, index = 0;
		if(dir[dirLength - 1].equals("")){
			if(dir[dirLength - 2].equals("")){
				throw new AssertionError("mkdir:"+dirList+" invalid");
			}
			dirLength -= 1;
		}
		Node tempCurrDir = this.currentDir;
		if(dir[0].equals("")){
			tempCurrDir = root;	
		}
		
		Node currNode = tempCurrDir;
		
		 while(index < dirLength-1){
			 Node lastNode = isDirExist(currNode, dir[index]);
			 if(lastNode == null){
				 throw new AssertionError("mkdir:"+dir[index]+" not exist");
			 }
			 index+=1;
			 currNode = lastNode;
		 }
		 Node lastNode = isDirExist(currNode, dir[index]);
		 if(lastNode == null){
			 Node newNode = new Node(dir[index]);
			 newNode.parent = currNode;
			 currNode.innerDir.add(newNode);
			// System.out.println("created");
		 }
		 else{
			 throw new AssertionError("exist");
		 }
		  
		
	}
	
	/**
	 * print ls
	 */
	public void ls(){
		for(Node node : this.currentDir.innerDir){
			System.out.println(node.getDirName()+" "+node.getDate());
		}
	}
	
	/**
	 * @param rootNode
	 * print tree structure
	 */
	public void tree(Node rootNode){
		System.out.println(rootNode.getDirName());
		for(Node node: rootNode.innerDir){
			tree(node);
		}
	}

	/**
	 * @param input
	 * @return formated input
	 */
	public static String getUserInput(String input){
		if(validation(input) == false){
			throw new AssertionError("two '/' are together");
		}
		
		String[] cmd = input.split(" ");
		int indexCmd = 0, indexDirList = 0;
		while(indexCmd < cmd.length && cmd[indexCmd].equals("")){
			indexCmd+=1;
		}
		indexDirList = indexCmd+1;
		while(indexDirList < cmd.length && cmd[indexDirList].equals("")){
			indexDirList+=1;
		}
		return(cmd[indexCmd]+" "+cmd[indexDirList]);
	}

	/**
	 * @param cmd
	 * handle commands
	 */
	public void performOp(String cmd){
		String[] command = cmd.split(" ");

		switch(command[0]){
			case "mkdir":
				mkdir(command[1]);

				break;

			case "cd":
				cd(command[1]);
				break;

			case "bk":
				bk();
				break;

			case "ls":
				/*ls();*/
				break;

			case "find":
				LinkedList<String> address = new LinkedList<String>();
				address = find(this.currentDir, command[1], address);
				break;

			case "tree":
				tree(this.root);
				break;

			case "exit":
				exit(cmd);
				break;

			default:
				throw new AssertionError(command[0]+": command not found");
		}
	}

	public static void main(String[]args){
		VirtualCommandPrompt vcp = new VirtualCommandPrompt();
		
		LinkedList<String> address = new LinkedList<String>();
		vcp.performOp(getUserInput("     mkdir p"));
		vcp.performOp(getUserInput("     mkdir p/q"));
		vcp.performOp(getUserInput("     mkdir p/m"));
		vcp.performOp(getUserInput("     mkdir p/q/a"));
		vcp.performOp(getUserInput("     mkdir p/q/b"));
		vcp.performOp(getUserInput("     mkdir p/q/d"));
		vcp.performOp(getUserInput("     mkdir p/q/d/f"));
		address = vcp.find(currentDir, "f", address);
		for(String node: address){
			System.out.print(node+"/");
		}
		
	}
}