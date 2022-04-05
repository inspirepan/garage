package algorithm.C3;

public class S307 {
    class NumArray {
        private int[] segmentTree;
        private int n;

        public NumArray(int[] nums) {
            n = nums.length;
            segmentTree = new int[nums.length * 4];
            build(0, 0, n - 1, nums);
        }

        public void update(int index, int val) {
            change(index, val, 0, 0, n - 1);
        }

        public int sumRange(int left, int right) {
            return range(left, right, 0, 0, n - 1);
        }

        private void build(int node, int s, int t, int[] nums) {
            if (s == t) {
                segmentTree[node] = nums[s];
                return;
            }
            int mid = s + (t - s) / 2;
            build(node * 2 + 1, s, mid, nums);
            build(node * 2 + 2, mid + 1, t, nums);
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        private void change(int index, int val, int node, int s, int t) {
            if (s == t) {
                segmentTree[node] = val;
                return;
            }
            // 不延迟更新了，直接立即更新
            int mid = s + (t - s) / 2;
            if (index <= mid) {
                change(index, val, node * 2 + 1, s, mid);
            } else {
                change(index, val, node * 2 + 2, mid + 1, t);
            }
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        private int range(int left, int right, int node, int s, int t) {
            if (left == s && right == t) {
                return segmentTree[node];
            }
            int mid = s + (t - s) / 2;
            if (right <= mid) {
                return range(left, right, node * 2 + 1, s, mid);
            } else if (left > mid) {
                return range(left, right, node * 2 + 2, mid + 1, t);
            } else {
                return range(left, mid, node * 2 + 1, s, mid) + range(mid + 1, right, node * 2 + 2, mid + 1, t);
            }
        }
    }
}
