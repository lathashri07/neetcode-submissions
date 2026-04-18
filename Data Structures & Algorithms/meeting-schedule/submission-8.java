/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1) return true;
        int s1 = intervals.get(0).start;
        int e1 = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
            if(s1 < intervals.get(i).end && intervals.get(i).start < e1) return false;
            s1 = intervals.get(i).start;
            e1 = intervals.get(i).end;
        }
        return true;
    }
}
