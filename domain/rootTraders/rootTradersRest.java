package api.domain.rootTraders;

import api.base.BaseRest;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.*;

import static io.restassured.RestAssured.given;

public class rootTradersRest extends BaseRest {

    String url = enviroment + "/integra-rodo-entidades/v1/traders/parent";
    String bearer = getBearer();


    public Response extractRootTradersList(){

        Response response =

          given()
                .header("x-application-key",applicationKey)
                .contentType("application/json")
                .header("authorization",bearer)

          .when()
                .queryParam("size",100)
                .queryParam("sort","name")
                .get(url)

          .then()
                .statusCode(200)
                .extract().response();

        return response;
    }

    @Test
    public void checkRootTradersList() throws SQLException, ClassNotFoundException {

        Response seaportList = extractRootTradersList();
        rootTradersSQL sql = new rootTradersSQL();
        List<rootTradersDTO> restList = new ArrayList<rootTradersDTO>();
        List<rootTradersDTO> sqlList = sql.getRootTradersList();
        int index = 0;
        for(index = 0; index<seaportList.jsonPath().getList("content.name").size();index++){
            rootTradersDTO rootTrader = new rootTradersDTO();
            int id = seaportList.jsonPath().getInt("content["+index+"].id");
            rootTrader.setId(id);
            String name = seaportList.jsonPath().getString("content["+index+"].name");
            rootTrader.setName(name);
            String external_id = seaportList.jsonPath().getString("content["+index+"].externalId");
            rootTrader.setExternal_id(external_id);
            String document_number = seaportList.jsonPath().getString("content["+index+"].documentNumber");
            rootTrader.setDocumentNumber(document_number);
            restList.add(index,rootTrader);

        }
        Collections.sort(restList, Comparator.comparing(rootTradersDTO::getName));
        int temp = 0;
        for(temp=0;temp<restList.size();temp++){
            System.out.println("RestList:"+restList.get(temp).getName()+",");


        }
        for(temp=0;temp<restList.size();temp++){
            System.out.println("sqlList:"+sqlList.get(temp).getName()+",");


        }
        Assert.assertEquals(restList,sqlList);

    }

}
