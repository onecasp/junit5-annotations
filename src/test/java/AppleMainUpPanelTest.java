import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class AppleMainUpPanelTest {

    public String parameter = "Mac";
    @BeforeEach
    void setup() {
        open("https://www.apple.com/");
    }

    @CsvSource(value = {
            "Mac , MacBook Pro",
            "iPad , iPad Pro",
            "iPhone , iPhone 15",
            "Watch , Apple Watch SE",
            "AirPods , AirPods Max"
    })
    @ParameterizedTest(name = "Subpage {0} of apple.com contains headliner {1}")
    @Tags({@Tag("P0"), @Tag("SMOKE"), @Tag("Regression")})
    void appleUpPanelTest(String product, String headliner) {
        $(".globalnav-content").$("[aria-label="+product+"]").click();
        $("#chapternav").shouldHave(Condition.text(headliner));
    }


}
