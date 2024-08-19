class Solution {
    public boolean parseBoolExpr(String expression) {

        int e = expression.length();

        return ans(expression, 0, e-1);
    }

    public boolean ans(String exp, int s, int e){
        if(s == e){
            return exp.charAt(s) == 't';
        }

        List<Boolean> mpp = new ArrayList<>();

        int layer = 0;
        int left = 0;
        char op = ' ';

        for(int i = s; i<=e; i++){
            char c = exp.charAt(i);
            if(layer == 0 && (c == '!' || c == '&' || c == '|')){
                op = c;
            }
            else if(c == '(' && ++layer == 1){
                left = i+1;
            }
            else if(c == ')' && --layer == 0){
                mpp.add(ans(exp, left, i-1));
            }
            else if(c == ',' && layer == 1){
                mpp.add(ans(exp, left, i-1));
                left = i+1;
            }
        }

        if(op == '&'){
            boolean res = true;
            for(boolean b: mpp){
                res &= b;
            }
            return res;
        }

        if(op == '|'){
            boolean res = false;
            for(boolean b: mpp){
                res |= b;
            }
            return res;
        }

        return !mpp.get(0);
    }
}