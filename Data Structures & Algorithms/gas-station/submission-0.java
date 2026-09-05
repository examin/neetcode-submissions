class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int start = 0 ;start < gas.length; start++){
            boolean possible = true;
            int fuel = 0;
            for(int itr = start; itr<start+gas.length; itr++){
                int currFuelStation = itr%gas.length;

                int req = cost[currFuelStation];
                fuel   += gas[currFuelStation];

                // System.out.println("For start"+start + " index :"+itr+ " fuel is "+fuel+ " next?req "+req);
                if(fuel<req){
                    possible = false;
                    break;
                }
                fuel -=req;
            }
            if(possible){
                return start;
            }
        }
        return -1;
    }
}

// if total fuel not equal to all required then return -1 initially only. 
// then 
