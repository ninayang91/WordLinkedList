
public class Node<String> {
	String s;
	Node<String> next;
	
	public Node(){
		this.s=null;
		this.next=null;
	}
	
	public Node(String s, Node<String> next){
		this.s=s;
		this.next=next;
	}

}
