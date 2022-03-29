public class TreeRunner {

  public static void main(String args[]) {
    
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(5);
    bst.insert(3);
    bst.insert(1);
    bst.insert(2);
    System.out.println("Generic BST:");
    System.out.println(bst);
    // Tree should look like:
    //      5
    //     /
    //    3
    //   /
    //  1
    //   \
    //    2

    AVLTree<Integer> avl = new AVLTree<>();
    avl.insert(5);
    avl.insert(3);
    avl.insert(1);
    avl.insert(2);
    System.out.println("\nAVL tree:");
    System.out.println(avl);
    // Tree should look like:
    //       3
    //     /   \
    //    1     5
    //     \
    //      2
  }
}
