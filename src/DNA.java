import java.util.ArrayList;

/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: Lily Kassaei
 *</p>
 */

public class DNA {
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int sequenceLength = sequence.length();
        int STRLength = STR.length();

        int index = 0;
        int longest = 0;
        while (index < sequenceLength - STRLength) {
            int num = 0;
            // hash(STR) == hash(sequence.substring(index, STRLength))
            while (STR.equals(sequence.substring(index, index + STRLength))) {
                index += STRLength;
                num++;
            }
            longest = Integer.max(longest, num);
            if (num > 0) {
                index = index - STRLength + 1;
            }
            else {
                index += 1;
            }
        }
        return longest;
    }

    // Questions: Sliding window in STRCount method. How to implement?
    // How to do hash calculation
    // Do we need to store array of hashes of past hashes?
    public static int hash(String str) {
        return -1;
    }
}
