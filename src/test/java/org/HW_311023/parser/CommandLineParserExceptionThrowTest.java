package org.HW_311023.parser;

import org.HW_311023.exception.CommandLineParserException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Ссылка на класс парсера - https://github.com/wtypmah24/Java-Pro_HW2/blob/main/src/main/java/org/HW_311023/parser/CommandLineParser.java
 *
 * Проверяем правильно ли метод parse бросает исключения.
 * 1. Когда аргументов недостаточно.
 * 2. Когда введен неправильный тип данных (не s или i)
 * 3. Когда не введенно ни одного имени входящего файла.
 * --
 * Проверку на обязательное поле имени исходящего файла можно пропустить,
 * потому что оно заполняется до названий входящих файлов.
 * --
 * Проверку выводимого сообщения исключения решил выделить в отдельный метод.
 */

public class CommandLineParserExceptionThrowTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "-a -i", "-a - t -output -input", "-a -i -output.txt"})
    public void checkIfParserThrowException(String args) {
        String[] arguments = args.split(" ");
        assertThrows(CommandLineParserException.class, () -> CommandLineParser.parse(arguments));
    }

    @ParameterizedTest
    @MethodSource("getExceptionThrowableTestData")
    public void checkExceptionMassage(String expected, String args) {
        String[] arguments = args.split(" ");
        CommandLineParserException exception = assertThrows(CommandLineParserException.class, () -> CommandLineParser.parse(arguments));
        assertEquals(expected, exception.getMessage());
    }

    private static Stream<Arguments> getExceptionThrowableTestData() {
        return Stream.of(
                Arguments.of("Not enough arguments", ""),
                Arguments.of("Not enough arguments", "-a -i"),
                Arguments.of("You have to enter a valid data type", "-a - t -output -input"),
                Arguments.of("You have not provided input files", "-a -i -output.txt")
        );
    }
}
