package clickuserstorageproviderspi;

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
}