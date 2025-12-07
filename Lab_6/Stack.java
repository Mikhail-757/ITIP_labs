import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] elements;
    private int top;
    
    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        elements = new Object[capacity];
        top = -1;
    }
    
    public void push(T element) {
        if (top == elements.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        elements[++top] = element;
    }
    
    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        T element = (T) elements[top];
        elements[top--] = null; // предотвращаем утечку памяти
        return element;
    }
    
    @SuppressWarnings("unchecked")
    public T peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return (T) elements[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
        // Метод для тестирования стека
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(5);
        
        System.out.println("Добавляем элементы в стек:");
        stack.push("Первый");
        stack.push("Второй");
        stack.push("Третий");
        
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Размер стека: " + stack.size());
        
        System.out.println("Извлекаем элементы:");
        while (!stack.isEmpty()) {
            System.out.println("Извлечен: " + stack.pop());
        }
    }
}