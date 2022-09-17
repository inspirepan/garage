package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S911 {
    class TopVotedCandidate {
        int[] maxs;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            // times是严格递增的
            int n = times.length;
            this.maxs = new int[n];
            this.times = times;
            int[] votes = new int[5001];
            int currMaxVotes = 0;
            int currMaxPerson = 0;
            for (int i = 0; i < n; i++) {
                if (++votes[persons[i]] >= currMaxVotes) {
                    currMaxVotes = votes[persons[i]];
                    currMaxPerson = persons[i];
                }
                maxs[i] = currMaxPerson;
            }
        }

        public int q(int t) {
            int left = 0;
            int right = times.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (times[mid] == t) {
                    return maxs[mid];
                } else if (times[mid] < t) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return maxs[left - 1];
        }
    }
}
