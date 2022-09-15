package model;

public class BinarySearchTree<T> {

  Node<T> root = null;

  public BinarySearchTree(Node<T> r) {
    root = r;
  }

  public static <T> Node<T> insert(Node<T> node, int key, T value) {
    if (node == null) {
      node = new Node<T>(key, value, null, null);
    } else if (key < node.key) {
      node.left = insert(node.left, key, value);
    } else if (key > node.key) {
      node.right = insert(node.right, key, value);
    }

    return node;
  }

  public void insert(int key, T value) {
    this.root = insert(this.root, key, value);
  }

  public static <T> Node<T> remove(Node<T> node, int key) {
    if (node == null)
      return null;
    else if (key < node.key)
      node.left = remove(node.left, key);
    else if (key > node.key)
      node.right = remove(node.right, key);
    else {
      if (node.left == null && node.right == null)
        node = null;
      else if (node.right == null)
        node = node.left;
      else if (node.left == null)
        node = node.right;
      else {
        Node<T> left = node.left;
        while (left.right != null) {
          left = left.right;
        }

        Node<T> right = node.right;
        while (right.left != null) {
          right = right.left;
        }

        if (node.key - left.key <= right.key - node.key) {
          node.key = left.key;
          left.key = key;
          node.left = remove(node.left, key);
        } else {
          node.key = right.key;
          right.key = key;
          node.right = remove(node.right, key);
        }
      }
    }
    return node;
  }

  public static <T> Node<T> search(Node<T> node, int key, T value) {
    if (node == null) {
      return null;
    } else if (key < node.key) {
      return search(node.left, key, value);
    } else if (key > node.key) {
      return search(node.right, key, value);
    } else {
      return node;
    }
  }

  public Node<T> search(int key, T value) {
    return search(this.root, key, value);
  }
}