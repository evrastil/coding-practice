package practice.netsuite;

import org.junit.Test;

import java.util.EmptyStackException;

public class CodingGameTest {
    @Test
    public void testIt(){

    }

    //find mem leak
    class Stack {

        // keep these two fields as they are
        private Object[] elements;
        private int size = 0;

        public Stack(int initialCapacity) {
            elements = new Object[initialCapacity];
        }

        public void push(Object object) {
            ensureCapacity();
            elements[size++] = object;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }

            return elements[--size];
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                Object[] old = elements;
                elements = new Object[2 * size + 1]; // old.length????
                System.arraycopy(old, 0, elements, 0, size);
            }
        }


    }
    
}
