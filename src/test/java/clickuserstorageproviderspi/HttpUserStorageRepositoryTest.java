package clickuserstorageproviderspi;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpUserStorageRepositoryTest {

    @Test
    void validateCredentials() throws IOException {
        // Assert
        HttpUserStorageRepository sut = new HttpUserStorageRepository();

        // Act
        boolean isValid = sut.validateCredentials("jack", "sparrow");

        // Arrange
        Assertions.assertTrue(isValid);
    }

    @Test
    void findUserById() throws IOException {
        // Assert
        HttpUserStorageRepository sut = new HttpUserStorageRepository();

        // Act
        DemoUser user = sut.findUserById("1");

        // Arrange
        Assertions.assertEquals(user.getId(), "1");
        Assertions.assertEquals(user.getFirstName(), "Jack");
        Assertions.assertEquals(user.getLastName(), "Sparrow");
        Assertions.assertEquals(user.isEnabled(), true);
        Assertions.assertEquals(user.getCreated(), 1611435025);
        Assertions.assertEquals(user.getEmail(), "sparrow@gmail.com");
    }
}