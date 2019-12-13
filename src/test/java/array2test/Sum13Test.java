import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Sum13Test {

    @ParameterizedTest
    @DisplayName("Testing method sum13 from class Array2")
    @MethodSource("generateData4")
    void mustReturnSumOfElementsInArrayExceptThirteen(int[] given, int expected) {
        int actual = new Sum13().sum13(given);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> generateData4() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{13}, 0),
                Arguments.of(new int[]{1, 13}, 1),
                Arguments.of(new int[]{1, 5, 1, 13, 5}, 7),
                Arguments.of(new int[]{1, 5, 1, 13, 5, 5}, 12)
        );
    }

    @Test
    void mustHandleWithNull() {
        assertThrows(NullPointerException.class, () -> {
            new Sum13().sum13(null);
        });
    }
}