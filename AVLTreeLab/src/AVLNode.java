/**
 * Class for implementing the re-balancing algorithm of a self-balancing AVL
 * binary search tree.
 * 
 * @author Michael S. Kirkpatrick and ???
 * @version Fall 2019
 */
public class AVLNode<E extends Comparable<? super E>> extends BinarySearchNode<E> {

  private int height;

  AVLNode() { super(); height = 0; }
  AVLNode(E val) { super(val); height = 0; }
  AVLNode(E val, AVLNode<E> l, AVLNode<E> r) {
    super(val, l, r);
    updateHeight();
  }

  /**
   * Getter for the balance factor, which is dynamically computed as the left
   * height minus the right height.
   *
   * @return The computed balance factor.
   */
  public int balance() {
    int lh = nodeHeight((AVLNode<E>)left());
    int rh = nodeHeight((AVLNode<E>)right());
    return lh - rh;
  }

  /**
   * Getter for the height.
   *
   * @return The height of the tree rooted at this node.
   */
  public int height() {
    return height;
  }

  /**
   * Rebalances an AVL tree after a node insertion.
   *
   * @return The new root of the rebalanced tree.
   */
  public AVLNode<E> rebalance() {
    // TODO: Complete this method AFTER implementing the BinarySearchNode
    // rotation methods.
 
    // Update current node's height, then return if this node is the root

    // Assuming the current node is not the root, rotate it to either the
    // left or the right based on the PARENT NODE's balance factor. If the
    // parent's balance factor is 2 or -2, there are four cases (this node
    // is B, the parent is A, R(*) means rotate that node right, L(*) means
    // rotate that node left):
    //
    //     A 2      A 2       A -2          A -2
    //    /        /           \             \
    //   B 1      B -1          B 1           B -1
    // 
    //    R(A)    L(B),R(A)    R(B),L(A)    L(A)
    //
    // After rotating, update all affected nodes' heights. That includes the
    // old parent and this node's left and right children (which may be the
    // old parent).

    // Finally, update the current node's height and recursively rebalance
    // this node's new parent.

    
    //updateHeight();
    /*
    if(this.parent() == null) return this;
    int balance = ((AVLNode<E>) this.parent()).balance();
    
    if(balance == 2 && this.balance() == 1) {
      ((BinarySearchNode<E>) this.parent()).rotateRight();
    }
   */
    updateHeight();
    if(this.parent() == null) return this;
    int balance = ((AVLNode<E>) this.parent()).balance();

    
    return ((AVLNode<E>) this.parent()).rebalance();
  }


  /**
   * Helper method to update the current node's height when rotations occur.
   */
  private void updateHeight() {
    int lh = nodeHeight((AVLNode<E>)left());
    int rh = nodeHeight((AVLNode<E>)right());
    height = Math.max(lh, rh) + 1;
  }

  /**
   * Helper to eliminate the issue of null nodes.
   *
   * @return -1 if the node is null, otherwise the node height.
   */
  private int nodeHeight(AVLNode<E> node) {
    if (node == null) {
      return -1;
    } else {
      return node.height();
    }
  }

  /**
   * Create a string format for debugging. The element is shown first, then
   * additional data about the node in brackets. The data shown is (in order)
   * the height of the tree rooted at this node, the balance factor of the
   * node, its parent node value, its left and right node values.
   *
   * @return A string representation of the node.
   */
  public String toString() {
    return super.toString() + " [HT: " + this.height() + "; BF: " + this.balance() + "]";
  }

}
