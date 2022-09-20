package api;

import api.colors.ColorsData;
import api.registration.Register;
import api.registration.SuccessReg;
import api.registration.UnSuccessReq;
import api.spec.Specification;
import api.users.UserData;
import api.users.UserTime;
import api.users.UserTimeResponse;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private static String URL = "https://reqres.in/";

    /**
     * 1. Получить список пользователей со второй страницы https://reqres.in/;
     * 2. Убедиться что id пользователей содержаться в их avatar;
     * 3. Убедиться, что email пользователй имеет окончание reqres.in;
     */
    @Test
    public void checkAvatarAndTest() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecDK200());

        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    /**
     * 1. Используя сервис https://reqres.in/ протестировать регистрацию пользователя в системе;
     * 2. Необходимо создание 2 тестов:
     * - успешная регистрация
     * - регистрация с ошибокой из-за отсутствия пароля
     * 3. проверить коды ошибок.
     */

    @Test
    public void successRegTest() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecDK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then()
                .log().all()
                .extract().as(SuccessReg.class);
        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());

        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }

    @Test
    public void unSuccessUserTest() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecDK400());
        Register user = new Register("sydney@fife", "");
        UnSuccessReq unSuccessReq = given()
                .body(user)
                .post("api/register")
                .then()
                .log().all()
                .extract().as(UnSuccessReq.class);
        Assert.assertEquals("Missing password", unSuccessReq.getError());
    }

    /**
     * 1. Используя сервис https://reqres.in/ убедиться, что перация LIST<RESOURCE> возвращает данные
     * отсортированные по годам.
     */
    @Test
    public void sortedYearsTest() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecDK200());
        List<ColorsData> colors = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears, years);
    }

    /**
     * 1. Используя сервис https://reqres.in/ попробовать удалить второго пользователя и сравнить
     * статус-код
     */
    @Test
    public void deleteUserTest() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecUnique(204));
        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();
    }

    /**
     * 1. Используя сервис https://reqres.in/ обновить информацию о пользователе и сравнить дату обновления
     * с текущей датой на машине
     */
    @Test
    public void timeTest() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecDK200());
        UserTime user = new UserTime("morpheus", "zion president");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);

        String regex = "(.{5})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");
        System.out.println(currentTime);
        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex, ""));
        System.out.println(response.getUpdatedAt().replaceAll(regex, ""));
    }
}
