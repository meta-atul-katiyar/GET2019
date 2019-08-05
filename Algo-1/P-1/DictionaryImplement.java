import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DictionaryImplement implements Dictionary{
	private static final String FILE_PATH = "C:\\Users\\Atul\\Downloads\\test.json";
	Node root = null;
	String sortedKeyVal="";
	
	public static JSONArray readJsonFile(String filePath){
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArr = null;
        try (FileReader reader = new FileReader(filePath))
        {
            //Read JSON file
            Object testJsonobj = jsonParser.parse(reader);
 
            jsonArr = (JSONArray) testJsonobj;
            
            for(Object obj : jsonArr.toArray()){
            	 
            	 System.out.println(obj.toString());
             }
             
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArr;
	}
	
	public void addJsonArray(JSONArray jsonArr){
		for(Object obj : jsonArr.toArray()){
			add(obj.toString());
        }
	}

	private Node bstAdd(Node root, Node newNode){
		if(root == null){
				root = newNode;
				return root;
		}
		if(root.key < newNode.key){
			root.right = bstAdd(root.right, newNode);
		}
		else if(root.key > newNode.key){
			root.left = bstAdd(root.left, newNode);
		}
		return root;
	}

	public void add(String keyValue) {
		
		String[] keyValPair = keyValue.split(":");
		String[] keyval = new String[2];
		keyval[0] = "";
		keyval[1] = "";
		for(int count = 0; count < 2; count++){
			int index = 1, limit = keyValPair[count].length()-2;
			if(count == 0){
				index = 2;
				limit += 1;
			}
			while(index < limit){
				keyval[count]+=keyValPair[count].charAt(index++);
			
			}
		}
		int key = Integer.parseInt(keyval[0]);
		Node newNode = new Node(key, keyval[1]);
		root = bstAdd(root,newNode);
		
	}

	private Node maxValNode(Node node){
		while(node.right.right != null){
			node = node.right;
		}
		return node;
	}
	
	
	private Node bstDelete(Node root, int key){
		if(root == null){
			return null;
		}
		if(root.key > key)
			root.left = bstDelete(root.left, key);
		else if(root.key < key)
			root.right = bstDelete(root.right, key);
		else{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			root = maxValNode(root.left);
			root.left = bstDelete(root.left, root.key);
		}
		return root;
	}

	public void delete(int key) {
		root = bstDelete(this.root, key);
	}

	public void printInorder(Node root){
		if(root != null){
			printInorder(root.left);
			System.out.println(root.key+":"+root.value);
			printInorder(root.right);
		}
	}
	public void print(){
		printInorder(root);
	}

	private Node findValue(Node root, int key){
		if(root.key == key){
			return root;
		}
		else if(root.key < key){
			return findValue(root.right, key);
		}
		else if(root.key >= key){
			return findValue(root.left, key);
		}
		else{
			throw new AssertionError("not found.");
		}
	}
	
	public String getValue(int key) {
		return findValue(this.root, key).value;
		
	}


	public String sorted() {
		retSorted(root);
		return sortedKeyVal;
	}
	public void retSorted(Node root){
		if(root != null){
			retSorted(root.left);
			sortedKeyVal +=  Integer.toString(root.key)+":"+root.value+"\t";
			retSorted(root.right);
		}
		
	}


	public void sortedK1ToK2(int key1, int key2) {
		printk1Tok2(root, key1, key2);
	}
	public void printk1Tok2(Node root, int key1, int key2){
		if( root != null){
			printk1Tok2(root.left, key1, key2);
			if(root.key >= key1 && root.key <= key2){
				
				System.out.println(root.key+":"+root.value);
			}
			printk1Tok2(root.right, key1, key2);
		}
	}
	
	public static void main(String[]args){
		DictionaryImplement di = new DictionaryImplement();
		JSONArray jsonArr = readJsonFile(FILE_PATH);
		di.addJsonArray(jsonArr);
		di.sortedK1ToK2(4,10);
		//di.delete(6);
		System.out.println(di.sorted());
		//di.print();
		
	}

	
}
