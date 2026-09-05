class Solution {

    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for(Interval itr :  intervals){
            start.add(itr.start);
            end.add(itr.end);
        }
        Collections.sort(start);
        Collections.sort(end);

        int sItr = 0, eItr = 0;
        int counter = 0;
        int res = 0;
        while(sItr<intervals.size()){
            while(eItr<intervals.size() && start.get(sItr)>=end.get(eItr)){
                counter--;
                eItr++;
            }
            counter++;
            res = Math.max(counter, res);
            sItr++;
        }
        return res;
    }

}


