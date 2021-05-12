package Chpt2.item7;

import java.util.Arrays;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /*     위의 코드에서는 스택에서 빠져나갔다고 생각하는 그 객체가 여전히 소멸되지 않고 남아있다. 즉, stack에서는 사용하지 않는 객체가 비활성 영역에 있을 뿐이다. 그리고 여전히 그 객체를 참조하고 있기 때문에 객체가 소멸되지 않고 남아있다. 의도치 않은 메모리 누수가 발생했다.  */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }
//    수정안
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // 다 쓴 참조 해제
//        return result;
//    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        // occur error
        while(true) System.err.println(stack.pop()); 
    }
}