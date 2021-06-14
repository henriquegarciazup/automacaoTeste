package api.domain.cancelBatch;
import api.base.BaseRest;

import api.domain.createBatch.createBatchRest;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class cancelBatch_ extends BaseRest {



    String bearer = getBearer();
  //  File canlecingBatch = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchRest.json");
    String url = "https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/945/cancellable";
    createBatchRest cB = new createBatchRest();


    @Test
    @SuppressWarnings("unchecked")
    public void cancellableTrue() {
String batch = "716";
       
                given()
                        .relaxedHTTPSValidation()
                        .header("x-application-key", applicationKey)
                        .contentType("application/json")
                        .header("Authorization", bearer)
                        .when().get("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancellable")
                     //   .then().log().all();
                        .then().assertThat().body(Matchers.containsString("true")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancellableFalse() {
   String batch = "";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().get("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancellable")
                .then().assertThat().body(Matchers.containsString("false")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancellableWrongBatchNumber() {
        String batch = "000";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().get("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancellable")
             // .then().log().all();
                .then().assertThat().body(Matchers.containsString("não encontrado.")).log().all();


    }


    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchNoFirstDisapproval() {
        String batch = "949";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
               // .then().log().all();

                .then().assertThat().body(Matchers.containsString("disapproved.quotation.not.found")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchFirstDisapprovalDone() {
        String batch = "716";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                // .then().log().all();

                .then().assertThat().body(Matchers.containsString("true")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchWrongBatchNumber() {
        String batch = "000";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                // .then().log().all();

               .then().assertThat().body(Matchers.containsString("não encontrado.")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchStatusWAITING_OTM_NUMBER() {
        String batch = "838";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                //.then().log().all();

                .then().assertThat().body(Matchers.containsString("demand.invalid.status")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchStatusWAITING_QUOTATION_APPROVAL() {
        String batch = "716";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                //.then().log().all();

                .then().assertThat().body(Matchers.containsString("demand.invalid.status")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchStatusWAITING_PLAN() {
        String batch = "716";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                //.then().log().all();

                .then().assertThat().body(Matchers.containsString("demand.invalid.status")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchStatusIN_PROGRESS() {
        String batch = "950";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                //.then().log().all();

                .then().assertThat().body(Matchers.containsString("demand.invalid.status")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchStatusCOMPLETED() {
        String batch = "118";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                //.then().log().all();

                .then().assertThat().body(Matchers.containsString("demand.invalid.status")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void cancelingBatchStatusCANCELED() {
        String batch = "948";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .when().put("https://vli.dev.gateway.zup.me/trato-demand-plan/v1/demands/"+batch+"/cancel")
                //.then().log().all();

                .then().assertThat().body(Matchers.containsString("demand.invalid.status")).log().all();


    }
}
