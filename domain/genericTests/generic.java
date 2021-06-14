package api.domain.genericTests;

import api.base.BaseRest;
import org.junit.Test;
import api.base.BaseRest;
import api.domain.createBatch.createBatchRest;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;

public class generic extends BaseRest {

    String bearer = getBearer();
    Integer orderNumber = 318;
    File editLicensePlate = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/editLicensePlate.json");

    String url = "https://vli.dev.gateway.zup.me/trato-demand-plan/v1/shipping-order/"+orderNumber;


    @Test
    @SuppressWarnings("unchecked")
    public void editLicensePlate() {



        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(editLicensePlate)
                .when()
                .put(url)
                .then().log().all();
        //  .extract().path("id");






    }
    }






