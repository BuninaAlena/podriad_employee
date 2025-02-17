package browser;

import java.util.Random;

public class RandomGenerator {

    // Массив фамилий
    private static final String[] LAST_NAMES = {
            "Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов", "Попов",
            "Козлов", "Лебедев", "Морозов", "Новиков", "Фёдоров", "Михайлов",
            "Алексеев", "Андреев", "Григорьев", "Романов", "Николаев", "Семёнов",
            "Егоров", "Степанов", "Павлов", "Васильев", "Богданов", "Осипов",
            "Титов", "Макаров", "Захаров", "Дмитриев", "Гусев", "Киселёв"
    };

    // Массив имен
    private static final String[] FIRST_NAMES = {
            "Александр", "Алексей", "Андрей", "Антон", "Артём", "Борис",
            "Валентин", "Василий", "Виктор", "Виталий", "Владимир", "Владислав",
            "Григорий", "Даниил", "Дмитрий", "Евгений", "Егор", "Иван",
            "Игорь", "Кирилл", "Константин", "Максим", "Михаил", "Никита",
            "Олег", "Павел", "Роман", "Сергей", "Степан", "Юрий"
    };

    // Массив отчеств
    private static final String[] PATRONYMICS = {
            "Александрович", "Алексеевич", "Андреевич", "Антонович", "Аркадьевич",
            "Борисович", "Валентинович", "Васильевич", "Викторович", "Владимирович",
            "Григорьевич", "Даниилович", "Дмитриевич", "Евгеньевич", "Егорович",
            "Иванович", "Игоревич", "Кириллович", "Константинович", "Максимович",
            "Михайлович", "Николаевич", "Олегович", "Павлович", "Романович",
            "Сергеевич", "Степанович", "Фёдорович", "Юрьевич", "Яковлевич"
    };

    // Метод для генерации случайной фамилии
    public static String generateRandomLastName() {
        Random random = new Random();
        int index = random.nextInt(LAST_NAMES.length);
        return LAST_NAMES[index];
    }

    // Метод для генерации случайного имени
    public static String generateRandomFirstName() {
        Random random = new Random();
        int index = random.nextInt(FIRST_NAMES.length);
        return FIRST_NAMES[index];
    }

    // Метод для генерации случайного отчества
    public static String generateRandomPatronymic() {
        Random random = new Random();
        int index = random.nextInt(PATRONYMICS.length);
        return PATRONYMICS[index];
    }
}
