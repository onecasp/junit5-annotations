import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class MacProductsCheckTest {
    @BeforeEach
    void setup() {
        open("https://www.apple.com/mac");
    }
    @ValueSource(strings = {"MacBook Air", "MacBook Pro", "iMac 24", "Mac mini",
            "Mac Studio", "Mac Pro"})
    @ParameterizedTest
    @Tags({@Tag("P1"), @Tag("Regression")})
    void macProductsTest(String mac) {
        $$(".chapternav-items a").findBy(Condition.text(mac)).click();
        $(".main").shouldHave(Condition.text(mac));
    }
}
