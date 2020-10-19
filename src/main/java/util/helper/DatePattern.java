package util.helper;

/**
 * Created by liangjj on 2017/10/26.
 */
public enum DatePattern {
    YMD("yyyy-MM-dd"), YMDHMS("yyyy-MM-dd HH:mm:ss"), YMDHMSS("yyyy-MM-dd HH:mm:ss SSS");

    private final String value;

    DatePattern(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
