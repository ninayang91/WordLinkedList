
public class WordLinkedList {
	
//Singly linked list to store words in alphabetical order (use method compareTo)
//No duplicates
//Merger one WordLinkedList to "this" WordLinkedList. Requirement time O(n1+n2) space O(1)
	private int size;
	private Node<String> header;
	
	public WordLinkedList(){
		size=0;
		header =new Node<String>(null,null);
	}
	
	public WordLinkedList(String[] arrayOfWords){//No duplicates
		
		this();
		if(arrayOfWords==null) return;
		int n=arrayOfWords.length;
		for(int i=0;i<n;i++){
			insert(arrayOfWords[i]);
		}
	}
	
	public void insert(String word){
		Node<String> p=header;
/*		if(header.next==null){
			Node<String> temp=new Node<>(word, header.next);
			header.next=temp;
		}*/
		for(;p.next!=null;p=p.next){
			if(p.next.s.compareTo(word)==0){
				return;
			}else if(p.next.s.compareTo(word)>0){
				Node<String> temp=new Node<>(word,p.next);
				p.next=temp;
				size++;
				return;
			}
		}
		Node<String> temp=new Node<>(word,p.next);
		p.next=temp;
		size++;
		
		
	}
	
	public void mergeTo(WordLinkedList that){//O(n1+n2) time complexity //O(1) space complexity
		Node<String> pThat=that.header.next;
		Node<String> pThis1=this.header,pThis2=this.header.next;
		while(pThis2!=null && pThat!=null){//for(;pThis.next!=null;pThis=pThis.next){
			if(pThat.s.compareTo(pThis2.s)==0){
					pThat=pThat.next;
					that.header.next=pThat;
					that.size--;
			}else if(pThat.s.compareTo(pThis2.s)<0){
				that.header.next=pThat.next;
				pThis1.next=pThat;
				pThat.next=pThis2;
				pThat=that.header.next;
				pThis1=pThis1.next;
				that.size--;
				this.size++;
			}else{
				pThis1=pThis2;
				pThis2=pThis2.next;
			}
			
		}
		if(pThat==null){
			return;
		}else{
			for(Node<String> p=that.header.next;p!=null;p=p.next){
				this.size++;
			}
			pThis1.next=that.header.next;
			that.header.next=null;
			that.size=0;
		}
	}

	public String remove(int i){
		String s=null;
		if(i<0 || i>=size) throw new IndexOutOfBoundsException("This is an invalid index");//return null;
		Node<String> p=header;
		for(int j=0;j<i;j++){
			p=p.next;
		}
		
		s=p.next.s;
		p.next=p.next.next;
		size--;
		return s;
		
	}
	
	public int find(String word){
		int counter=-1;
		for(Node<String> p=header.next;p!=null;p=p.next){
			counter++;
			if(p.s.equals(word)){
				return counter;
			}
		}
		return -1;
	}
	
	public String getWordAt(int i){
		if(i<size && i>0){
			Node<String> p=header;
			for(int j=0;j<=i;j++){
				p=p.next;
			}
			return p.s;
		}else{
			//System.out.println("This is an invalid index");
			//return null;
			throw new IndexOutOfBoundsException("This is an invalid index");
		}
	}
	
	public int getSize(){
		return size;
	}
	
	 
	public String toString() {
	        String longString = "";
		if(size==0)
		    longString = "The list is empty";
	        else{
	        Node<String> p=header.next;  
		    longString = new String("");
	            for (; p.next!= null ; p=p.next) {
	                longString =longString +  p.s + "\n";          
	            }//end for
	            longString =longString +  p.s; 
	        }
	        return longString;
	    }
	
	

}
