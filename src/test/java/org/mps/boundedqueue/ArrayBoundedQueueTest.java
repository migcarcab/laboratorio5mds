package org.mps.boundedqueue;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ArrayBoundedQueueTest {
    @Test
    @DisplayName("Constructor con size negativo")
    public void constructor_NegativeSize_Test() {
        // Arrange
        int size = -3;
        // Act && Assert
        assertThatThrownBy(() -> new ArrayBoundedQueue<>(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ArrayBoundedException: capacity must be positive");

    }

    @Test
    @DisplayName("Insertar elementos en la cola")
    void ponerTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(3);
        // Act
        cola.put(1);
        cola.put(2);
        cola.put(3);
        // Assert
        assertThat(cola.size()).isEqualTo(3);
        assertThat(cola.isFull()).isTrue();
    }

    @Test
    @DisplayName("Obtener elementos de la cola")
    void obtenerTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(3);
        cola.put(1);
        cola.put(2);
        // Act
        Integer obtenido = cola.get();
        // Assert
        assertThat(obtenido).isEqualTo(1);
        assertThat(cola.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Comprobar si la cola está llena")
    void llenaTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(2);
        // Act
        cola.put(1);
        cola.put(2);
        // Assert
        assertThat(cola.isFull()).isTrue();
    }

    @Test
    @DisplayName("Comprobar si la cola está vacía")
    void vaciaTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(2);
        // Act & Assert
        assertThat(cola.isEmpty()).isTrue();
        cola.put(1);
        assertThat(cola.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("Comprobar el tamaño de la cola")
    void tamanoTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(3);
        // Act & Assert
        assertThat(cola.size()).isEqualTo(0);
        cola.put(1);
        assertThat(cola.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Lanza excepción al insertar en una cola llena")
    void lanzarExcepcionCuandoLlenaTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(2);
        cola.put(1);
        cola.put(2);
        // Act & Assert
        assertThatThrownBy(() -> cola.put(3))
                .isInstanceOf(FullBoundedQueueException.class)
                .hasMessageContaining("full bounded queue");
    }

    @Test
    @DisplayName("Lanza excepción al intentar insertar un elemento nulo")
    void lanzarExcepcionCuandoNuloTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(2);
        // Act & Assert
        assertThatThrownBy(() -> cola.put(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("element cannot be null");
    }

    @Test
    @DisplayName("Lanza excepción al obtener de una cola vacía")
    void lanzarExcepcionCuandoVaciaTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(2);
        // Act & Assert
        assertThatThrownBy(() -> cola.get())
                .isInstanceOf(EmptyBoundedQueueException.class)
                .hasMessageContaining("empty bounded queue");
    }

    @Test
    @DisplayName("Comprobar el indice del primer elemento")
    void primerElementoIndexTest() {
        // Arrange
        ArrayBoundedQueue<Integer> cola = new ArrayBoundedQueue<>(3);
        cola.put(1);
        cola.put(2);
        // Act
        int primerElemento = cola.getFirst();
        // Assert
        assertThat(primerElemento).isEqualTo(0);
    }

}
