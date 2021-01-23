package clickuserstorageproviderspi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpUserStorageRepository {

    boolean validateCredentials(String username, String password) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://run.mocky.io/v3/16c7b12a-a2b8-43e6-a83a-0e793decfde0");
        HttpResponse httpresponse = httpclient.execute(httpget);
        ObjectMapper objectMapper = new ObjectMapper();
        ValidateCredentialsResponse response = objectMapper.readValue(httpresponse.getEntity().getContent(), ValidateCredentialsResponse.class);
        return response.isValid;
    }
}

class ValidateCredentialsResponse {
    public boolean isValid;
}