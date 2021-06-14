package api.domain.quotaDemand;

import api.base.BaseRest;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateQuotaDemandRest extends BaseRest {

    String url = enviroment + "/integra-rodo-entidades/v1/quota-demands";
    String bearer = getBearer();



    File filename = new File("/Users/raphael/Documents/trato-api/integration-test/src/test/java/api/domain/quotaDemand/CreateQuotaDemandPayload.json");




    @Test
    public void CreateQuotaDemandRestSuccess() throws IOException {

        //Response response =
                given()
                        .header("x-application-key",applicationKey)
                        .contentType("application/json")
                        .header("authorization",bearer)
                        .header("src-app","Web")
                        .body(filename)

                .when()
                        .post(url)

                .then()
                        .statusCode(200)
                        .extract().response();

        //return response;
    }
}
