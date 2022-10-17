import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BinarySearchTree implements BinarySearchTreeInterface{

  static class Node {
      public String data;
      public String key;
      public Node left;
      public Node right;

      //constructor
      public Node(String key, String data) {
          this.data = data;
          this.key = key;
          this.left = null;
          this.right = null;
      }
  }

  // instance variable
  public Node root;

  // constructor for initialise the root to null BYDEFAULT
  public BinarySearchTree() {
      this.root = null;
  }
  public void insert(JSONObject newData) {
    this.root = insert(root, newData);
  }

  public Node insert(Node root, JSONObject newData) {
    Iterator<?> keys = newData.keys();
    String currentKey="";
    String currentData="";
    while( keys.hasNext() ) {
        String key = (String) keys.next();
        currentKey = key;
        try{
          currentData = (String)newData.get(key);
        }catch(Exception e){
          System.out.print("k"+e);
        }
    }
    // System.out.println("currentKey: "+currentKey);
      // Base Case: root is null or not
      if (root == null) {
          // Insert the new data, if root is null.
          root = new Node(currentKey,currentData);
          // return the current root to his sub tree
          return root;
      }else {
        int compare = currentKey.compareTo(root.key);  
        // System.out.println(compare);
        // System.out.println("root.key"+root.key);
        // System.out.println("currentKey"+currentKey);
        if (compare < 0) {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, newData);
        } else {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, newData);
        }
      }
      return root;
  }
  public void deleteANode(Node node) {
      deleteNode(this.root, node);
  }

  private Node deleteNode(Node root, Node node) {
      // check for node initially
        int compare = (node.key).compareTo(root.key);  
      if (root == null) {
          return null;
      } else if (compare<0) {
          // process the left sub tree
          root.left = deleteNode(root.left, node);
      } else if (compare>0) {
          // process the right sub tree
          root.right = deleteNode(root.right, node);
      } else if(compare==0){
          // case 3: 2 child
          if (root.left != null && root.right != null) {
              Node nodemax = findMaxData(root.left);
              root.data = nodemax.data;
              root.key = nodemax.key;
              root.left = deleteNode(root.left, new Node(nodemax.key,nodemax.data));
              return root;
          }
          //case 2: one child
          // case i-> has only left child
          else if (root.left != null) {
              return root.left;
          }
          // case ii-> has only right child
          else if (root.right != null) {
              return root.right;
          }
          //case 1:- no child
          else {
              return null;
          }
      }
      return root;
  }
  // inorder successor of given node
  public Node findMaxData(Node root) {
      if (root.right != null) {
          return findMaxData(root.right);
      } else {
          return root;
      }
  }
  public boolean search(String key) {
      return search(this.root, key);
  }

  private boolean search(Node root, String key) {
      if (root == null) {
          return false;
      } else if (((key).compareTo(root.key)) == 0) {
              return true;
      } else if (((key).compareTo(root.key)) < 0) {
        return search(root.left, key);
      }
      return search(root.right, key);
  }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key+ ": " + root.data+ " ");
        preorder(root.left);
        preorder(root.right);

    }
  private final static String JSON_DATA =
     "{" + "  \"dictionary\": [" + "{" + "\"X\": \"x-ray\"}," +"{" + "\"Z\": \"Zebra\"}," +"{" + "\"P\": \"parrot\"}," +"{" + "\"A\": \"apple\"}," + " {" + " \"B\": \"Boy\"}" + "  ," + " {" + " \"C\": \"Cat\"}" + "  ," + " {" + " \"D\": \"Dance\"}" + "  ]" + "}"; 

  public static void main(final String[] argv) throws JSONException {
    BinarySearchTree bst = new BinarySearchTree();
    final JSONObject obj = new JSONObject(JSON_DATA);
    final JSONArray dicData = obj.getJSONArray("dictionary");
    final int n = dicData.length();
    for (int i = 0; i < n; ++i) {
      final JSONObject person = dicData.getJSONObject(i);
    //   System.out.println(person.getInt("id"));
    //   System.out.println(person.getString("name"));
        bst.insert(person);

        // Iterator<?> keys = person.keys();
        // String currentKey;
        // String currentData;
        // while( keys.hasNext() ) {
        //     String key = (String) keys.next();
        //     // currentKey = key;
        //     // currentData = person.get(key);
        //     System.out.println("Key: " + key);
        //     System.out.println("Value: " + person.get(key));
        // }
      // System.out.println(person.keys());
    }
    // System.out.println(dicData);

    System.out.println("\nDictionary Contains the following nodes in BST form:: ");
    bst.preorder();
    System.out.println("\nSearching A in BST:: ");
    System.out.println(bst.search("A"));
    bst.deleteANode(new Node("A","apple"));
    System.out.println("\nAfter Deleting Node A ");
    bst.preorder();
    System.out.println("\nSearching A in BST (After Deletion):: ");
    System.out.println(bst.search("A"));
    // bs.order();
  }
}
