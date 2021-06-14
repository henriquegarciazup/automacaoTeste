//package test.java.tratoRest.satRest;
package api.domain.traders;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import io.restassured.response.Response;
import api.base.BaseRest;
import org.junit.jupiter.api.Test;


public class TradersRest extends BaseRest {


    String url = enviroment +"/integra-rodo-entidades/v1/traders";
    String bearer = getBearer();


    public void pre() {

        given()
                .header("x-application-key",applicationKey)
                .contentType("application/json")
                .header("authorization",bearer)
                .header("origin","https://admin.stg.apptrato.com.br")
                .header("access-control-request-method","GET")
                .header("access-control-request-headers","accept-timezone,authorization,req-id,req-origin,session-id,src-app,x-application-key")

                .when()
                .options(url)

                .then()
                .statusCode(200);




    }
    public Response getTraders() {
        pre();
        Response response =
                given()
                        .header("x-application-key",applicationKey)
                        .contentType("application/json")
                        .header("authorization",bearer)

                        .when()
                        .get(url)

                        .then()
                        .statusCode(200)
                        .extract().response();

        return response;

    }
    @Test
    public void getTradersNoAuthentication() {

        given()
                .header("x-application-key",applicationKey)
                .contentType("application/json")

                .when()
                .get(url)

                .then()
                .statusCode(401)
                .extract().response();

    }

    //Compara se a lista retornada pelo recurso Traders (GET) está de acordo com a tabela
    //trader_user_traders
    @Test
    public void checkTraders() throws ClassNotFoundException, SQLException {

        Response response = getTraders();

        List<String> restList = new ArrayList<String>();
        for(int i=0; i < response.jsonPath().getList("content.id").size(); i++) {
            String temp = response.jsonPath().getString("content["+i+"].id");
            restList.add(temp);
        }

        TradersSQL traders = new TradersSQL();
        List<String> sqlResult = traders.checkDataBaseTraders();
        restList.sort(null);
        sqlResult.sort(null);

        Assert.assertArrayEquals(restList.toArray(), sqlResult.toArray());
    }

}
