import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class repeated_dna_sequence {
    class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int n = s.length();

        for(int i = 0; i < n - 10+1; i++) {
            String curr = s.substring(i, i + 10);
            if(!set.add(curr)) {
                result.add(curr);
            }
        }

        return new ArrayList<>(result);
    }
}
}
