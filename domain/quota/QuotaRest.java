//package test.java.tratoRest.satRest;
package api.domain.quota;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.response.Response;
import api.base.BaseRest;


public class QuotaRest extends BaseRest {

    @Test
    public void quotaSuccess() {

        String url = enviroment+"/integra-rodo-entidades/v1/quotas";
        Response response = authenticate();
        String bearer = "Bearer"+response.header("x-access-token");

        given()
                .header("x-application-key",applicationKey)
                .contentType("application/json")
                .header("authorization",bearer)

                .when()
                .get(url)

                .then()
                .statusCode(200);

    }
}
