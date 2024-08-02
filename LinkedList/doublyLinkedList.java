import java.util.*;
class Node{
	int data;
	Node prev=null;
	Node next=null;
	Node(int data){
		this.data=data;
	}
}
class DoublyLinkedList{
	Node head=null;
	void addFirst(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
		}
		else{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
		
	}
	
	void addLast(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
		}else{
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			newNode.prev=temp;
			temp.next=newNode;
		}		
			
	}
	
	void addAtPos(int data,int pos){
		if((pos<1)||(pos>countNode()+1)){
			System.out.println("Invalid Position ");
			return;
		}
		if (pos==1){
			addFirst(data);
		}else if(pos==countNode()+1){
			addLast(data);
		}else{
			Node newNode=new Node(data);
			Node temp=head;
			while(pos-2!=0){
				pos--;
				temp=temp.next;
			}		
			newNode.next=temp.next;
			newNode.prev=temp;
			temp.next=newNode;
			
		}
	}
	
	void deleteFirst(){
		if (head==null){
			System.out.println("Linked list is empty !!!");
			return;
		}
		if(countNode()==1){
			head=head.next;
		}
		else{
			head.next.prev=null;
			head=head.next;
		}
	}
	
	void deleteLast(){
		if (head==null){
			System.out.println("Linked list is empty !!!");
			return;
		}
		if(countNode()==1){
			head=head.next;
		}
		else{
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.prev.next=null;
			//temp.prev=null; optional
		}		
	}
	
	void deleteAtPos(int pos){
		if(pos<1 || pos>countNode()){
			System.out.println("Invalid Position");
			return;
		}
		if(pos==1)
			deleteFirst();
		else if(pos==countNode())
			deleteLast();
		else{
			Node temp=head;
			while(pos-2!=0){
				temp=temp.next;
				pos--;
			}
			temp.next.next.prev=temp;
			temp.next=temp.next.next;
			
			
		}		
	
	}
	
	int countNode(){
		int cnt=0;
		Node temp=head;
		while(temp!=null){
			cnt++;
			temp=temp.next;
		}
		return cnt;
	}
	
	void printDLL(){
		if(head==null){
			System.out.println("Linked list is empty !!!");
			return;
		}
		else{
			Node temp=head;
			while(temp!=null){
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
			
	}
}
class Client{
	public static void main(String[] args){
		DoublyLinkedList dll=new DoublyLinkedList();
		boolean continuedo=true;
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("1.addFirst");
			System.out.println("2.addLast");
			System.out.println("3.addatPos");
			System.out.println("4.deleteFirst");	
			System.out.println("5.deletelast");
			System.out.println("6.deleteAtPos");
			System.out.println("7.Printdll");	
			System.out.println("8.Exit");	
			
			System.out.println("Enter your choice :");
			int ch=sc.nextInt();
			
			switch(ch){
				case 1:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					dll.addFirst(data);
					break;
				}
				case 2:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					dll.addLast(data);
					break;
				}	
				case 3:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					dll.addAtPos(data,pos);
					break;
				}	
				case 4:{
					dll.deleteFirst();
					break;
				}
				case 5:{
					dll.deleteLast();
					break;
				}	
				case 6:{
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					dll.deleteAtPos(pos);
					break;
				}	
				case 7:{
					dll.printDLL();
					break;
				}
				
				case 8:{
					continuedo=false;
					break;
				}	
									
				
				default:{
					System.out.println("Invalid choice ");
					break;
				}
			}	
				
		}while(continuedo==true);	
	}
}
