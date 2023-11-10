package org.HW_311023.parser;

import org.HW_311023.exception.CommandLineParserException;
import org.HW_311023.sorting.setting.SortingSetting;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Ссылка на класс парсера - https://github.com/wtypmah24/Java-Pro_HW2/blob/main/src/main/java/org/HW_311023/parser/CommandLineParser.java
 *
 * Проверяем положительные варианты:
 * 1. Режим сортировки по возрастанию отключён (первый аргумент -d), тип данных s
 * 2. Режим сортировки по возрастанию указан -a, тип данных -i
 * 3. Режим сортировки не указан, по умолчанию сортировка по возрастанию.
 * 4. Имена входящих и исходящих файлов на сортировку не влияют и могут оставаться одинаковыми.
 */
class CommandLineParserPositiveTest {

    @ParameterizedTest
    @MethodSource("getPositiveTestData")
    public void checkCorrectWorkParser(String[] args, SortingSetting expected) throws CommandLineParserException {
        SortingSetting actual = CommandLineParser.parse(args);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getPositiveTestData() {
        return Stream.of(
                //1 вариант
                Arguments.of(new String[]{"-d", "-s", "out.txt", "in.txt", "in2.txt"},
                        new SortingSetting(false,
                                "-s",
                                "out.txt",
                                List.of("in.txt", "in2.txt"))),
                //2 вариант
                Arguments.of(new String[]{"-a", "-i", "out.txt", "in.txt", "in2.txt", "in3.txt"},
                        new SortingSetting(true,
                                "-i",
                                "out.txt",
                                List.of("in.txt", "in2.txt", "in3.txt"))),
                //3 вариант
                Arguments.of(new String[]{"-i", "out.txt", "in.txt", "in2.txt", "in3.txt"},
                        new SortingSetting(true,
                                "-i",
                                "out.txt",
                                List.of("in.txt", "in2.txt", "in3.txt")))
        );
    }
}