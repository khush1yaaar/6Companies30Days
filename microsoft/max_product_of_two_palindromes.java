import java.util.HashSet;

public class max_product_of_two_palindromes {
    class Solution { 
        public int result = 1;
        public boolean isPalindrome(String curr) {
            for(int i = 0; i < curr.length(); i++) {
                if(curr.charAt(i) != curr.charAt(curr.length() - i - 1)) {
                    return false;
                }
            }

            return true;
        }
        public int lps(int idx, String s, HashSet<Integer> set, String curr) {
            if(idx == s.length()) {
                if(isPalindrome(curr)) {
                    return curr.length();
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }

            int pick = Integer.MIN_VALUE;
            if(!set.contains(idx)) {
                pick = lps(idx + 1, s, set, curr + s.charAt(idx));
            }

            int notPick = lps(idx + 1, s, set, curr);

            return Math.max(pick, notPick);
        }
        public void helper(int idx, String s, String curr, HashSet<Integer> set) { 
            if(idx == s.length()) { 
                if(isPalindrome(curr)) { 
                    result = Math.max(result, curr.length() * lps(0, s, set, new String())); 
                } 

                return;
            } 
            set.add(idx);
            helper(idx + 1, s, curr + s.charAt(idx), set);
            set.remove(idx);
            helper(idx + 1, s, curr, set);
        }
        public int maxProduct(String s) {
            helper(0, s, new String(), new HashSet<>());

            return result;
        } 
    } 
}
