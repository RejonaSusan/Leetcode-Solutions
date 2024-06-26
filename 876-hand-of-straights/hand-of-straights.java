class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0){
            return false;
        }
        
        TreeMap<Integer, Integer> tpp = new TreeMap<>();
        for(int n: hand){
            tpp.put(n, tpp.getOrDefault(n,0)+1);
        }

        for(int key: tpp.keySet()){
            int count = tpp.get(key);
            if(count>0){
                for(int i =1 ; i<groupSize ; i++){
                    int next = key + i;
                    if(tpp.getOrDefault(next,0)<count){
                        return false;
                    }
                    tpp.put(next, tpp.get(next) - count);
                }
            }

        }
        return true;
    }
}