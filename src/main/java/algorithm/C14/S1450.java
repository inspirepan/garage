package algorithm.C14;

public class S1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count=0;
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i]<=queryTime&&endTime[i]>=queryTime){
                count++;
            }
        }
        return count;
    }
}