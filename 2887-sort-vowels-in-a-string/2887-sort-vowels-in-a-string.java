class Solution {
    public String sortVowels(String s) {
        String vowels = "AEIOUaeiou";
        PriorityQueue<Character> pq = new PriorityQueue<>();

        // Step 1: Collect vowels into min-heap
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                pq.offer(c);
            }
        }

        // Step 2: Build result, replacing vowels with smallest available
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                result.append(pq.poll()); // get sorted vowel
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
