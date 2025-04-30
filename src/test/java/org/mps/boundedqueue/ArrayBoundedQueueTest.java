package org.mps.boundedqueue;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ArrayBoundedQueueTest {
    @Test
    @DisplayName("Test putting elements into the queue")
    void testPut() {
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(3);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        assertThat(queue.size()).isEqualTo(3);
        assertThat(queue.isFull()).isTrue();
    }

    @Test
    @DisplayName("Test getting elements from the queue")
    void testGet() {
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(3);
        queue.put(1);
        queue.put(2);
        assertThat(queue.get()).isEqualTo(1);
        assertThat(queue.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test if the queue is full")
    void testIsFull() {
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        queue.put(1);
        queue.put(2);
        assertThat(queue.isFull()).isTrue();
    }

    @Test
    @DisplayName("Test if the queue is empty")
    void testIsEmpty() {
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        assertThat(queue.isEmpty()).isTrue();
        queue.put(1);
        assertThat(queue.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("Test the size of the queue")
    void testSize() {
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(3);
        assertThat(queue.size()).isEqualTo(0);
        queue.put(1);
        assertThat(queue.size()).isEqualTo(1);
    }
}
