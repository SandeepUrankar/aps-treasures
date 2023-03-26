import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class PascalTriangle {
    public static void main(String[] args) {
        int nRows = 5;
        List<List<Integer>> triangle = generate(nRows);
        System.out.println(triangle);
    }

    static List<List<Integer>> generate(int nRows){
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i+1, 1));
            for (int j = 1; j < i; j++) {
                row.set(j, ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
            }
            ans.add(row);
        }
        return ans;
    }
}
