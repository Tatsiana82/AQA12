package ThreeUsers;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "valid account data")
    public Object[][] getTestData() {
        return new String[][]{
                {"user_1@mail.com", "password"},
                {"user_2@mail.com", "password"},
                {"user_3@mail.com", "password"}
        };
    }
}