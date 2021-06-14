package api.domain.pricing;

import api.base.BaseRest;
import api.domain.createBatch.createBatchRest;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class pricing extends BaseRest {



    String bearer = getBearer();
    File pricing = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/princing/pricing.json");
    String url = "https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+1275+"/quotations";







    @Test
    @SuppressWarnings("unchecked")
    public void pricing() {



        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(pricing)
                .when()
                .post(url)
                .then().log().all();
              //  .extract().path("id");

    }


}
