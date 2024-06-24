package evaluations.level9;

public class MyAuthenticationServer extends MyAuthentication {

    private String serverSpecificAuthentication;

    public MyAuthenticationServer(String serverSpecificAuthentication,
                                  long authenticationKey) {
        super(authenticationKey);
        this.serverSpecificAuthentication = serverSpecificAuthentication;
    }
}
