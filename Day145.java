// Construct List using XOR Queries

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
       ArrayList<Integer> arr = new ArrayList<>();
       // Stores cumulative XOR effect of all type-1 queries seen so far
       int sum = 0,q=queries.length;
        // Process queries from end to start
       for(int i=q-1;i>=0;i--)
       {
            // Type 0: Insert x
           if(queries[i][0]==0)
           {
               // Apply all future XOR operations to x
               arr.add(queries[i][1]^sum);
           }
           else
           {
               // Accumulate XOR operations
              sum^=queries[i][1]; 
           }
       }
        // Initial element 0 becomes (0 ^ sum) so 0^sum=sum
       arr.add(sum);
        // Return sorted result
       Collections.sort(arr);
       return arr;
    }
}

