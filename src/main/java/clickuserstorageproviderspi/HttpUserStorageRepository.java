package clickuserstorageproviderspi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpUserStorageRepository {
    public HttpUserStorageRepository(){

    }

    boolean validateCredentials(String username, String password) {
        try {
            HttpResponse httpresponse = makeGetRequest("https://run.mocky.io/v3/16c7b12a-a2b8-43e6-a83a-0e793decfde0");
            ObjectMapper objectMapper = new ObjectMapper();
            ValidateCredentialsResponse response = objectMapper.readValue(httpresponse.getEntity().getContent(), ValidateCredentialsResponse.class);

            return response.isValid;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    DemoUser findUserById(String id) {
        try {
            HttpResponse httpresponse = makeGetRequest("https://run.mocky.io/v3/5c26b3b7-19e4-491e-bcde-a92d24333144");
            ObjectMapper objectMapper = new ObjectMapper();
            UserResponse response = objectMapper.readValue(httpresponse.getEntity().getContent(), UserResponse.class);

            return new DemoUser(response.id,
                    response.firstName,
                    response.lastName,
                    response.enabled,
                    response.created,
                    response.email);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    DemoUser findUserByUsernameOrEmail(String username){
        try {
            HttpResponse httpresponse = makeGetRequest("https://run.mocky.io/v3/5c26b3b7-19e4-491e-bcde-a92d24333144");
            ObjectMapper objectMapper = new ObjectMapper();
            UserResponse response = objectMapper.readValue(httpresponse.getEntity().getContent(), UserResponse.class);

            return new DemoUser(response.id,
                    response.firstName,
                    response.lastName,
                    response.enabled,
                    response.created,
                    response.email);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HttpResponse makeGetRequest(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        HttpResponse httpresponse = httpclient.execute(httpget);

        return httpresponse;
    }
}

class ValidateCredentialsResponse {
    public boolean isValid;
}

class UserResponse {
    public String id;
    public String firstName;
    public String lastName;
    public boolean enabled;
    public Long created;
    public String email;
}