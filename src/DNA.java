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

        if (!sequence.contains(STR)) {
            return 0;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int STRnum = calculateNumber(STR);

        for (int start = 0; start <  sequenceLength - STRLength; start++) {
            int count = 0;
            boolean reset = false;
            for (int i = start; i < sequenceLength; i+=STRLength) {
                if (!reset && i + STRLength < sequenceLength && calculateNumber(sequence.substring(i, i + STRLength)) == STRnum) {
                    count++;
                }
                else {
                    reset = true;
                }
            }
            arr.add(count);
        }


        int biggest = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > biggest) {
                biggest = arr.get(i);
            }
        }
        return biggest;
    }

    public static int calculateNumber(String str) {
        int count = 0;
        int strlen = str.length();
        for (int i = 0; i < strlen; i++) {
            count += str.charAt(i) * (10^i);
        }
        return count;
    }
}
