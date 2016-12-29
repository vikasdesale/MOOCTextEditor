package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		 if (element == null) {
	            throw new NullPointerException("Null element");
	        }
	        LLNode<E> newNode = new LLNode<E>(element);
	        newNode.prev = tail.prev;
	        tail.prev.next = newNode;
	        newNode.next = tail;
	        tail.prev = newNode;
	        size += 1;
			return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Check index!");

		return getN(index).data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		 if(index > size || index < 0){
	            throw new IndexOutOfBoundsException("Invalid index");
	        }
	        if (element == null) {
	            throw new NullPointerException("Null element");
	        }
	        LLNode<E> node = head;
	        while (index>0){
	            node = node.next;
	            index -= 1;
	        }
	        LLNode<E> newNode = new LLNode<E>(element);
	        newNode.prev = node;
	        newNode.next = node.next;
	        node.next.prev = newNode;
	        node.next = newNode;
	        size += 1;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Check index!");

		LLNode<E> del = getN(index);
		del.prev.next = del.next;
		del.next.prev = del.prev;
		del.prev = null;
		del.next = null;
		size--;
		return del.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Check index!");

		if (element == null)
			throw new NullPointerException("Element cannot be null!");

		LLNode<E> delNode = getN(index);
		E del = delNode.data;
		delNode.data = element;
		return del;
	}   
	private LLNode<E> getN(int index) {
		LLNode<E> currentNode = head;

		for (int i = -1; i < index; i++)
			currentNode = currentNode.next;

		return currentNode;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
