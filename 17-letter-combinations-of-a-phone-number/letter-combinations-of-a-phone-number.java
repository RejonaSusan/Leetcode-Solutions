class Solution {

    
    public List<String> letterCombinations(String digits) {
        String mpp[] = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return res;
        }
        ans(0, mpp, digits, res, new StringBuilder());
        return res;
    }

    public static void ans(int id, String mpp[], String digits, List<String> res, StringBuilder curr){
        if(id == digits.length()){
            res.add(curr.toString());
            return;
        }

        String letters = mpp[digits.charAt(id) - '0'];
        for(char letter : letters.toCharArray()){
            curr.append(letter);
            ans(id+1, mpp, digits, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    } 
}