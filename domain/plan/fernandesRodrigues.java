package api.domain.plan;

import api.base.BaseRest;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class fernandesRodrigues extends BaseRest {


    String bearer = getBearer();
    //  File canlecingBatch = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchRest.json");
    String url = "https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/945/cancellable";


    @Test
    @SuppressWarnings("unchecked")
    public void removeExtraDaysFromFlow() {
        String batch = "716";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().get("https://vli.dev.gateway.zup.me/trato-fr/v1/fluxo")
                .then().log().all();
               // .then().assertThat().body(Matchers.containsString("true")).log().all();


    }




}
