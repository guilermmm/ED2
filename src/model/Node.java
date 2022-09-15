package model;

public class Node<T> {

  int key;
  T value;
  int nodeHeight;
  Node<T> left, right;

  public Node(int key, T value, Node<T> left, Node<T> right) {
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public Node(int key, T value) {
    this.key = key;
    this.value = value;
  }

  static <T> int height(Node<T> node) {
    return node == null ? -1 : node.nodeHeight;
  }

  static <T> void updateHeight(Node<T> node) {
    if (node != null) {
      node.nodeHeight = Integer.max(height(node.left), height(node.right)) + 1;
    }
  }
}