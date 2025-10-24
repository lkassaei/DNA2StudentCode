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
    // Declare constants for numbers in Horner's method
    public static final int R = 256;
    public static final long p = 54321102419L;

    // Count largest consecutive appearances of STR in sequence
    public static int STRCount(String sequence, String STR) {
        // Calculate lengths and hash of STR so no need to recalculate later
        int seqLength = sequence.length();
        int STRLength = STR.length();
        long STRHash = hash(STR, STRLength);

        // Declare variables used to count current consecutive appearances of STR in sequence and longest
        int currentCount = 0;
        int longestCount = 0;

        // Get the hash of the first chunk in sequence and create index variable that keeps track of position in sequence
        long currentHash = hash(sequence.substring(0, STRLength), STRLength);
        int i = 0;

        // While are still within the sequence
        while (i < seqLength) {
            // If we find a match
            if (STRHash == currentHash) {
                // Move our index to the next chunk
                i += STRLength;
                // Increase the current consecutive count
                currentCount++;
            }
            // If we did not find a match
            else {
                // Find the longest consecutive could
                longestCount = Math.max(currentCount, longestCount);
                // Reset current consecutive count
                currentCount = 0;
                // Only move forward by one place
                i++;
            }
            // If we still have space to find a new occurrence of STR
            if (i < seqLength - STRLength) {
                // Reset current hash to the chunk of sequence we are at
                currentHash = hash(sequence.substring(i, i + STRLength), STRLength);
            }
        }
        // Return the largest consecutive count of STR
        return Integer.max(longestCount, currentCount);
    }

    // Implement Horner's method to create unique integer values for each String passed through
    public static long hash(String str, int length) {
        long h = 0;
        // Multiply each number by all possible outcomes (256 for extended ASCII) and mod by large prime unique hashes
        for (int i = 0; i < length; i++) {
            h = (h * R + str.charAt(i)) % p;
        }
        // Return computed hash
        return h;
    }
}
