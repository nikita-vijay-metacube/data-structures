import java.util.*;
public class UniqueCharacters{
     static void getCount(String [] words)
    {
 
        // Use LinkedHashmap to store
        // elements in insertion order
        Map<String, Integer> mp
            = new LinkedHashMap<String, Integer>();
 
        for (int i = 0; i < words.length; i++) {
            int count = words[i].length();
            mp.put(words[i], count);
        }
        System.out.println("\nTotal occurance:");
        for (Map.Entry<String, Integer>
                 entry : mp.entrySet()){
            System.out.println(entry.getKey()
                               + " "
                               + entry.getValue());
                               
        }
        mp.clear();

    }
    // Driver code
    public static void main(String[] args)
    {
        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = str.split(" ");
        getCount(words);
    }
}