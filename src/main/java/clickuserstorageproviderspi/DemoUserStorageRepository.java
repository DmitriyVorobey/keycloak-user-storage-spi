package clickuserstorageproviderspi;

public class DemoUserStorageRepository {
    DemoUser user = new DemoUser("1", "jack",
                            "sparrow",
                            true, System.currentTimeMillis(),
                            "sparrow@gmai.com"){

    };

    boolean validateCredentials(String username, String password) {
        return (username == "jack") && (password == "password");
    }

    DemoUser findUserById(String id) {
        return user;
    }

    DemoUser findUserByUsernameOrEmail(String username) {
        return user;
    }
}
