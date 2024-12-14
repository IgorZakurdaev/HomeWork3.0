import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class GitHubSearchTest2 {
    @BeforeAll
    static void beforeAll (){
        Configuration.browserSize ="1920x1080";
        Configuration.pageLoadStrategy ="eager";
        baseUrl ="https://github.com";
        Configuration.timeout=6000;
    }
    @Test
     void successFullEnterprisesSearchTest (){
        open(baseUrl);
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $(".HeaderMenu-nav").$(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
        sleep(6000);

    }
}
