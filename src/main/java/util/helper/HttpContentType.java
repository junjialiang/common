package util.helper;

/**
 * Created by liangjj on 2017/9/20.
 */
public enum HttpContentType {
    JPEG("image/jpeg"),PDF("application/pdf");

    private String value;

    HttpContentType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
