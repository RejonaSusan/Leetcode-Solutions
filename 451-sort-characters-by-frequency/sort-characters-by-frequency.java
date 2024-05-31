class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                result.append(key);
            }
        }

        return result.toString();
    }
}