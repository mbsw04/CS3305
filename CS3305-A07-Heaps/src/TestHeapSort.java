// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: intellij


// Class Heap.java
// Textbook - Listing 23.9, Page 878

public class TestHeapSort { 
   /** A test method */
   public static void main(String[] args) {
    
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

      /**/
      System.out.println("Testing Integer:");
      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");
         
      HeapSort.heapSort(list);  //sort the list
      
      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");

      System.out.println();
      System.out.println();
      System.out.println("Testing Characters:");


      Character[] list2 = {'w','f','A','X','T','Q','k','s','8','L','3','b','A','w','s','H','j','K','L'};

      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");

      HeapSort.heapSort(list2);  //sort the list

      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");

      System.out.println();
      System.out.println();
      System.out.println("Testing Strings:");

      String[] list3 = {"Data", "Structure", "Is", "Hard", "Computing", "Class", "To Pass"};

      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");

      HeapSort.heapSort(list3);  //sort the list

      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");
   }
}
