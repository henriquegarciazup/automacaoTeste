//package test.java.tratoRest.satRest;
package api.domain.terminals;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import io.restassured.response.Response;
import api.base.BaseRest;
import org.junit.jupiter.api.Test;

public class TerminalsRest extends BaseRest {

    String url = enviroment+"/integra-rodo-entidades/v1/terminals";
    String bearer = getBearer();


    public Response getTerminals() {

        Response response =
                given()
                        .header("x-application-key",applicationKey)
                        .contentType("application/json")
                        .header("authorization",bearer)

                        .when()
                        .get(url)

                        .then()
                        .statusCode(200)

                        .extract()
                        .response();

        return response;
    }
    /*
    @Test
    public void getTerminalsNoAuthentication() {

        given()
                .header("x-application-key",applicationKey)
                .contentType("application/json")

                .when()
                .get(url)

                .then()
                .statusCode(401)
                .extract().response();

    }*/

    @Test
    public void checkTerminalsSuccess() throws ClassNotFoundException, SQLException {

        TerminalsSQL terminalsSQL = new TerminalsSQL();
        Response response = getTerminals();
        List<String> restList = new ArrayList<String>();

        for(int i=0; i < response.jsonPath().getList("content.id").size(); i++) {
            String temp = response.jsonPath().getString("content["+i+"].id");
            restList.add(temp);
        }

        List<String> sqlList = terminalsSQL.getListActiveTerminals();
        restList.sort(null);
        sqlList.sort(null);
        Assert.assertArrayEquals(restList.toArray(), sqlList.toArray());

    }
}
