package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();

		if (element != null) {
			try {
				stack1.push(element);
			} catch (StackOverflowException e) {
				throw new QueueOverflowException();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();

		T elem = null;

		if (stack2.isEmpty()) {
			Trocar(stack1, stack2); // inverte a ordem dos elementos

			try {
				elem = stack2.pop(); // remove o elemento mais antigo
			} catch (StackUnderflowException e) {
				throw new QueueUnderflowException();
			}

			Trocar(stack2, stack1); // copia de volta para a pilha original
		}

		return elem;
	}

	@Override
	public T head() {
		T elem = null;

		if (stack2.isEmpty()) {
			Trocar(stack1, stack2);
			elem = stack2.top();
			Trocar(stack2, stack1);
		}

		return elem;
	}

	@Override
	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

	public void Trocar(Stack<T> st1, Stack<T> st2) {
		while (!st1.isEmpty())
			try {
				st2.push(st1.top());
				st1.pop();
			} catch (StackOverflowException | StackUnderflowException e) {
				break;
			}
	}

}
