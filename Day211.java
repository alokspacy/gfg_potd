// Transform String

class Solution
{
    int transform (String A, String B)
    {
        // code here
        HashMap<Character,Integer> map1 =new HashMap<>();
        HashMap<Character,Integer> map2 =new HashMap<>();
        if(A.length()!=B.length()){
            return -1;
        }
        char chA[] =A.toCharArray();
        char chB[] =B.toCharArray();
         
         for(Character e: chA){
             map1.put(e,map1.getOrDefault(e,0)+1);
         }
         for(Character e: chB){
             map2.put(e,map2.getOrDefault(e,0)+1);
         }
         if(!map1.equals(map2)) return -1;
        int count =0;
        int i=A.length()-1;
        int j =B.length()-1;
        while(i>=0 && j>=0){
            if(A.charAt(i)==B.charAt(j)){
                i--;
                j--;
            }else{
                count++;
                i--;
            }
        }
        return count;
    }
}
