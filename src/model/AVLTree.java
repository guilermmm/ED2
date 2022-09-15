package model;

public class AVLTree<T> {
  Node<T> root;

  public AVLTree() {
    this.root = null;
  }

  public AVLTree(Node<T> root) {
    this.root = root;
  }

  Node<T> insert(Node<T> node, int key, T value) {
    if (node == null) {
      return (new Node<>(key, value));
    }
    if (key < node.key) {
      node.left = insert(node.left, key, value);
    } else if (key > node.key) {
      node.right = insert(node.right, key, value);
    } else {
      return node;
    }

    node.nodeHeight = 1 + Integer.max(node.left.nodeHeight, node.right.nodeHeight);

    int bf = getBF(node);
    int bfLeftNode = getBF(node.left);
    int bfRightNode = getBF(node.right);

    if (bf > 1) {
      if (bfLeftNode < 0)
        node.left = leftRotation(node.left);

      return rightRotation(node);
    }

    if (bf < -1) {
      if (bfRightNode > 0)
        node.right = rightRotation(node.right);

      return leftRotation(node);
    }

    return node;
  }

  int getBF(Node<T> node) {
    if (node == null) {
      return 0;
    }
    return node.left.nodeHeight - node.right.nodeHeight;
  }

  Node<T> rightRotation(Node<T> x) {
    Node<T> y = x.left;
    Node<T> z = y.right;

    y.right = x;
    x.left = z;

    Node.updateHeight(x);
    Node.updateHeight(y);

    return y;
  }

  Node<T> leftRotation(Node<T> x) {
    Node<T> y = x.right;
    Node<T> z = y.left;

    y.left = x;
    x.right = z;

    Node.updateHeight(x);
    Node.updateHeight(y);

    return y;

  }

}
