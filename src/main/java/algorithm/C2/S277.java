package algorithm.C2;

public class S277 {
    // 不想做了
    public int findCelebrity(int n) {
        // n个人，找到其中一个人，其他人都认识他，然后他不认识其他所有人
        // 其实不做任何优化的话，我只要每个人都问一遍其他人就可以了，最多O(n^2)嘛

        // 入度
        int[] indegree = new int[n];
        // 如果一个人它知道另一个人，那他肯定不是名人
        // 排除做b
        return 0;
        //
    }

    boolean knows(int a, int b) {
        return false;
    }
}
