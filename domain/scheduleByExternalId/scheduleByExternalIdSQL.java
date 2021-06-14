package api.domain.scheduleByExternalId;

import api.base.BaseSQL;
import api.domain.traders.TradersSQL;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class scheduleByExternalIdSQL extends BaseSQL {

    public String getScheduleDetailExternalId() throws SQLException, ClassNotFoundException {
        ResultSet rs = executeQuery("select * from schedule_external_reference where system = 'SIACON_VIAGEM'  and schedule_id in \n" +
                "(select id from truck_driver_schedule where composition_length notnull) order by id desc limit 1");
        rs.next();
        String external_id = rs.getString("external_id");
        return external_id;

    }


    @Test
    public scheduleByExternalIdDTO getScheduleDetail(String external_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = executeQuery("select * from truck_driver_schedule tds where id in (select schedule_id from schedule_external_reference ser where external_id = '"+external_id+"' )");
        scheduleByExternalIdDTO scheduleDetail = new scheduleByExternalIdDTO();
        rs.next();
        scheduleDetail.setExternalId(external_id);
        scheduleDetail.setTraderNameById(rs.getInt("trader_id"));
        scheduleDetail.setShippingCompanyNameById(rs.getInt("shipping_company_id"));
        scheduleDetail.setProductNameById(rs.getInt("product_id"));
        scheduleDetail.setProductNameById(rs.getInt("product_id"));
        //Criando Novos métodos no DTO do ScheduleDetail para ser possível setar as informações usando o ID

      /*


        scheduleDetail.setTerminalName(response.jsonPath().getString("terminalName"));
        scheduleDetail.setSeaportName(response.jsonPath().getString("seaportName"));
        scheduleDetail.setTruckDriverName(response.jsonPath().getString("truckDriverName"));
        scheduleDetail.setTruckDriverCpf(response.jsonPath().getString("truckDriverCpf"));
        scheduleDetail.setTruckPlateNumber(response.jsonPath().getString("truckPlateNumber"));
        scheduleDetail.setCompositionLength(response.jsonPath().getInt("compositionLength"));
        scheduleDetail.setScheduledAt(response.jsonPath().getString("scheduledAt"));*/

        return scheduleDetail;


    }


}
