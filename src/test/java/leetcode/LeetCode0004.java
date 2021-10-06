package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static leetcode.TestingUtility.arrayOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode0004 {

    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            final var half = nums2.length / 2;
            return nums2.length % 2 == 0 ? (nums2[half - 1] + nums2[half]) / 2D : nums2[half];
        } else if (nums2.length == 0) {
            final var half = nums1.length / 2;
            return nums1.length % 2 == 0 ? (nums1[half - 1] + nums1[half]) / 2D : nums1[half];
        }
        final var length = nums1.length + nums2.length;
        final var isEven = length % 2 == 0;
        final var temp = new int[length / 2 + 1];
        var i = 0;
        var j = 0;
        while (i + j < temp.length) {
            if (j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j])) {
                temp[i + j] = nums1[i++];
            } else {
                temp[i + j] = nums2[j++];
            }
        }
        return isEven ? (temp[temp.length - 1] + temp[temp.length - 2]) / 2D : temp[temp.length - 1];
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> test() {
        return Stream.of(
                arguments(arrayOf(1, 3), arrayOf(2), 2),
                arguments(arrayOf(1, 2), arrayOf(3, 4), 2.5),
                arguments(arrayOf(0, 0), arrayOf(0, 0), 0),
                arguments(arrayOf(), arrayOf(1), 1),
                arguments(arrayOf(), arrayOf(2, 3), 2.5),
                arguments(arrayOf(), arrayOf(2, 3, 4, 5), 3.5),
                arguments(arrayOf(2), arrayOf(), 2),
                arguments(arrayOf(0, 0, 0, 0, 0), arrayOf(-1, 0, 0, 0, 0, 0, 1), 0),
                arguments(arrayOf(3), arrayOf(-2, -1), -1),
                arguments(arrayOf(1, 2), arrayOf(4), 2)
            );
    }

    @ParameterizedTest
    @MethodSource
    void test(int[] nums1, int[] nums2, double expected) {
        System.out.printf("%s %s\n", Arrays.toString(nums1), Arrays.toString(nums2));
        assertEquals(expected, findMedianSortedArrays(nums1, nums2));
    }
}
