import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CheckProductsLineTest {
    static Stream<Arguments> productLineCheck() {
        return Stream.of(
                Arguments.of(Products.Mac, List.of("MacBook Air", "MacBook Pro", "iMac 24", "Mac mini",
                        "Mac Studio", "Mac Pro")),
                Arguments.of(Products.iPad, List.of("iPad Pro", "iPad Air", "iPad", "iPad mini")),
                Arguments.of(Products.iPhone, List.of("iPhone 15 Pro", "iPhone 15", "iPhone 14", "iPhone 13",
                        "iPhone SE"))
        );
    }

    @BeforeEach
    void setup() {
        open("https://www.apple.com/");
    }

    @MethodSource
    @ParameterizedTest
    void productLineCheck(Products Line, List<String> expectedProduct) {
        $(".globalnav-item-iphone").hover();
        $$(".globalnav-submenu-list a")
                .shouldHave(CollectionCondition.texts(expectedProduct));
    }
}
