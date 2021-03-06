package edu.luc.cs271.wordcount;

import java.util.*;

public class Main {

  public static void main(final String[] args) throws InterruptedException {

    // set up the scanner so that it separates words based on space and punctuation
    final Scanner input = new Scanner(System.in).useDelimiter("[^\\p{Alnum}]+");

    // DONE complete this main program
    // 1. create a WordCounter instance
    // 2. use this to count the words in the input
    // 3. determine the size of the resulting map
    // 4. create an ArrayList of that size and
    // 5. store the map's entries in it (these are of type Map.Entry<String, Integer>
    // 6. sort the ArrayList in descending order by count
    //    using Collections.sort and an instance of the provided comparator (after fixing the latter)
    // 7. print the (up to) ten most frequent words in the text
    Map<String, Integer> map = new HashMap<String, Integer>(); // 1
    WordCounter counter = new WordCounter(map);
    
    counter.countWords(input); // 2
    
    int size = counter.getCounts().size(); // 3
    ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(size); // 4
    entryList.addAll(counter.getCounts().entrySet()); // 5
    
    Collections.sort(entryList, new DescendingByCount()); // 6
    
    if (counter.getCounts().size() <= 10) { // 7
      for (int j = 0; j < counter.getCounts().size(); j++) {
        System.out.println(entryList.get(j));
      } 
    } else {
      for (int j = 0; j < 10; j++) {
        System.out.println(entryList.get(j));
      }
    }

  }
}
