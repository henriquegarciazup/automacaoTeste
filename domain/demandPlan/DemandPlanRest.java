package api.domain.demandPlan;

import api.base.BaseRest;
import io.restassured.response.Response;
import org.joda.time.LocalDate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DemandPlanRest extends BaseRest {

    String urlList = enviroment +"/trato-demand-plan/v1/demands";
    //String urlCreateDemand = stg +"";
    String bearer = getBearer();


    @Test
    public void getDemandList() {

        given()
                .relaxedHTTPSValidation()
                .param("gw-app-key", applicationKey)
//                .param("X-Application-Key", applicationKey)
     //           .header("X-Application-Key", applicationKey)
                .contentType("application/json")
                .header("Authorization",bearer)
                .log().all()
                .when()
                .get(urlList)

                .then()
                .statusCode(200);
    }

    @Test
    public void getDemandListNoAuthentication() {

        given()
                .header("X-Application-Key",applicationKey)
                .contentType("application/json")

                .when()
                .get(urlList)

                .then()
                .statusCode(401)
                .extract().response();

    }

    @Test
    public void setNewDemand() {

        JSONObject payload = new JSONObject();
        JSONArray volume = new JSONArray();

        volume = setVolumeInterval();

        payload.put("product", "66");
        payload.put("terminal","1");
        payload.put("origin", "1");
        payload.put("trader", "159");
        payload.put("volumes",volume);


                given()
                .relaxedHTTPSValidation()
                .queryParam("gw-app-key", applicationKey)
                .contentType("application/json")
                .header("authorization",bearer)
                .body(payload)
                .log().all()
                .when().post(urlList)
                .then()
                .statusCode(200)
                .extract().response();

    }


    public JSONArray setVolumeInterval(){

        LocalDate dateTemp = new LocalDate();
        JSONArray volumeList = new JSONArray();
        int volumeByDay = 0,i=0;

        while(i<=6){
            JSONObject dateVolume = new JSONObject();
            dateTemp = LocalDate.now().plusDays(i);
            String date = dateTemp.toString();
            volumeByDay = i * 100;
            dateVolume.put("arrivalDay", date.toString());
            dateVolume.put("totalWeight",String.valueOf(volumeByDay));
            volumeList.add(i,dateVolume);
            i++;
        }
        return volumeList;
    }
}
