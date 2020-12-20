package dasniko.keycoak.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUserStorageProviderFactoryTest {
    private DemoUserStorageProviderFactory sut;

    public DemoUserStorageProviderFactoryTest() {
      sut = new DemoUserStorageProviderFactory();
    }

    @Test
    public void getIdReturnId() {
        String id = sut.getId();

        Assertions.assertEquals(id, "demo-user-provider");
    }
}