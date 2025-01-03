import java.util.HashMap;

public class bulls_and_cows {
    class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        HashMap<Character, Integer> set = new HashMap<>();
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            if(set.containsKey(secret.charAt(i))) {
                set.put(secret.charAt(i), set.get(secret.charAt(i)) + 1);
            }
            else {
                set.put(secret.charAt(i), 1);
            }

        }

        for(int i = 0; i < guess.length(); i++) {
            if(set.containsKey(guess.charAt(i))) {
                cows++;
                if(set.get(guess.charAt(i)) > 1) {
                    set.put(guess.charAt(i), set.get(guess.charAt(i)) - 1);
                }
                else {
                    set.remove(guess.charAt(i));
                }
            }
        }

        cows -= bulls;

        String result = bulls + "A" + cows + "B";

        return result;
    }
}
}
