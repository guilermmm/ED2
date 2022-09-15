import model.Node;
import model.BinarySearchTree;

public class App {
	public static void main(String[] args) throws Exception {

		// criação dos nós do nível 3
		Node<String> no7 = new Node<>(7, "sete", null, null);
		Node<String> no10 = new Node<>(10, "dez", null, null);
		Node<String> no16 = new Node<>(16, "dezesseis", null, null);

		// criação dos nós do nível 2
		Node<String> no4 = new Node<>(4, "quatro", null, null);
		Node<String> no9 = new Node<>(9, "nove", no7, no10);
		Node<String> no17 = new Node<>(17, "dezessete", no16, null);

		// criação dos nós do nível 1
		Node<String> no6 = new Node<>(6, "seis", no4, no9);
		Node<String> no13 = new Node<>(13, "treze", null, no17);

		// criação do nó do nível 0
		Node<String> no11 = new Node<>(11, "onze", no6, no13);

		BinarySearchTree<String> bt = new BinarySearchTree<>(null);

		
		bt.insert(11, "onze");

	}
}
