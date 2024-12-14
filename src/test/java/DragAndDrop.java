import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforeAll (){
        Configuration.browserSize ="1920x1080";
        Configuration.pageLoadStrategy ="eager";
        baseUrl ="https://the-internet.herokuapp.com";
        Configuration.timeout=6000;



    }
    @Test
    void rectangleChangePositionTest1(){
        open("/drag_and_drop");
        //before actions assert

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().clickAndHold($("#column-a")).
                moveToElement($("#column-b")).release().perform();
        //after actions assert
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        sleep(5000);
    }
    @Test
    void rectangleChangePositionTest2(){
        open("/drag_and_drop");
        //before actions assert
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        //after actions assert
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
