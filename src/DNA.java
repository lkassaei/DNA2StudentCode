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
    public static final int R = 256;
    public static final long p = 54321102419L;

    public static int STRCount(String sequence, String STR) {
        int seqLength = sequence.length();
        int STRLength = STR.length();
        long STRHash = hash(STR, STRLength);

        int num = 0;
        int longest = 0;
        long seqHash = hash(sequence.substring(0, STRLength), STRLength);
        int i = 0;

        while (i <= seqLength - STRLength) {
            if (STRHash == seqHash) {
                i += STRLength;
                num++;

            }
            else {
                longest = Math.max(num, longest);
                num = 0;
                i++;
            }
            if (i < seqLength - STRLength) {
                seqHash = hash(sequence.substring(i, i + STRLength), STRLength);
            }
        }
        return Integer.max(longest, num);
    }

    public static long hash(String str, int length) {
        long h = 0;
        for (int i = 0; i < length; i++) {
            h = (h * R + str.charAt(i)) % p;
        }
        return h;
    }
}
