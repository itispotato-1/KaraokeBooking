package lib.loginregister.Passwordvalidation;

public class PasswordValidator {

    /**
     * ตรวจสอบความแข็งแรงของรหัสผ่าน
     *
     * @param password รหัสผ่านที่ต้องการตรวจสอบ
     * @return ระดับความแข็งแรงของรหัสผ่าน (INVALID, WEAK, MEDIUM, STRONG)
     */
    public static PasswordStrength validate(String password) {
        if (password.length() < 8) {
            return PasswordStrength.INVALID;
        }

        boolean hasUpper = false;
        boolean hasNumber = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            }
        }

        int strengthCount = 0;
        if (hasUpper) strengthCount++;
        if (hasNumber) strengthCount++;
        if (password != null) strengthCount++;

        switch (strengthCount) {
            case 1:
                return PasswordStrength.WEAK;
            case 2:
                return PasswordStrength.MEDIUM;
            case 3:
                return PasswordStrength.STRONG;
            default:
                return PasswordStrength.INVALID; // เผื่อหลุดกรณีใด
        }
    }
}