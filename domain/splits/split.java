package api.domain.splits;

import api.base.BaseRest;
import api.domain.createBatch.createBatchRest;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class split extends BaseRest {



    String bearer = getBearer();
    //  File canlecingBatch = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchRest.json");
    String url = "https://vli.dev.gateway.zup.me/trato-demand-plan/v2/demand-volumes/splits";
    File splitSuccessAutonomousAndShipping = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/splitSuccessAutonomousAndShipping.json");
    File splitSuccessAutonomousAndAutonomous = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/splitSuccessAutonomousAndAutonomous.json");
    File splitSuccessShippingAndShipping = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/splitSuccessShippingAndShipping.json");





    createBatchRest r = new createBatchRest();

    @Test
    @SuppressWarnings("unchecked")
    public void splitSuccessAutonomousAndShipping() {



        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(splitSuccessAutonomousAndShipping)
                .when()
                .post(url)
                .then().log().all();
              //  .extract().path("id");

    }

    @Test
    @SuppressWarnings("unchecked")
    public void splitSuccessAutonomousAndAutonomous() {
        r.createBatchSuccess();
        //  String batch =  r.createBatchSuccess();

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(splitSuccessAutonomousAndAutonomous)
                .when()
                .post(url)
                .then().log().all();
        //  .extract().path("id");

    }

    @Test
    @SuppressWarnings("unchecked")
    public void splitSuccessShippingAndShipping() {

        //  String batch =  r.createBatchSuccess();

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(splitSuccessShippingAndShipping)
                .when()
                .post(url)
                .then().log().all();
        //  .extract().path("id");

    }





}
