/* You are a professional robber planning to rob houses along a street... Each house has a certain amount of money stashed... All houses at this place are arranged in a circle... That means the first house is the neighbor of the last one... Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night... Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police...
 * Eg 1: nums = [2,3,2]     Output = 3
 * Explanation of above case -> {Since House 1 and House3 are adjacent we can only rob house 2}
 * Eg 2: nums = [1,2,3,1]   Output = 4
 * Eg 3: nums = [1,2,3]     Output = 3
 * Eg 4: nums = [1]         Output = 0
 */
import java.util.*;
public class RobberII
{
    public int Robbery(int nums[])
    {
        int dp1[] = new int[nums.length + 2];    // Creating a DP Array if last house is robbed...
        int dp2[] = new int[nums.length + 2];    // Creating a DP Array if first house is robbed...
        for(int i = dp1.length-3; i >= 1; i--)
        {   // We cannot choose Houses which are adjacent, so we choose houses which are maximum at alternate positions...
            dp1[i] = Math.max(nums[i] + dp1[i+2], dp1[i+1]);   // Updating the profit of adjacent houses...
            System.out.println("Loot : "+dp1[i]+" House : "+i);
        }
        System.out.println("If first House is not robbed : "+dp1[1]);  // Maximum profit stored at 2nd House...
        for(int i = dp2.length-4; i >= 0; i--)
        {   // We cannot choose Houses which are adjacent, so we choose houses which are maximum at alternate positions...
            dp2[i] = Math.max(nums[i] + dp2[i+2], dp2[i+1]);   // Updating profit of adjacent houses...
            System.out.println("Loot : "+dp2[i]+" House : "+i);
        }
        System.out.println("If last House is not robbed : "+dp2[0]);   // Maximum profit stored at 1st House...
        return Math.max(dp1[1], dp2[0]);   // Maximum of the two DP Arrays...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of Houses : ");
        x = sc.nextInt();
        int houses[] = new int[x];
        for(int i = 0; i < houses.length; i++)
        {
            System.out.print("Enter Money in "+(i+1)+" th House : ");
            houses[i] = sc.nextInt();
        }
        RobberII robberII = new RobberII();    // Object creation...
        System.out.println("Maximum Loot Attained : "+robberII.Robbery(houses));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. Since first and last house are adjacent, we cannot rob them both, so we divide it into two subproblems where we either rob first or last house...
 * 2. The maximum profit is ascertained using DP Array for both subproblems...
 * 3. Then we can finally return the maximum out of the two subproblems...
*/