// Generate Usernames

class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        Map<String, Integer> counts = new HashMap<>();
        for (String name : arr) {
            counts.put(name, counts.getOrDefault(name, 0) + 1);
        }

        Set<String> used = new HashSet<>();
        Map<String, Integer> nextSuffix = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();

        for (String name : arr) {
            counts.put(name, counts.get(name) - 1);

            if (!used.contains(name)) {
                used.add(name);
                ans.add(name);
            } else {
                nextSuffix.putIfAbsent(name, 1);
                String candidate = name + nextSuffix.get(name);
                while (used.contains(candidate) || counts.getOrDefault(candidate, 0) > 0) {
                    nextSuffix.put(name, nextSuffix.get(name) + 1);
                    candidate = name + nextSuffix.get(name);
                }
                used.add(candidate);
                ans.add(candidate);
            }
        }

        return ans;
    }
}
