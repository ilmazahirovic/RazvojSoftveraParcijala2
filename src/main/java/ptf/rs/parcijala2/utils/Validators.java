package ptf.rs.parcijala2.utils;

import java.util.regex.Pattern;

public class Validators {
    public static void checkRequiredField(String content, String fieldName) {
        if (content.isBlank()) throw new IllegalStateException(fieldName + " is required");
    }

    public static void checkMinLength(String content, int length, String fieldName) {
        if (content.length() < length) throw new IllegalStateException(fieldName + " must be at least " + length + " characters long");
    }

    public static void checkMaxLength(String content, int length, String fieldName) {
        if (content.length() > length) throw new IllegalStateException(fieldName + " cannot be longer than " + length + " characters");
    }

    public static void checkValidEmailAddress(String content, String fieldName) {
        if (!Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(content).matches()) throw new IllegalStateException(fieldName + " must contain a valid email address");
    }
}
