package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T retorno = null;
		if (!isEmpty()) {
			retorno = array[0];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		if (this.tail == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (this.tail == array.length-1) {
			return true;
		}
		return false;
	}
	
	private void shiftLeft() {
		for (int i = 0; i < tail; i++) {
			array[i] = array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (element != null) {
			tail++;
			array[tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T elemento = this.array[0];
		shiftLeft();
		tail--;
		return elemento;
	}

}
