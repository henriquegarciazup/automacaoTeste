package api.domain.createBatch;
import api.base.BaseRest;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class createBatchRest extends BaseRest {


    String bearer = getBearer();
    File createBachSuccess = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchRest.json");
    File createBachWrongDate = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBachWrongDate.json");
    File createBatchNoTraderCode = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchNoTraderCode.json");
    File createBatchSameDeliveryDates = new File ("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchSameDeliveryDates.json");
    File createBatchRestAllDaysOfWeek = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchRestAllDaysOfWeek.json");
    File createBatchNoCustomization = new File("C:/Users/henrique.costa/Desktop/PROFISSIONAL/TRATO/AUT/trato-api-qa-sat_cargo_flex-scheduling/trato-api-qa-sat_cargo_flex-scheduling/integration-test/src/test/java/api/domain/createBatch/createBatchNoCustomization.json");

    String url = "https://vli.dev.gateway.zup.me/trato-demand-plan/v2/demands";


   // public static String jsonAsString;
    @Test
    @SuppressWarnings("unchecked")
    public void createBatchSuccess() {


        Response r =

                         given()
                        .relaxedHTTPSValidation()
                        .header("x-application-key", applicationKey)
                        .contentType("application/json")
                        .header("Authorization", bearer)
                        .body(createBachSuccess)
                        .when()
                        .post(url);

        // no pior dos casos coloca isso num loop e olha o índice x de um array com o índice x do outro em vez de colocar um por um

        // ARRAY COM RESULTADO ESPERADO
        String expectedResult[];
        expectedResult = new String[211];
        // ARRAY COM RESULTADO OBTIDO
        String jsonAsString = r.asString();
        String[] obitainedResult = jsonAsString.split(",");
expectedResult[3] = "\"origin\":1";
        expectedResult[44] = "2021-12-20";
        expectedResult[45] = "totalWeight\":500.0";
        expectedResult[46] = "splitWeight\":0.0";
        expectedResult[47] = "weightToSplit\":500.0";
        expectedResult[48] = "associatedWeight\":0.0";
        expectedResult[54] = "week\":0";
        expectedResult[55] = "month\":0";
        expectedResult[56] = "extraDay\":false";
        expectedResult[61] = "arrivalDay\":\"2021-12-20";
        expectedResult[62] = "totalWeight\":0.0";
        expectedResult[63] = "splitWeight\":0.0";
        expectedResult[64] = "weightToSplit\":0.0";
        expectedResult[65] = "associatedWeight\":0.0";
        expectedResult[66] = "executedWeight\":0.0";
        expectedResult[71] = "\"week\":0";
        expectedResult[72] = "\"month\":0";
        expectedResult[73] = "\"extraDay\":true";
        expectedResult[78] = "\"arrivalDay\":\"2021-12-22";
        expectedResult[79] = "\"totalWeight\":0.0";
        expectedResult[88] = "\"week\":0";
        expectedResult[89] = "\"month\":0";
        expectedResult[90] = "\"extraDay\":true";
        expectedResult[95] = "\"arrivalDay\":\"2021-12-23\"";
        expectedResult[96] = "\"totalWeight\":0.0";
        expectedResult[105] = "\"week\":0";
        expectedResult[106] = "\"month\":0";
        expectedResult[107] = "\"extraDay\":true";
        expectedResult[112] = "\"arrivalDay\":\"2021-12-24\"";
        expectedResult[113] = "\"totalWeight\":0.0";
        expectedResult[122] = "\"week\":0";
        expectedResult[123] = "\"month\":0";
        expectedResult[124] = "\"extraDay\":true";
        expectedResult[129] = "\"arrivalDay\":\"2021-12-25\"";
        expectedResult[130] = "\"totalWeight\":0.0";
        expectedResult[139] = "\"week\":0";
        expectedResult[140] = "\"month\":0";
        expectedResult[141] = "\"extraDay\":true";
        expectedResult[146] = "\"arrivalDay\":\"2021-12-26\"";
        expectedResult[147] = "\"totalWeight\":0.0";
        expectedResult[156] = "\"week\":0";
        expectedResult[157] = "\"month\":0";
        expectedResult[158] = "\"extraDay\":true";
        expectedResult[163] = "\"arrivalDay\":\"2021-12-27\"";
        expectedResult[164] = "\"totalWeight\":0.0";
        expectedResult[173] = "\"week\":1";
        expectedResult[174] = "\"month\":0";
        expectedResult[175] = "\"extraDay\":true";
        expectedResult[190] = "\"week\":1";
        expectedResult[192] = "\"extraDay\":true";







//for(int i=0; i <238; i++){
//
//    System.out.println(obitainedResult[i]);
//}

  //   System.out.println(expectedResult[44] + "_______" + obitainedResult[44]);





    //    System.out.println("esperado"+ expectedResult[44] + "obtido" + obitainedResult[44]);


//for (int i =0; i< expectedResult.length; i++){
//
//            if(obitainedResult[i].equals(expectedResult[i])){
//
//                System.out.println("true" + " "+ obitainedResult[i] + " " + expectedResult[i]);
//            }else{
//                System.out.println("false" + " "+ obitainedResult[i] + " " + expectedResult[i]);
//
//            }
//
//
//        }







//              expectedResult[44].equals(obitainedResult[44]);
//            expectedResult[45].equals(obitainedResult[45]);
//            expectedResult[46].equals(obitainedResult[46]);
//            expectedResult[47].equals(obitainedResult[47]);
//            expectedResult[48].equals(obitainedResult[48]);
//            expectedResult[54].equals(obitainedResult[54]);
//            expectedResult[55].equals(obitainedResult[55]);
//            expectedResult[56].equals(obitainedResult[56]);
//            expectedResult[61].equals(obitainedResult[61]);
//            expectedResult[62].equals(obitainedResult[62]);
//            expectedResult[63].equals(obitainedResult[63]);
//            expectedResult[64].equals(obitainedResult[64]);
//            expectedResult[65].equals(obitainedResult[65]);
//            expectedResult[66].equals(obitainedResult[66]);
//            expectedResult[71].equals(obitainedResult[71]);
//            expectedResult[72].equals(obitainedResult[72]);
//            expectedResult[73].equals(obitainedResult[73]);
//            expectedResult[78].equals(obitainedResult[79]);

    }





   //   System.out.println(jsonAsString);










      //  r.body("volumes[0]",equalToObject(arrivalDay),
      //          "volumes[1]", equalTo((totalWeight)),
      //          "volumes[2]", equalTo(splitWeight));


        //    ResponseBody body = r.getBody();

      //  RestAssured.baseURI = url;
   //     RequestSpecification httpRequest = RestAssured.given();
      //  Response response = httpRequest.get("id");

   ////   String id = jsonPathEvaluator.get("id");
     //   System.out.println("City received from Response " + id );

     //   System.out.println(response.toString());

    //           List<String> rideStates = r.path("arrivalDay");
 //jsonAsString = r.asString();
 //  ArrayList<Map<String,?>> jsonAsArrayList = from(jsonAsString).get("id");
   //  assertThat(jsonAsArrayList.size(), equalTo(3));

    @Test
    @SuppressWarnings("unchecked")
    public void createBatchSuccessAllDaysOfWeek() {
      //  String r =

          given()
                 .relaxedHTTPSValidation()
                 .header("x-application-key", applicationKey)
                 .contentType("application/json")
                 .header("Authorization", bearer)
                 .body(createBatchRestAllDaysOfWeek)
                 .when()
                 .post(url)
                 .then().log().all();
              //   .then().extract().path("id").toString();
      //  System.out.println(r);
        //      Approvals.verify(responseSpecification.body(Matchers.containsString("")));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void createBatchSuccessNoCustomization() {
        //  String r =

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(createBatchNoCustomization)
                .when()
                .post(url)
                .then().log().all();
        //   .then().extract().path("id").toString();
        //  System.out.println(r);
        //      Approvals.verify(responseSpecification.body(Matchers.containsString("")));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void createBatchWrongDate() {


       // Response r =
        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(createBachWrongDate)
                .when()
                .post(url)
                .then().log().all();
              // .then().assertThat().body("message", equalTo("Foram informados dias de coleta inválidos. Favor informar todos os dias e somente datas futuras.")).log().all();


    }

    @Test
    @SuppressWarnings("unchecked")
    public void createBatchNoTraderCode() {

        String expectedResult = "O campo trader deve ser informado.";

       given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(createBatchNoTraderCode)
                .when()
                .post(url)
                .then().assertThat().body("fields.message[0]",Matchers.containsString(expectedResult)).log().all();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void createBatchSameDeliveryDates() {

        String expectedResult = "";

        given()
                .relaxedHTTPSValidation()
                .header("x-application-key", applicationKey)
                .contentType("application/json")
                .header("Authorization", bearer)
                .body(createBatchSameDeliveryDates)
                .when()
                .post(url)
                .then().assertThat().body("volumes.arrivalDay[0]", equalTo("2021-06-07")).log().all();
    }




}