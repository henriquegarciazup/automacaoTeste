package api.domain.signedUsersSchedules;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;
import api.base.BaseRest;
import org.junit.jupiter.api.Assertions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SignedUsersSchedulesRest extends BaseRest {

    String url = enviroment + "/integra-rodo-entidades/v1/signed/user/schedules";
    String bearer = getBearer();

    public Response getResponse(){
        Response response =
                given()
                        .header("x-application-key", applicationKey)
                        .contentType("application/json")
                        .header("authorization", bearer)
                        .queryParam("size", 15)
                        .when()
                        .get(url)

                        .then()
                        .statusCode(200)

                        .extract()
                        .response();

        return response;




    }

    @Test
    @SuppressWarnings("unchecked")
    public void getSignedUsersSchedulesSuccess() throws SQLException, ClassNotFoundException {
        Response response = getResponse();
        ArrayList<SignedUsersSchedulesDTO> restList = new ArrayList<SignedUsersSchedulesDTO>();
        int index = 0;
        while (index < response.jsonPath().getList("content.id").size()) {
            SignedUsersSchedulesDTO signedUsersSchedules = new SignedUsersSchedulesDTO();
            signedUsersSchedules.setTerminal_code(response.jsonPath().getString("content["+index+"].terminalCode"));
            signedUsersSchedules.setPlate_number(response.jsonPath().getString("content["+index+"].plateNumber"));
            signedUsersSchedules.setMovement_type(response.jsonPath().getString("content["+index+"].movementType"));
            signedUsersSchedules.setTrader(response.jsonPath().getString("content["+index+"].traderName"));
            signedUsersSchedules.setTruck_driver(response.jsonPath().getString("content["+index+"].truckDriverName"));
            //signedUsersSchedules.setOutput_at(response.jsonPath().getString("content["+index+"].outputAt"));
            //signedUsersSchedules.setScheduled_at(response.jsonPath().getString("content["+index+"].scheduledAt"));
            signedUsersSchedules.setStatus(response.jsonPath().getString("content["+index+"].status"));

            restList.add(index, signedUsersSchedules);
            index++;
        }

        //Só pra garantir que as informações do REST estão dentro do restList
        for (int i = 0; i < restList.size(); i++) {
            System.out.println("--------------REST--------------");
            System.out.println(restList.get(i).getTerminal_code());
            System.out.println(restList.get(i).getPlate_number());
            System.out.println(restList.get(i).getMovement_type());
            System.out.println(restList.get(i).getTrader());
            System.out.println(restList.get(i).getTruck_driver());
            //System.out.println(restList.get(i).getOutput_at());
            //System.out.println(restList.get(i).getScheduled_at());
            System.out.println(restList.get(i).getStatus());
        }

        //Só pra garantir que as informações da consulta SQL estão dentro do sqlList
        SignedUsersSchedulesSQL signedUsersSchedulesSQL = new SignedUsersSchedulesSQL();
        List<SignedUsersSchedulesDTO> sqlList = signedUsersSchedulesSQL.getSignedUsersSchedules();
        for (int i = 0; i < sqlList.size(); i++) {
            System.out.println("--------------SQL--------------");
            System.out.println(sqlList.get(i).getTerminal_code());
            System.out.println(sqlList.get(i).getPlate_number());
            System.out.println(sqlList.get(i).getMovement_type());
            System.out.println(sqlList.get(i).getTrader());
            System.out.println(sqlList.get(i).getTruck_driver());
            //System.out.println(sqlList.get(i).getOutput_at());
            //System.out.println(sqlList.get(i).getScheduled_at());
            System.out.println(sqlList.get(i).getStatus());
        }

        //Fazer a lógica de comaparação das listas
        for (int i = 0; i < restList.size(); i++) {
            if ((restList.get(i).getTerminal_code().equals(sqlList.get(i).getTerminal_code()))
            && (restList.get(i).getPlate_number().equals(sqlList.get(i).getPlate_number()))
            && (restList.get(i).getMovement_type().equals(sqlList.get(i).getMovement_type()))
            //&& (restList.get(i).getTrader().equals(sqlList.get(i).getTrader()))
            && (restList.get(i).getTruck_driver().equals(sqlList.get(i).getTruck_driver()))
            //&& (restList.get(i).getOutput_at().equals(sqlList.get(i).getOutput_at()))
            //&& (restList.get(i).getScheduled_at().equals(sqlList.get(i).getScheduled_at()))
            && (restList.get(i).getStatus().equals(sqlList.get(i).getStatus()))){
                System.out.println("-----------------------------------------------------");
                System.out.println("Registro "+(i+1)+", REST e SQL para esse registro estão iguais!");
            } else {
                System.out.println("-----------------------------------------------------");
                System.out.println("Registro "+(i+1)+", REST e SQL com divergência!");
            }
        }

    }



    //@Test
    @SuppressWarnings("unchecked")
    public void getSignedUsersSchedulesUnauthorized() {
        Response response =
                given()
                        .header("X-Application-Key", applicationKey)
                        .contentType("application/json")
                        //para retornar 401, o bearer token deve ser expirado
                        //ou nem passado no request
                        //.header("authorization", bearer)
                        .queryParam("size", 15)
                        .when()
                        .get(url)

                        .then()
                        .statusCode(401)
                        .contentType(ContentType.JSON)
                        .body("error", equalTo("Unauthorized"))
                        .body("message", equalTo("Credentials must be provided"))
                        .extract()
                        .response();
        }


    //Checa se o serviço retornou o total correto de páginas para o front
    @Test
    public void compareTotalPages() throws SQLException, ClassNotFoundException {
         SignedUsersSchedulesSQL sql = new SignedUsersSchedulesSQL();
            Response response = getResponse();
            double totalPages = Double.parseDouble(response.jsonPath().getString("totalPages"));
            double totalElements = Double.parseDouble(response.jsonPath().getString("totalElements"));
            totalPages = Math.round(totalPages);
            totalElements = Math.ceil((totalElements/15));
         Assertions.assertEquals(totalPages,totalElements);

        }

    //Checa se o serviço retornou o total correto de agendamentos
    @Test
    public void compareTotalSchedules() throws SQLException, ClassNotFoundException {
        SignedUsersSchedulesSQL sql = new SignedUsersSchedulesSQL();
        int total = sql.getTotalSchedules();
        Response response = getResponse();
        int totalElements = Integer.parseInt(response.jsonPath().getString("totalElements"));
        Assertions.assertEquals(total,totalElements);
    }

}
