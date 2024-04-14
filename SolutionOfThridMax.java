import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SolutionOfThridMax {
    public int thirdMax(int[] nums) {
        Set set = new HashSet<Integer>();
        for (Integer i : nums) {
            set.add(i);
            if (set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }
        int result;
        if (set.size() <= 3)
            result=Integer.valueOf(Collections.max(set).toString());
        else
            result=Integer.valueOf(Collections.min(set).toString());
        return result;
    }


}

