package api.registration;

public class UnSuccessReq {
    private String error;

    public UnSuccessReq () {}

    public UnSuccessReq(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
