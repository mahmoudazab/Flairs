package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractNumber {
    public static int extractNumber(String input) {
        Pattern pattern = Pattern.compile("\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String numberStr = matcher.group(1);
            return Integer.parseInt(numberStr);
        } else {
            return 0;
        }
    }
}
