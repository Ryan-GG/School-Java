/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 */

/*
 * @author Ryan Gross, Seth Walter
 */
// Unfinished Binary Search Tree implementation
class BST<E extends Comparable<E>> {
  protected BSTNode<E> root; // Root of the BST
  protected int nodecount; // Number of nodes in the BST

  // constructor
  BST() {
    root = null;
    nodecount = 0;
  }

  // Reinitialize tree
  public void clear() {
    root = null;
    nodecount = 0;
  }

  // Insert a record into the tree.
  // Records can be anything, but they must be Comparable
  // e: The record to insert.
  public void insert(E e) {
    root = inserthelp(root, e);
    nodecount++;
  }

  private BSTNode<E> inserthelp(BSTNode<E> rt, E e) {
    if (rt == null)
      return new BSTNode<E>(e);
    if (rt.element().compareTo(e) >= 0)
      rt.setLeft(inserthelp(rt.left(), e));
    else
      rt.setRight(inserthelp(rt.right(), e));
    return rt;

  }


  // Return the record with key value k, null if none exists
  // key: The key value to find
  public E find(E key) {
    return findhelp(root, key);
  }

  private E findhelp(BSTNode<E> rt, E key) {
    if (rt == null)
      return null;
    if (rt.element().compareTo(key) > 0)
      return findhelp(rt.left(), key);
    if (rt.element().compareTo(key) == 0)
      return rt.element();
    else
      return findhelp(rt.right(), key);

  }

  // Return the number of records in the dictionary
  public int size() {
    return nodecount;
  }


  // UNFINISHED METHODS BELOW THIS POINT**************************

  /**
   * Recursively calculate the number of nodes in this BST.
   */
  public int recursiveSize() {

     
    return findSize(root);
  }
  
  
  
  
  public int findSize(BSTNode<E> root ) {
    
    if(root == null) {
      return 0;
    }  
    else {
      return 1 + findSize(root.left()) + findSize(root.right());
    }
   
  }

  /**
   * Return the smallest element in the tree.
   */
  public E minElement() {
    
    
    return minTraverse(root);
  }
  
  
  public E minTraverse(BSTNode<E> rt) {
    if(rt.left() == null) {
      return rt.element();
    } else {
      if(rt.isLeaf()) {
        return rt.element();
      } else {
        return minTraverse(rt.left());
      }
    }
    
  }
  
  
  public E maxTraverse(BSTNode<E> rt) {
    if(rt.right() == null) {
      return rt.element();
    } else {
      if(rt.isLeaf()) {
        return rt.element();
      } else {
        return maxTraverse(rt.right());
      }
    }
    
  }


  /**
   * Return the largest element in the tree.
   */
  public E maxElement() {
    return maxTraverse(root);
  }

  /**
   * Return an ordered linked list containing all of the elements from the tree.
   */
  public LList<E> makeOrderedList() {
      // Suggested approach:  Create an empty list here, and let it
      // be populated inside a recursive traversal method.
    LList<E> holder = new LList<E>();
    recursiveOrdering(holder,root);
    return holder;
  }
  
  
  public void recursiveOrdering(LList<E> list, BSTNode<E> rt) {
    if(rt == null) return;
    recursiveOrdering(list,rt.left());
    list.append(rt.element());
    recursiveOrdering(list,rt.right());
  }

  /**
   * Return true if this BST actually has the BST property and false if it does
   * not.
   * 
   * (Note that this method would typically not be necessary. It a correctly
   * coded BST there will be no possibility of violating the BST property.)
   * 
   */
  public boolean isValidBST() {
    if(recursiveSize() == 0) return true;

    return checkValues(root);
  }
  
  public boolean checkValues(BSTNode<E> rt) {
    if (rt == null) return true;

    if(rt.left() != null && maxTraverse(rt.left()).compareTo(rt.element()) > 0 ) {
      return false;
    }
    
    
    if(rt.right() != null && minTraverse(rt.right()).compareTo(rt.element()) < 0) {
      return false;
    }
    
    if(!checkValues(rt.left()) || !checkValues(rt.right())) {
      return false;
    }
    
    return true;
  }
  
  
 



}

