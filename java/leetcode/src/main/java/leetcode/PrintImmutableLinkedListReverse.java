package leetcode;

import java.text.MessageFormat;
import java.util.List;

interface ImmutableListNode<T> {
	public void printValue(); // print the value of this node.

	public ImmutableListNode<T> getNext(); // return the next node.

}

class ImmutableListNodeImpl<T> implements ImmutableListNode<T> {

	private T value;

	private ImmutableListNode<T> nextNode;

	public ImmutableListNodeImpl() {

	}

	public ImmutableListNodeImpl(T value, ImmutableListNodeImpl<T> nextNode) {
		this.value = value;
		this.nextNode = nextNode;
	}

	public ImmutableListNodeImpl(T value) {
		this.value = value;
	}

	public void printValue() {
		System.out.print(MessageFormat.format("[{0}]-->", value));
	}

	public ImmutableListNode<T> getNext() {
		return this.nextNode;
	}

	public void setNext(ImmutableListNode<T> next) {
		this.nextNode = next;
	}

	public static <T> ImmutableListNode<T> createImmutableList(List<T> list) {

		ImmutableListNodeImpl<T> startNode = null;
		ImmutableListNodeImpl<T> lastNode = null;

		for (T node : list) {
			if (startNode == null) {
				startNode = new ImmutableListNodeImpl<T>(node);
				lastNode = startNode;
			} else {
				ImmutableListNodeImpl<T> newNode = new ImmutableListNodeImpl<T>(node);
				lastNode.setNext(newNode);
				lastNode = newNode;
			}
		}
		return startNode;
	}
}

public class PrintImmutableLinkedListReverse {
	public void printLinkedListInReverse(ImmutableListNode<Integer> node) {
		if(node == null) {
			return;
		}
		
		if (null != node.getNext()) {
			printLinkedListInReverse(node.getNext());
		}
		node.printValue();
	}
}
