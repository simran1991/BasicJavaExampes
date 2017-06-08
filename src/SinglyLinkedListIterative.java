/**
 * in this class i will discuss  first iterative way of creating LN
 * 
 * 
 * @author simranjit.singh
 *
 */
public class SinglyLinkedListIterative {
	private Node head;
	private int  count;

	/**
	 * constructer to initialize the empty list
	 */
	public SinglyLinkedListIterative(){
		head=null;
		count=0;
	}
	
	/**
	 * Method to add First element
	 * @param data
	 */
	public void addFirst(Object data) {
		head=new Node(data,head);
		increment();
	}
	
	/**
	 * Method to remove first element
	 * @return
	 */
	public Object removeFirst(){
		Node temp=head;
		head=head.getNext();
		decrement();
		return temp.getData();
	}
	
	/**
	 * Method to get first element
	 * @return
	 */
	public Object getFirst(){
		if(head!=null){
			return head.getData();
		}
		return null;
	}
	
	/**
	 * Mehtod to add at the end of list
	 * @param data
	 */
	public void addLast(Object data){
		Node newNode=new  Node(data);
		if(head!=null){
			Node current=head;
			while(current.getNext()!=null){
				current=current.getNext();
			}
			current.setNext(newNode);
			
		}else {
			head=newNode;
		}
		increment();
	}
	
	/**
	 * Mehtod to remove last element
	 * @return
	 */
	public Object removeLast(){
		if(head!=null){
			Node current=head;
			Node previous=null;
			
			while(current.getNext()!=null){
				previous=current;
				current=current.getNext();
			}
			if(previous==null){
				//exactly one element
				head=null;
			}else{
				previous.setNext(null);
			}
			
			decrement();
			return current.getData();
		}else{
			return null;
		}
		
	}
	
	/**
	 * generic add to add at end
	 * @param data
	 */
	public void add(Object data){
		addLast(data);
	}
	
	/**
	 * generic remove to remove at end
	 * @return
	 */
	public Object remove(){
		return removeLast();
	}
	
	/**
	 * Method to remove element if it exists in list
	 * @param data
	 * @return null if non existent otherwise value of removed element
	 * 
	 */
	public Object remove(Object data){
		Node cuNode=head;
		Node previous=null;
		while(cuNode!=null && !cuNode.getData().equals(data)){
			previous=cuNode;
			cuNode=cuNode.getNext();
		}
		
		if(cuNode!=null){
			//means we have found a match
			if(previous==null){
				//this is first element
				head=cuNode.getNext();
			}else{
				previous.setNext(cuNode.getNext());
			}
			decrement();
			return cuNode.getData();
		}
		return null;
	}
	
	/**
	 * Method to add at specific index of the list
	 * 
	 * @param index
	 * @param value
	 */
	public void add(int index,Object value){
		
		if(index>=0&&index<=size()){
			if(index==size()){
				addLast(value);
			}else if(index==0){
				addFirst(value);
			}else{
				Node previous=null;
				Node current=head;
				Node newNode=new Node(value);
				while(index>0){
					previous=current;
					current=current.getNext();
					index--;
				}
				newNode.setNext(current);
				increment();
				previous.setNext(newNode);
			}
			
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Mehtod to remove at specific index
	 * @param i
	 * @return
	 */
	public Object remove(int i){
		if(i>=0&&i<=size()){
			if(i==size()){
				//remove last
				return removeLast();
			}else if(i==0){
				return removeFirst();
			}else{
				Node previous=null;
				Node current=head;
				while(i>0){
					previous=current;
					current=current.getNext();
					i--;
				}
				previous.setNext(current.getNext());
				decrement();
				return current.getData();
			}
			
		}
		
		return null;
	}
	/**
	 * get size of list
	 * @return
	 */
	public int size(){
		return count;
	}
	

	public void increment(){
		count++;
	}
	
	public void decrement(){
		count--;
	}
	
	/**
	 * Recursive method to get length
	 * @param node
	 * @return
	 */
	public int length(Node node){
		if(node==null){
			return 0;
		}else{
			return 1+length(node.getNext());
		}
	}
	
	public void printRecursive(Node node){
		if(node!=null){
			System.out.println(node.getData()+"\n");
			printRecursive(node.getNext());
		}
	}
	
	public void printReverseRecursive(Node node){
		if(node!=null){
			printReverseRecursive(node.getNext());
			System.out.println(node.getData()+"\n");
		}
	}
	/**
	 * to contruct a new list using reference to odler
	 * @param node
	 * @return
	 */
	public Node construct(Node node){
		if(node==null){
			return null;
		}else{
			node.setNext(construct(node.getNext()));
			return node;
		}
	}
	/**
	 * contruct a copy f existing list
	 * @param node
	 * @return
	 */
	public Node copy(Node node){
		if(node==null){
			return null;
		}else{
			return new Node(node.getData(), copy(node.getNext()));
		}
	}
	/**
	 * Mehtod to print the list
	 * @param head
	 */
	public void traverse(Node head) {
		// traverse using head
		Node current = head;
		while (current.getNext() != null) {
			System.out.println(current.getData().toString());
			current = current.getNext();
		}
		// printing last element
		System.out.println(current.getData().toString());
	}



	public static void main(String[] args) {
		SinglyLinkedListIterative list = new SinglyLinkedListIterative();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(7);
		
		//list.remove((Object)7);
		list.traverse(list.getHead());
		
		System.out.println("size using recursion "+list.length(list.head)+"\n");
		/*list.traverse(list.getHead());
		System.out.println("size of list"+list.size());
		
		list.add(3, 6);
		
		System.out.println("\n");
		list.traverse(list.getHead());
		System.out.println("\n");
		list.traverse(list.getHead());
		list.add(8);
		list.add(9);
		System.out.println("\n");
		list.traverse(list.getHead());
		System.out.println("removing element that is not in list"+list.remove(10)+"\n");
		System.out.println("removing element in list"+list.remove(3)+"\n");
		
		System.out.println("removing first"+list.removeFirst()+"\n");
		list.traverse(list.getHead());
		System.out.println("\n");
		System.out.println("removing last"+list.removeLast()+"\n");
		list.traverse(list.getHead());
		System.out.println("\n");
		
		list.addFirst(100);
		list.traverse(list.getHead());
		System.out.println("\n");
		
		list.addLast(99);
		list.traverse(list.getHead());
		System.out.println("\n");
		
		System.out.println("sizeof list"+list.size());*/

		System.out.println("Printing using recursive");
		list.printRecursive(list.head);
		System.out.println("Printing reverse using recursive");
		list.printReverseRecursive(list.head);
		list.setHead(list.construct(list.head));
		SinglyLinkedListIterative newList=new SinglyLinkedListIterative();
		newList.setHead(list.copy(list.head));
		newList.setCount(list.length(list.head));
		System.out.println("printing new list");
		newList.printRecursive(newList.head);
	}
	

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
