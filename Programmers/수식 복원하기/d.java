import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        
        List<Integer> candidateBases = new ArrayList<>();
        
        for (int base = 2; base <= 9; base++) {
            boolean valid = true;
            
            for (String expr : expressions) {
                String[] parts = expr.split(" ");
                String num1 = parts[0], op = parts[1], num2 = parts[2], result = parts[4];

                if (!isValid(num1, base) || !isValid(num2, base)) {
                    valid = false;
                    break;
                }

                if (!result.equals("X")) {

                    if (!isValid(result, base)) {
                        valid = false;
                        break;
                    }

                    long n1 = toDecimal(num1, base);
                    long n2 = toDecimal(num2, base);
                    long res = toDecimal(result, base);
                    long calc = op.equals("+") ? n1 + n2 : n1 - n2;

                    if (calc != res) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                candidateBases.add(base);
            }

        }
        
        List<String> answerList = new ArrayList<>();

        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            String num1 = parts[0], op = parts[1], num2 = parts[2], result = parts[4];

            if (result.equals("X")) {
                Set<String> possibleResults = new HashSet<>();
                for (int base : candidateBases) {                    
                    long n1 = toDecimal(num1, base);
                    long n2 = toDecimal(num2, base);
                    long calc = op.equals("+") ? n1 + n2 : n1 - n2;
                    String calcStr = fromDecimal(calc, base);

                    possibleResults.add(calcStr);
                }

                String fill;
                if (possibleResults.size() == 1) {
                    fill = possibleResults.iterator().next();
                } else {
                    fill = "?";
                }
                answerList.add(num1 + " " + op + " " + num2 + " = " + fill);
            }
        }
        return answerList.toArray(new String[0]);
    }
    
    private boolean isValid(String s, int base) {
        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            if (digit < 0 || digit >= base) return false;
        }
        return true;
    }
    
    private long toDecimal(String s, int base) {
        long num = 0;
        for (char ch : s.toCharArray()) {
            num = num * base + (ch - '0');
        }
        return num;
    }
    
    private String fromDecimal(long num, int base) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            long digit = num % base;
            sb.append((char)('0' + digit));
            num /= base;
        }
        return sb.reverse().toString();
    }
}
