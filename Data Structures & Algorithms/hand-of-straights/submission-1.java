class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        boolean[] used = new boolean[hand.length];
        Arrays.sort(hand);

        List<List<Integer>> answer = new LinkedList<>();
        int numberOfGroups = hand.length / groupSize;

        for (int i = 0; i < numberOfGroups; i++) {
            int itr = 0;
            int lastVal = -1;
            List<Integer> subAns = new ArrayList<>();

            for (int j = 0; j < groupSize; j++) {
                if (j == 0) {
                    while (itr < hand.length && used[itr]) itr++;
                } else {
                    while (itr < hand.length && (used[itr] || hand[itr] < lastVal + 1)) {
                        itr++;
                    }
                    if (itr == hand.length || hand[itr] != lastVal + 1)
                        return false;
                }
                if (itr == hand.length)
                    return false;

                subAns.add(hand[itr]);
                used[itr] = true;
                lastVal = hand[itr];
            }

            // System.out.println(subAns);
            answer.add(subAns);
        }

        return true;
    }
}