import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaRegressFormTests {
    @BeforeAll
    static void BeforeAll(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize ="1920x1080";
        Configuration.pageLoadStrategy ="eager";
        Configuration.timeout=10000;

    }
    @Test
    void studentRegistrationFormTest(){
        // селектор идентификатора # == "[key=value]"
        // селектор класса. пример .react-datepicker__month-select
        // $$когда нужный элемент является одним из группы однотипных элементов
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Тест");
        $("#lastName").setValue("Тестов");
        $("#userEmail").setValue("GGG@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1984");
        $$(".react-datepicker__day").findBy(text("11")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("div#hobbiesWrapper").$(byText("Sports")).click();
        $("div#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("lobster-07.jpg");
        $("#currentAddress").setValue("Пушкина 5");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        //asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Тест"));
        $(".table-responsive").shouldHave(text("Тестов"));
        $(".table-responsive").shouldHave(text("GGG@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567891"));
        $(".table-responsive").shouldHave(text("11 December,1984"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("lobster-07.jpg"));
        $(".table-responsive").shouldHave(text("Пушкина 5"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }

}
