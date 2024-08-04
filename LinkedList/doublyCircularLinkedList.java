import java.util.*;
class Node{
	Node prev=null;
	Node next=null;
	int data;
	Node(int data){
		this.data=data;
	}
} 

class DoublyCircularLinkedList{
	Node head=null;
	
	void addFirst(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
			head.prev=head;
			head.next=head;
		}else{
			Node tail=head.prev;
			newNode.next=head;
			newNode.prev=tail;
			head=newNode;
			tail.next=head;			
		}
	}
	
	void addLast(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
			head.prev=head;
			head.next=head;
		}else{
			Node tail=head.prev;
			tail.next=newNode;
			newNode.next=head;
			newNode.prev=tail;
			head.prev=newNode;
		}
	}	
	
	void addAtPos(int data,int pos){
		if(pos<1 || pos>countNode()+1){
			System.out.println("Invalid position !! ");
			return;	
		}
		if(pos==1)
			addFirst(data);
		else if(pos==countNode()+1)	
			addLast(data);
		else{
			Node newNode=new Node(data);		
			Node temp=head;
			while(pos-2>0){
				temp=temp.next;
				pos--;
			}
			newNode.next=temp.next;
			newNode.prev=temp;
			temp.next.prev=newNode;
			temp.next=newNode;
			
		}	
	}
	
	void deleteFirst(){
		if(head==null){
			System.out.print("Linked list is empty !!");
			return;
		}
		if(countNode()==1)
			head=null;
		else{
			Node tail=head.prev;
			tail.next=head.next;
			head=head.next;
			head.prev=tail;
		}	
	}
	
	void deleteLast(){
		if(head==null){
			System.out.print("Linked list is empty !!");
			return;
		}
		if(countNode()==1)
			head=null;
		else{
			Node tail=head.prev;
			tail.prev.next=head;
			head.prev=tail.prev;
		}	
	}
	
	void deleteAtPos(int pos){
		if(pos<1 || pos>countNode()){
			System.out.println("Invalid position !! ");
			return;	
		}
		if(pos==1)
			deleteFirst();
		else if(pos==countNode())	
			deleteLast();
		else{
			Node temp=head;
			while(pos-2>0){
				temp=temp.next;
				pos--;
			}
			temp.next.next.prev=temp;
			temp.next=temp.next.next;
			
		}	
	}
		
	int countNode(){
		if(head==null)
			return 0;
		else{	
		int count=0;
		Node temp=head;
		do{
			count++;
			temp=temp.next;
		}while(temp!=head);
		return count;
		}
			
	}
	
	void printdcll(){
		if(head==null){
			System.out.print("Linked list is empty !!");
			return;
		}else{
			Node temp=head;
			do{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}while(temp!=head);
		}	
	}
}

class Client{
	public static void main(String[] args){
		DoublyCircularLinkedList dcll=new DoublyCircularLinkedList();
Scanner sc=new Scanner(System.in);
boolean continuedo=true;
		do{
			System.out.println("1.addFirst");
			System.out.println("2.addLast");
			System.out.println("3.addatPos");
			System.out.println("4.deleteFirst");	
			System.out.println("5.deletelast");
			System.out.println("6.deleteAtPos");
			System.out.println("7.Printscll");	
			System.out.println("8.Exit");	
			
			System.out.println("Enter your choice :");
			int ch=sc.nextInt();
			
			switch(ch){
				case 1:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					dcll.addFirst(data);
					break;
				}
				case 2:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
                                                 dcll.addLast(data);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
					break;
				}	
				case 3:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					dcll.addAtPos(data,pos);
					break;
				}	
				case 4:{
					dcll.deleteFirst();
					break;
				}
				case 5:{
					dcll.deleteLast();
					break;
				}	
				case 6:{
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					dcll.deleteAtPos(pos);
					break;
				}	
				case 7:{
					dcll.printdcll();
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
