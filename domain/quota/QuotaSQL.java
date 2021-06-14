package api.domain.quota;


import api.base.BaseSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuotaSQL extends BaseSQL{
    public List<QuotaDTO> fillList(ResultSet rs) throws SQLException {

        int index = 0;
        List<QuotaDTO> list = new ArrayList<QuotaDTO>();
        while (rs.next()) {
            QuotaDTO quota = new QuotaDTO();
            quota.setId(rs.getInt("id"));
            quota.setCreated_at(rs.getTimestamp("created_at"));
            quota.setUpdated_at(rs.getTimestamp("updated_at"));
            quota.setArrival_at(rs.getTimestamp("arrival_at"));
            quota.setAvailability(rs.getString("availability"));
            quota.setTotal_amount(rs.getFloat("total_amount"));
            quota.setUsed_amount(rs.getFloat("used_amount"));
            quota.setProduct_id(rs.getInt("product_id"));
            quota.setSeaport_id(rs.getInt("seaport_id"));
            quota.setTerminal_id(rs.getInt("terminal_id"));
            quota.setTrader_id(rs.getInt("trader_id"));
            quota.setMovement_type(rs.getString("movement_type"));
            quota.setShipping_company_id(rs.getInt("shipping_company_id"));
            list.add(index,quota);
            index++;
        }
        return list;
    }


    //Retorna uma lista com as cotas para os atributos: TIA, TESTE TRATO, TPD, Soja_Trato, ordenada a partir do período mais recente
    public List<QuotaDTO> getQuotas() throws ClassNotFoundException, SQLException{
        ResultSet rs = executeQuery("SELECT * from quota where seaport_id = 1 " +
                "AND product_id = 110 " +
                "AND terminal_id = 1 " +
                "AND trader_id = 35 " +
                "ORDER BY arrival_at " +
                "DESC ");
        List<QuotaDTO> list = fillList(rs);
        return list;
    }
}
