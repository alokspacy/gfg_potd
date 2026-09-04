// Bird and Max Fruit Gathering

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int sum = 0;
		for (int i = 0; i < m; i++) {
			sum += arr.get(i);
		}
		int max = sum;
		int index = 0;
		int n = arr.size();
		for (int i = m; i < n * 2; i++) {
			sum -= arr.get(index %n);
			sum += arr.get(i % n);
			max = Math.max(sum, max);
			index++;
		}

		return max;
    }
}
