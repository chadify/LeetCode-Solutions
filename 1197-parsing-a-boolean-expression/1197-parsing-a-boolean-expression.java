class Solution {
    private int i = 0;  // Remove static - make it instance variable
    
    public boolean parseBoolExpr(String expression) {
        char c = expression.charAt(i);
        i++;
        if (c == 't')
            return true;
        if (c == 'f')
            return false;
        if (c == '!'){  // Fixed from '|' to '!' for NOT operator
            i++; // skip '('
            boolean res = !parseBoolExpr(expression);
            i++; // skip ')'
            return res;
        }
        
        List<Boolean> children = new ArrayList<>();
        i++; // skip '('
        // collecting all the exps inside '()'
        while (expression.charAt(i) != ')') {
            if (expression.charAt(i) != ',')
                children.add(parseBoolExpr(expression));
            else
                i++;
        }
        i++; // skip ')'
        if (c == '&')
            return andAll(children);
        if (c == '|')
            return orAll(children);
        return false;
    }

    private boolean andAll(List<Boolean> booleans) {  // Made private since it's internal
        for (Boolean b : booleans) {
            if (!b) return false;
        }
        return true;
    }

    private boolean orAll(List<Boolean> booleans) {  // Made private since it's internal
        for (Boolean b : booleans) {
            if (b) return true;
        }
        return false;
    }
}