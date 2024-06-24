package evaluations.level9;

public class MyAuthenticationDatabase extends MyAuthentication{
    private String databaseSpecificAuthentication;

    public MyAuthenticationDatabase(String databaseSpecificAuthentication, long authenticationKey) {
        super(authenticationKey);
        this.databaseSpecificAuthentication = databaseSpecificAuthentication;
    }
}
