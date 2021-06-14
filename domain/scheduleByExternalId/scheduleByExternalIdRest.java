package api.domain.scheduleByExternalId;

import api.base.BaseRest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class scheduleByExternalIdRest extends BaseRest {

    String url = enviroment + "/integra-rodo-entidades/v1/schedules/external-id/";
    String bearer = getBearer();



    public Response getResponse(String external_id) {
        Response response =
                given()
                        .header("X-Application-Key", applicationKey)
                        .contentType("application/json")
                        .header("authorization",bearer)


                        .when()
                        .get(url + external_id)

                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();
        return response;
    }

    @Test
    public void checkScheduleDetail() throws SQLException, ClassNotFoundException, ParseException {

        scheduleByExternalIdSQL sql = new scheduleByExternalIdSQL();
        String externalId = sql.getScheduleDetailExternalId();
        Response response = getResponse(externalId);
        scheduleByExternalIdDTO scheduleDetail = new scheduleByExternalIdDTO();

        scheduleDetail.setExternalId(response.jsonPath().getString("externalId"));
        scheduleDetail.setTraderName(response.jsonPath().getString("traderName"));
        scheduleDetail.setShippingCompanyName(response.jsonPath().getString("shippingCompanyName"));
        scheduleDetail.setProductName(response.jsonPath().getString("productName"));
        scheduleDetail.setTerminalName(response.jsonPath().getString("terminalName"));
        scheduleDetail.setSeaportName(response.jsonPath().getString("seaportName"));
        scheduleDetail.setTruckDriverName(response.jsonPath().getString("truckDriverName"));
        scheduleDetail.setTruckDriverCpf(response.jsonPath().getString("truckDriverCpf"));
        scheduleDetail.setTruckPlateNumber(response.jsonPath().getString("truckPlateNumber"));
        scheduleDetail.setCompositionLength(response.jsonPath().getInt("compositionLength"));
        scheduleDetail.setScheduledAt(response.jsonPath().getString("scheduledAt"));
        sql.getScheduleDetail(scheduleDetail.getExternalId());


        /*System.out.println(scheduleDetail.getExternalId()+"\n");
        System.out.println(scheduleDetail.getTraderName()+"\n");
        System.out.println(scheduleDetail.getShippingCompanyName()+"\n");
        System.out.println(scheduleDetail.getProductName()+"\n");
        System.out.println(scheduleDetail.getTerminalName()+"\n");
        System.out.println(scheduleDetail.getSeaportName()+"\n");
        System.out.println(scheduleDetail.getTruckDriverName()+"\n");
        System.out.println(scheduleDetail.getTruckDriverCpf()+"\n");
        System.out.println(scheduleDetail.getTruckPlateNumber()+"\n");
        System.out.println(scheduleDetail.getCompositionLength()+"\n");
        System.out.println(scheduleDetail.getScheduledAt()+"\n");*/
        }





}
