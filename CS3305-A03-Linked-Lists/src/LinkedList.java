// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: intellij

/*
This class define a linked list that stores integer values.
*/

public class LinkedList
{
   public Node head, tail;

   //constructor method to create a list of object with head, tail, and size. 
   public LinkedList()
   {
      head = null;
      tail = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (tail == null) 
         head = tail = new Node(data); //empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   // This method adds a new node at the beginning of the list.
   // The new node will have the provided data.
   public void addFirstNode(int data)
   {
       Node temp = head;
       head = new Node(data);
       head.next = temp;
   }
      
   //method #2: add node at index
   // This method adds a new node at the specified index in the list.
   // The new node will have the provided data.
   // If the index is 0, it adds the node at the beginning.
   // If the index is the last, it adds the node at the end.
   public void addAtIndex(int index, int data)
   {

      if(index == 0){addFirstNode(data);}
      else if(index == (countNodes()-1)){addLastNode(data);}
      else{
         Node temp = head;
         for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
         }
         Node newNode = new Node(data);
         newNode.next = temp.next;
         temp.next = newNode;
      }
   }
      
   //method #3: remove first node
   // This method removes the first node in the list.
   public void removeFirstNode()
   {
      head = head.next;
   }
      
   //method #4: remove last node
   // This method removes the last node in the list.
   public void removeLastNode()
   {
      Node temp = head;
      while(temp.next.next != null){
         temp = temp.next;
      }
      temp.next = null;
      tail = temp;

   }
    
   //method #5: remove node at index
   // This method removes the node at the specified index in the list.
   // If the index is 0, it removes the first node.
   public void removeAtIndex(int index)
   {
      if (index == 0) {
         removeFirstNode();
         return;
      }
      Node temp = head;
      for(int i=0;i<index-1; i++) {
         temp = temp.next;
      }
      temp.next = temp.next.next;
   }
          
   //method #6: countNodes
   // This method returns the number of nodes in the list.
   public int countNodes()
   {
      int listSize= 0;
      Node temp = head;
      while(temp != null){
         temp = temp.next;
         listSize++;
      }

      return listSize;
         
   }
   
   //method #7: printInReverse  (Recursive method)
   // This method prints the data of the nodes in reverse order recursively
   public void printInReverse(Node L)
   {
      if(L == null){
         return;
      }
      printInReverse(L.next);
      System.out.print(L.data);

   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = head;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}