import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearchTests {
    @BeforeAll
    static void beforeAll (){
        Configuration.browserSize ="1920x1080";
        Configuration.pageLoadStrategy ="eager";
        Configuration.baseUrl ="https://github.com";
    }
    @Test
    void successFullSelenenideWikiSearchTest (){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("*").shouldHave(text("JUnit5 extend test class"));


        sleep(6000);


    }
}
