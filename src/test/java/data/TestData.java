package data;

import java.util.List;

public class TestData {

    public static final String NAME = "Nikita";
    public static final String HOME_PAGE_TITLE = "Тест";
    public static final String URL = "C:/Users/Nikita/Desktop/TestTasks/qa-test.html";

    public static final String LOGIN = "test@protei.ru";

    public static final String PASSWORD = "test";

    public static final String MODAL_DIALOG_TEXT = "Данные добавлены.";

    public static final String INCORRECT_EMAIL = "admin123.ru";

    public static final String INCORRECT_PASSWORD = "0000";

    public static final String INCORRECT_NAME = "00001234";

    public static final String GENDER_MALE = "Мужской";

    public static final String GENDER_FEMALE = "Женский";

    public static final String REGEX_FOR_EMAIL = "^(.+)@(\\S+)$";

    public static final int OPTION_ONE_CHECKBOX_LIST_NUMBER = 0;

    public static final int OPTION_TWO_CHECKBOX_LIST_NUMBER = 1;

    public static final int OPTION_ONE_ON_CHECKBOX= 0;

    public static final int OPTION_TWO_ON_CHECKBOX = 1;

    public static final int OPTION_THREE_ON_CHECKBOX = 2;

    public static final List<String> TEXTS_OF_LOGS = List.of(
            "test@protei.ru",
            "Nikita",
            "Мужской",
            "1.1",
            "2.3"
    );
}
