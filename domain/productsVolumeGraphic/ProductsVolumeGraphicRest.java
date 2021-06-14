//package test.java.tratoRest.satRest;
package api.domain.productsVolumeGraphic;

import static io.restassured.RestAssured.given;


import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;

import io.restassured.response.Response;
import api.base.BaseRest;
import org.junit.jupiter.api.Test;


public class ProductsVolumeGraphicRest extends BaseRest {


    String url = enviroment+"/integra-rodo-entidades/v1/dashboard/volume-products";
    String bearer = getBearer();



    public Response getProductsGraphic() {
        LocalDate startTemp = new LocalDate();
        LocalDate endTemp = new LocalDate();

        startTemp = LocalDate.now().minusDays(3);
        String start = startTemp.toString();

        endTemp = LocalDate.now().plusDays(3);
        String end = endTemp.toString();

        Response response =
                given()
                        .header("X-Application-Key",applicationKey)
                        .contentType("application/json")
                        .header("authorization",bearer)
                        .queryParam("start", start)
                        .queryParam("end", end)
                        .queryParam("searchByHour", "false")
                        .queryParam("gw-app-key", applicationKey)

                        .when()
                        .get(url)

                        .then()
                        .statusCode(200)
                        .extract().response();

        return response;



    }
    @Test
    public void checkDefaultDateRange() {
        LocalDate dateTemp = new LocalDate();



        Response response = getProductsGraphic();

        List<String> restList = new ArrayList<String>();
        restList = response.jsonPath().getList("graphic.data[1].period");
        int i;

        for(i=0; i<=3;i++) {
            dateTemp = LocalDate.now().minusDays(3-i);
            String date = dateTemp.toString();
            Assert.assertEquals(restList.get(i), date);


        }

        for(i=1; i<=3;i++) {
            dateTemp = LocalDate.now().plusDays(i);
            String date = dateTemp.toString();

            Assert.assertEquals(restList.get(3+i), date);

        }


    }

    public void getSoy() {
        Response response = getProductsGraphic();
        List<String> restList = new ArrayList<String>();
        restList = response.jsonPath().getList("graphic.label['SOY'].data.period");
        System.out.println(restList);

    }
}
