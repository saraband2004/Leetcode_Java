import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result =new ArrayList<>();
    	
    	Arrays.sort(nums);
    	
    	int FOUR = 4;
    	
    	HashMap<Integer, Integer> map =new HashMap<>();
    	List<Integer> temp = new ArrayList<>();
    	
    	for (int x: nums) {
    		if (map.containsKey(x)) {
    			map.put(x, map.get(x)+1);
    		}
    		else {map.put(x,1);}
    	}
    	
    	
    	NSUM(nums, target, result, FOUR, 0, map, temp);
    	
    	return result;
    }
    
    void NSUM(int [] nums, int target, List<List<Integer>> result, int FOUR, int index, HashMap<Integer, Integer> map, List<Integer> temp) {
    	if (target == 0 && FOUR == 0) {
    		result.add(new ArrayList<>(temp));
    		return;
    	}
    	else if (FOUR == 0) {return;}
    	else if (index == nums.length) {return;}
    	else if (FOUR == 1) {
    		if (map.containsKey(target)) {
    			if (target >= nums[index]) {
    				temp.add(target);
    				result.add(new ArrayList<>(temp));
    				temp.remove(temp.size()-1);
    				return;
    			}
    		}
    		return;
    	}
    	int nextindex = index;
    	while (nextindex < nums.length && nums[nextindex] == nums[index]) {
    		nextindex++;
    	}
    	
    	
    	int stock = map.get(nums[index]);
    	stock = Math.min(stock, FOUR);
    	
    	for (int i = 0; i <= stock; i ++ ) {
    		NSUM(nums, target - i*nums[index], result, FOUR - i, nextindex, map, temp);
    		
    		temp.add(nums[index]);
    	}
    	for (int i = 0; i <= stock; i ++ ) {
    		temp.remove(temp.size()-1);
    	}
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("aaa");
		Solution S = new Solution();
		int [] nums = {1,0,-1,0,-2,2};
		//int [] nums = {1,0,0,0,0,0,0,-1};
		int target = 0;
		System.out.println(S.fourSum(nums, target));
	}

}
