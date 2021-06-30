package ru.netology.web.data;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    public DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static String getRandomCity() {
            List<String> list = Arrays.asList("Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Биробиджан",
                    "Благовещенск", "Брянск", "Великий Новгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж",
                    "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово",
                    "Киров", "Кострома", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп",
                    "Махачкала", "Москва", "Мурманск", "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург",
                    "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард", "Самара",
                    "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар",
                    "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары",
                    "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль");
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }

        public static UserInfo generateUser() {
            Faker faker = new Faker(new Locale("ru"));
            return new UserInfo(
                    faker.address().city(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }

        public static String generateDate(int shift){
            LocalDate newDate = LocalDate.now().plusDays(shift);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String date = dateTimeFormatter.format(newDate);
            return date;
        }
    }

    @Data
    @RequiredArgsConstructor
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
