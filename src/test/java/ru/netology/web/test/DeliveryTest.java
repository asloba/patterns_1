package ru.netology.web.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.data.DataGenerator.Registration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.web.data.DataGenerator.Registration.*;
import static ru.netology.web.data.DataGenerator.generateDate;
import static ru.netology.web.data.DataGenerator.getRandomCity;

class CardDeliveryTest {

//    private DataGenerator.UserInfo user;
//
//    private final DataGenerator dataGenerator = new DataGenerator();

    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }
//    DataGenerator.UserInfo user = DataGenerator.Registration.generateUser();

    @Test
    void shouldSendCorrectForm() {
        DataGenerator.UserInfo user = DataGenerator.Registration.generateUser();
//        String orderDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id='city'] input").setValue(getRandomCity());
        $("[data-test-id=date] input").doubleClick().sendKeys(generateDate(3));
        $("[data-test-id=name] input").setValue(user.getName());
        $("[data-test-id=phone] input").setValue(user.getPhone());
        $(".checkbox__box").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[data-test-id=success-notification]").shouldHave(text("Встреча успешно запланирована на "), Duration.ofSeconds(15));
    }


    }
