/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 *
 * Modifications by Michael S. Kirkpatrick, 2019.
 */

/**
 * Binary tree node implementation: supports comparable objects.
 */ 
public class BinarySearchNode<E extends Comparable<? super E>> implements SearchNode<E> {
  private E element;              // Element for this node
  private SearchNode<E> left;     // Pointer to left child
  private SearchNode<E> right;    // Pointer to right child
  private SearchNode<E> parent;   // Pointer to the parent node
  private SearchNode<E> middle;

  // Constructors
  BinarySearchNode() {left = right = null; }
  BinarySearchNode(E val) { left = right = null; element = val; }
  BinarySearchNode(E val, SearchNode<E> l, SearchNode<E> r) {
    left = l; right = r; element = val;
    if (l != null) { l.setParent(this); }
    if (r != null) { r.setParent(this); }
  }

  // Get and set the element value
  public E element() { return element; }
  public void setElement(E v) { element = v; }

  // Get and set the left child
  public SearchNode<E> left() { return left; }
  public void setLeft(SearchNode<E> node) { left = node; }

  // Get and set the middle child
  public SearchNode<E> middle() { return middle; }
  public void setMiddle(SearchNode<E> node) { middle = node; }

  // Get and set the right child
  public SearchNode<E> right() { return right; }
  public void setRight(SearchNode<E> node) { right = node; }

  // Get and set the parent node
  public SearchNode<E> parent() { return parent; }
  public void setParent(SearchNode<E> node) { parent = node; }

  // return TRUE if a leaf node, FALSE otherwise
  public boolean isLeaf() { return (left == null) && (right == null); }

  // Print information about the nodes value, its parent, and its children.
  public String toString() {
    String s = this.element() + " [P: ";
    if (this.parent() == null) { s += "-"; } else { s += this.parent().element(); }
    s += "; L: ";
    if (this.left() == null) { s += "-"; } else { s += this.left().element(); }
    s += "; R: ";
    if (this.right() == null) { s += "-"; } else { s += this.right().element(); }
    return s + "]";
  }
  
  // TODO: IMPLEMENT THE FOLLOWING METHODS BASED ON THE JAVADOC COMMENTS
  
  /**
   * Perform a single rotation to the right of a tree rooted at the current node.
   * Consider the following illustrations (called on the node A):
   *
   *        A       =>     B
   *       / \      =>    / \
   *      B   T3    =>  T1   A
   *     / \        =>      / \
   *   T1   T2      =>    T2   T3
   *
   * Note that A's original parent (if it exists) will need to become B's new
   * parent. We don't know if A is a left or right child of that node, so be
   * sure to handle both cases. If A was the original root of the tree, its
   * parent would be null.
   *
   * @return The new root of this subtree (node B).
   */
  public BinarySearchNode<E> rotateRight() {
    //local variables for nodes that are being moved
    //whatever we rotate around gets promoted to parent spot
    //goes to last leaf of the rotation side and adds to rotated spot
    
    
    // TODO: Implement this method. First, promote the child B as the new
    // parent. Then, attach the subtree T2 to the new child A. Return the
    // new root B. Do not forget to change A's parent (if it exists) to be
    // aware of B as the new root.
    
    //parent is of rotating node
    //this is the node being rotated  
    
    //what node is rotated , how determine parent side tree
    //how to handle subtrees that arent leaves
    //is 'this' the appropiate way to get the node we are rotating

    BinarySearchNode<E> ogParent = new BinarySearchNode<E>();
    BinarySearchNode<E> r = new BinarySearchNode<E>();
    if(this != null) {
    ogParent = (BinarySearchNode<E>) this.parent();
    
    r = (BinarySearchNode<E>) this.left();
    }
    
    if(r.right() != null) {
    this.setLeft(r.right());
    
    r.right().setParent(this);
    
    } else {
      this.setLeft(null);
    }
    
    r.setRight(this);
    
    
    this.setParent(r);
    
    if(ogParent != null) {
    r.setParent(ogParent);
    
    if(ogParent.right() == null) {
      ogParent.setLeft(r);
      } else if(ogParent.left() == null){
        ogParent.setRight(r);
      } else {
      }
    } else {
      r.setParent(null);
    }

    
    return r;
    
    
  }

  /**
   * Perform a single rotation to the left of a tree rooted at the current node.
   * Consider the following illustrations (called on the node A):
   *
   *      A         =>       B
   *     / \        =>      / \
   *   T1   B       =>     A   T3
   *       / \      =>    / \
   *     T2   T3    =>  T1   T2
   *
   * Note that A's original parent (if it exists) will need to become B's new
   * parent. We don't know if A is a left or right child of that node, so be
   * sure to handle both cases. If A was the original root of the tree, its
   * parent would be null.
   *
   * @return The new root of this subtree (node B).
   */
  public BinarySearchNode<E> rotateLeft() {
    // TODO: Implement this method. First, promote the child B as the new
    // parent. Then, attach the subtree T2 to the new child A. Return the
    // new root B. Do not forget to change A's parent (if it exists) to be
    // aware of B as the new root.

    BinarySearchNode<E> ogParent = new BinarySearchNode<E>();
    BinarySearchNode<E> r = new BinarySearchNode<E>();
    if(this != null) {
    ogParent = (BinarySearchNode<E>) this.parent();
    
    r = (BinarySearchNode<E>) this.right();
    }
    
    if(r.left() != null) {
    this.setRight(r.left());
    
    r.left().setParent(this);
    
    } else {
      this.setRight(null);
    }
    
    r.setLeft(this);
    
    
    this.setParent(r);
    
    if(ogParent != null) {
    r.setParent(ogParent);
    
    if(ogParent.right() == null) {
      ogParent.setLeft(r);
      } else if(ogParent.left() == null){
        ogParent.setRight(r);
      } else {
      }
    } else {
      r.setParent(null);
    }

    
    return r;

  }

}
