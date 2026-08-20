class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        System.out.println(s.toCharArray());
        char[] sortedStringS = s.toCharArray();
        char[] sortedStringT = t.toCharArray();
        Arrays.sort(sortedStringS);
        Arrays.sort(sortedStringT);

        for (int i = 0; i < s.length(); i++) {
            if (sortedStringS[i] != sortedStringT[i]) return false;
        }

        return true;
    }
}
