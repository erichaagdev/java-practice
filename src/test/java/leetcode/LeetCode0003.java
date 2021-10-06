package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode0003 {

    int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        final var lastSeenMap = new HashMap<>(Map.of(s.charAt(0), 0));
        var lengthOfLongestSubstring = 1;
        var begin = 0;
        for (var pointer = 1; pointer < s.length(); pointer++) {
            final var currentCharacter = s.charAt(pointer);
            final var lastSeen = lastSeenMap.get(currentCharacter);
            if (lastSeen != null && lastSeen >= begin) {
                begin = lastSeen + 1;
            } else {
                lengthOfLongestSubstring = Math.max((pointer - begin) + 1, lengthOfLongestSubstring);
            }
            lastSeenMap.put(currentCharacter, pointer);
        }
        return lengthOfLongestSubstring;
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> test() {
        return Stream.of(
                arguments("dvdf", 3),
                arguments("abcabcbb", 3),
                arguments("abcaccabcbb", 3),
                arguments("bbbbb", 1),
                arguments("pwwkew", 3),
                arguments("aa", 1),
                arguments("abc", 3),
                arguments("ab", 2),
                arguments("a", 1),
                arguments("", 0)
            );
    }

    @ParameterizedTest
    @MethodSource
    void test(String input, int expected) {
        assertEquals(expected, lengthOfLongestSubstring(input));
    }
}
