package programs.revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>>  getsubsets(int[] input){
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<Integer>();
        subsetsBacktrack(0, input, subset, subsets);
        System.out.println(subsets.toString());
        return subsets;
    }

    void subsetsBacktrack(int idx, int[] inputs, List<Integer> subset, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(subset));

        for(int i=idx ; i<inputs.length ; i++){
            subset.add(inputs[i]);
            subsetsBacktrack(i+1, inputs, subset, subsets);
            subset.remove(subset.size()-1);
        }
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.run();
    }

    private void run() {
        int[] inputs1 = {1,2,3};
        List<List<Integer>> subsets1 = getsubsets(inputs1);
        List<List<Integer>> expsubsets1 = getExpectedSubsets1(inputs1);
        check(subsets1, expsubsets1);

    }

     void check(List<List<Integer>> subsets1, List<List<Integer>> expsubsets1){
        boolean res = check2(subsets1,  expsubsets1);
        if(res ==true){
            System.out.println('\u2713' + "Test Case Passed ");
        }else{
            System.out.println('\u2717' + "Test Case Failed ");
        }
    }

    boolean check2(List<List<Integer>> subsets1, List<List<Integer>> expsubsets1) {
        for(int i=1;i<subsets1.size();i++){
            for(int j=1;j<subsets1.get(i).size(); j++){
                if(subsets1.get(i).get(j) != expsubsets1.get(i).get(j)){
                    System.out.println("Expected = "+subsets1.get(i).get(j));
                    System.out.println("Actual = "+expsubsets1.get(i).get(j));
                    return false;
                }
            }
        }
        return true;
    }

    private List<List<Integer>> getExpectedSubsets1(int[] inputs1) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i< (1<<inputs1.length) ; i++){
            list.add(new ArrayList<>());
        }
        list.get(0);
        list.get(1).add(inputs1[0]);
        list.get(2).add(inputs1[0]);list.get(2).add(inputs1[1]);
        list.get(3).add(inputs1[0]);list.get(3).add(inputs1[1]);list.get(3).add(inputs1[2]);
        list.get(4).add(inputs1[0]);                            list.get(4).add(inputs1[2]);
        list.get(5).add(inputs1[1]);
        list.get(6).add(inputs1[1]);list.get(6).add(inputs1[2]);
        list.get(7).add(inputs1[2]);
        return list;
    }





}
