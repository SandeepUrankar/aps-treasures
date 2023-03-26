class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"Face", "Facetime", "Fast"};
        System.out.println(longestCommonPrefix(strings));
    }

    static String longestCommonPrefix(String[] strings) {
        // If the strings are empty then return empty string.
        if(strings.length == 0) return "";
        // Let's assume the first element to be the prefix.
        String prefix = strings[0];
        // Loop from the second element through the last element.
        for (int i = 1; i < strings.length; i++) {
            // Loop until the prefix is matched with the current string.
            while(strings[i].indexOf(prefix) != 0){
                // If the current string and prefix do not match, pop the last 
                // character from the prefix until it matches.
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        // The prefix answer will be returned.
        return prefix;
    }
}
