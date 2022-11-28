package org.example;

import java.util.List;
import java.util.stream.Stream;

public class Task3_49 {
    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        //Stream<String> stream = Stream.of(text.split(" ")).filter(badWords::contains).distinct().sorted();
        return Stream.of(text.split(" ")).filter(badWords::contains).distinct().sorted(); // write your stream here
    }
}
