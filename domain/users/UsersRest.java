//package test.java.tratoRest.satRest;
package api.domain.users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import api.base.BaseRest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UsersRest extends BaseRest {

    String url = enviroment + "/integra-rodo-entidades/v1/signed/user";
    String bearer = getBearer();

    @Test
    @SuppressWarnings("unchecked")
    public void getUsersSuccess() {

                given()
                        .header("x-application-key", applicationKey)
                        .contentType("application/json")
                        .header("authorization", bearer)

                        .when()
                        .get(url)

                        .then()
                        .statusCode(200)

                        .extract()
                        .response();

    }

    @Test
    @SuppressWarnings("unchecked")
    public void getUsersUnauthorized() {

                given()
                        .header("X-Application-Key", applicationKey)
                        .contentType("application/json")


                        .when()
                        .get(url)

                        .then()
                        .statusCode(401)
                        .contentType(ContentType.JSON);


    }
}
