package algorithm.C3;

public class S307mine {
    class NumArray {

        SegmentTree st;

        public NumArray(int[] nums) {
            st = new SegmentTree(nums);
        }

        public void update(int index, int val) {
            st.change(index, val, 0, 0, st.n - 1);
        }

        public int sumRange(int left, int right) {
            return st.range(left, right, 0, 0, st.n - 1);
        }

        // 第一次自己写出来一个线段树，虽然没有做延迟更新的处理
        static class SegmentTree {

            int[] segment;
            int n;

            SegmentTree(int[] nums) {
                this.n = nums.length;
                segment = new int[nums.length * 2];
                build(0, 0, nums.length - 1, nums);
            }

            void change(int changeIndex, int val, int index, int start, int end) {
                if (start == end) {
                    segment[index] = val;
                    return;
                }
                int mid = start + (end - start >>> 1);
                if (changeIndex <= mid) {
                    change(changeIndex, val, index * 2 + 1, start, mid);
                } else {
                    change(changeIndex, val, index * 2 + 2, mid + 1, end);
                }
                segment[index] = segment[index * 2 + 1] + segment[index * 2 + 2];
            }

            void build(int index, int start, int end, int[] nums) {
                if (start == end) {
                    segment[index] = nums[start];
                    return;
                }
                int mid = start + (end - start >>> 1);
                build(index * 2 + 1, start, mid, nums);
                build(index * 2 + 2, mid + 1, end, nums);
                segment[index] = segment[index * 2 + 1] + segment[index * 2 + 2];
            }

            int range(int left, int right, int index, int start, int end) {
                if (left == start && right == end) {
                    return segment[index];
                }
                int mid = start + (end - start >>> 1);
                if (right <= mid) {
                    return range(left, right, index * 2 + 1, start, mid);
                } else if (left > mid) {
                    return range(left, right, index * 2 + 2, mid + 1, end);
                } else {
                    return range(left, mid, index * 2 + 1, start, mid)
                        + range(mid + 1, right, index * 2 + 2, mid + 1, end);
                }
            }
        }
    }
}
