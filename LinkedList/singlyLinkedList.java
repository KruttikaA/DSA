import java.util.*;
class Node{
	int data;
	Node next =null;
	Node(int data){
		this.data=data;
	}
}
class LinkedList{
	Node head=null;
	
	void addFirst(int data){
		Node newNode=new Node(data);
		if(head==null)
			head=newNode;
		else
			newNode.next=head;
			head=newNode;
	}
	
	void addLast(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
		}
		else{
			Node temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=newNode;	
		}	
	
	}
	
	void addAtPos(int data,int pos){
		if(pos<1 || pos>(countNode()+1)){
			System.out.println("Not valid Position");
			return;
		}	
		if(pos==(countNode()+1))	
			addLast(data);
		else if(pos==1)
			addFirst(data);
		else{
			Node newNode=new Node(data);
			Node temp=head;
			while(pos-2>0){
				pos--;
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
		}		
			
		
	}
	
	int countNode(){
		int cnt=0;
		Node temp=head;
		while(temp!=null){
			temp=temp.next;
			cnt++;
		}
		return cnt;
	}
	
	void printLinkedList(){
		if (head ==null)
			System.out.println("Linked list is empty !!!");
		else{
			Node temp=head;
			while(temp!=null){
				System.out.print(temp.data+" ");
				temp=temp.next;				
			}
		}	
	}
	
	void deleteFirst(){
		if(head==null){
			System.out.println("Linked list is empty");
			return;
		}
		else
			head=head.next;	
	}
	
	void deleteLast(){
		if(head==null){
			System.out.println("Linked list is empty");
			return;
		}
		else{
			Node temp=head;
			while(temp.next.next!=null){
				temp=temp.next;
			}
			temp.next=null;
		}	
	}
	
	void deleteAtPos(int pos){
		if(pos<1 || pos>(countNode())){
			System.out.println("Not valid Position");
			return;
		}	
		if(pos==(countNode()))	
			deleteLast();
		else if(pos==1)
			deleteFirst();
		else{
			Node temp=head;
			while(pos-2>0){
				pos--;
				temp=temp.next;
			}
			temp.next=temp.next.next;
		}		
			
		
	}	
}
class Client{
	public static void main(String[] args){
		/*LinkedList ll=new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addFirst(30);
		ll.printLinkedList();
		ll.addLast(40);
		ll.printLinkedList();
		System.out.println(ll.countNode());
		ll.addAtPos(1,2);
		System.out.println();
		ll.printLinkedList();
		System.out.println();
		ll.deleteFirst();
		ll.printLinkedList();
		ll.deleteLast();
		ll.printLinkedList();
		ll.deleteAtPos(2);
		ll.printLinkedList();*/
		LinkedList ll=new LinkedList();
		Scanner sc=new Scanner(System.in);
		char ans;
		do{
			System.out.println("1.Add First ");
			System.out.println("2.Add Last ");
			System.out.println("3.Add At Position ");
			System.out.println("4.Delete First ");
			System.out.println("5.Delete Last ");	
			System.out.println("6.Delete At Position ");	
			System.out.println("7.Print Linked List");
																
			System.out.println("Enter your choice :");
			int ch=sc.nextInt();
			
			switch(ch){
				case 1:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					ll.addFirst(data);
					break;
				}
				case 2:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					ll.addLast(data);
					break;
				}	
				case 3:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					ll.addAtPos(data,pos);
					break;
				}	
				case 4:{
					ll.deleteFirst();
					break;
				}
				case 5:{
					ll.deleteLast();
					break;
				}	
				case 6:{
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					ll.deleteAtPos(pos);
					break;
				}	
				case 7:{
					ll.printLinkedList();
					break;
				}	
				
				default:{
					System.out.println("Invalid choice ");
					break;
				}
			}	
						
			System.out.println("Do you want to continue(Y/N) : ");
			ans=sc.next().charAt(0);
												
		}while(ans=='Y' || ans=='y');
	}		
		
}
