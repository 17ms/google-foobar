// https://foobar.withgoogle.com/

public class Solution {
    static final String[] BRAILLE_BASE = {
            "100000",
            "110000",
            "100100",
            "100110",
            "100010",
            "110100",
            "110110",
            "110010",
            "010100",
            "010110",
            "101000",
            "111000",
            "101100",
            "101110",
            "101010",
            "111100",
            "111110",
            "111010",
            "011100",
            "011110",
            "101001",
            "111001",
            "010111",
            "101101",
            "101111",
            "101011"
            // caps: "000001"
            // blank: "000000"
    };

    public static String solution(String plaintext) {
        int temp_int = 96;
        StringBuilder builder = new StringBuilder();

        for (char ch : plaintext.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                builder.append("000001");
                ch = Character.toLowerCase(ch);
            }

            if (ch == ' ') {
                builder.append("000000");
            } else {
                int temp = (int) ch;
                if (temp <= 122 & temp >= 97) {
                    builder.append(BRAILLE_BASE[temp - temp_int - 1]);
                }
            }
        }

        return builder.toString();
    }
}
