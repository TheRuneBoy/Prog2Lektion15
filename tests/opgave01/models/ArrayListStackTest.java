package opgave01.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListStackTest {

    StackEaaa<String> testArray;

    @BeforeEach
    void initialize() {testArray = new ArrayListStack<>();}
    @Test
    @DisplayName("Push to an empty stack")
    void pushToEmptyStack() {
        //Arrange
        //Act
        testArray.push("Test");
        //Assert
        assertEquals(1, testArray.size());
        String actual = testArray.pop();
        assertEquals("Test", actual);
        assertEquals(0, testArray.size());
    }

    @Test
    @DisplayName("Push several elements to stack")
    void pushToStack() {
        //Arrange
        //Act
        testArray.push("Test 01");
        testArray.push("Test 02");
        //Assert
        assertEquals(2, testArray.size());
        String actual = testArray.pop();
        assertEquals("Test 02", actual);
    }

    @Test
    @DisplayName("Pop on an empty stack should throw an exception")
    void popEmptyStack() {
        //Arrange
        //Act/Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> testArray.pop());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Peek returns top element")
    void peek() {
        //Arrange
        //Act
        testArray.push("Test 01");
        testArray.push("Test 02");
        //Assert
        String actual = testArray.peek();
        assertEquals("Test 02", actual);
        assertEquals(2, testArray.size());
    }

    @Test
    @DisplayName("Peek on empty Stack")
    void peekEmptyStack() {
        //Arrange
        //Act - Assert
        Exception exception = assertThrows(NoSuchElementException.class, () -> testArray.peek());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void isEmpty() {
        //Arrange
        //Act
        boolean actual = testArray.isEmpty();
        //Assert
        assertTrue(actual);
        testArray.push("Test");
        actual = testArray.isEmpty();
        assertFalse(actual);

    }

    @Test
    void clear() {
        //Arrange
        testArray.push("Test");
        //Act
        testArray.clear();
        //Assert
        assertEquals(0, testArray.size());
        assertThrows(NoSuchElementException.class, () -> testArray.pop());
    }

    @Test
    void size() {
        //Arrange
        //Assert
        assertEquals(0, testArray.size());
        //Act
        testArray.push("Test");
        //Assert
        assertEquals(1, testArray.size());
        //Act
        testArray.pop();
        assertEquals(0, testArray.size());
    }
}
