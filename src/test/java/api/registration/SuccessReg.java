package api.registration;

public class SuccessReg extends Register {
    private Integer id;
    public String token;

    public SuccessReg(){}

    public SuccessReg(Integer id, String token) {
        super();
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
