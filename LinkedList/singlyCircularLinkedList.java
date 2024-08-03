import java.util.*;

class Node{
	Node next=null;
	int data;
	Node(int data){
		this.data=data;
	}	
}

class SinglyCircularLinkedList{
	Node head=null;
	
	void addFirst(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
			newNode.next=newNode;
		}
		else{
			newNode.next=head;
			//head=newNode;
			Node temp=head;
			while(temp.next!=head)
				temp=temp.next;
			head=newNode;	
			temp.next=head;	
		}
	}
	
	void addLast(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
			newNode.next=newNode;
		}else{
			Node temp=head;
			while(temp.next!=head)
				temp=temp.next;
			temp.next=newNode;
			newNode.next=head;	
		}	
	
	}
	
	void addAtPos(int data,int pos){
		if(pos<1 || pos>countNode()+1){
			System.out.println("Invalid position !");
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
				pos--;
				temp=temp.next;
			}	
			newNode.next=temp.next;
			temp.next=newNode;
		}		
	}
	
	void deleteFirst(){
		if(head==null){
			System.out.println("Linked list is empty !!");
			return;
		}
		if(countNode()==1){
			head=null;
		}
		else{
			Node temp=head;
			while(temp.next!=head){
				temp=temp.next;
			}
			temp.next=head.next;
			head=head.next;
		}
	}
	
	void deleteLast(){
		if(head==null){
			System.out.println("Linked list is empty !!");
			return;
		}
		if(countNode()==1){
			head=null;
		}
		else{
			Node temp=head;
			while(temp.next.next!=head){
				temp=temp.next;
			}
			temp.next.next=null;
			temp.next=head;
		}
	}	
	
	int countNode(){
    		if (head == null) {
        		return 0;
    		}

    		Node temp = head;
   		int cnt = 0;

    		do {
        		cnt++;
        		temp = temp.next;
    		} while (temp != head);

    		return cnt;
	}

	void deleteAtPos(int pos){
		if(pos<1 || pos>countNode()){
			System.out.println("Invalid position !");
			return;
		}
		if(pos==1)
			deleteFirst();
		else if(pos==countNode())
			deleteLast();
		else{
			Node temp=head;
			while(pos-2>0){
				pos--;
				temp=temp.next;
			}	
			temp.next=temp.next.next;
		}		
	}	
	

	
	void printscll(){
		if(head==null){
			System.out.println("Linked list is empty !!");
			return;
		}else{	
		Node temp=head;
		while(temp.next!=head){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.print(temp.data+" ");
	}
	}
}

class Client{
	public static void main(String[] args){
		SinglyCircularLinkedList scll=new SinglyCircularLinkedList();
		boolean continuedo=true;
		Scanner sc=new Scanner(System.in);
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
					scll.addFirst(data);
					break;
				}
				case 2:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					scll.addLast(data);
					break;
				}	
				case 3:{
					System.out.println("Enter data : ");	
					int data=sc.nextInt();
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					scll.addAtPos(data,pos);
					break;
				}	
				case 4:{
					scll.deleteFirst();
					break;
				}
				case 5:{
					scll.deleteLast();
					break;
				}	
				case 6:{
					System.out.println("Enter Position : ");	
					int pos=sc.nextInt();					
					scll.deleteAtPos(pos);
					break;
				}	
				case 7:{
					scll.printscll();
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
