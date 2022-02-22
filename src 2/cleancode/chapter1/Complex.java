package cleancode.chapter1;

public class Complex {
    private final double value;

    // 생성자를 제한하려면 접근 지정자를 private로 선언
    public Complex(double value) {
        this.value = value;
    }

    public static Complex FromRealNumber(double value) {
        return new Complex(value);
    }
}
