package api.domain.rootTraders;

import api.base.BaseSQL;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rootTradersSQL extends BaseSQL {


    public List<rootTradersDTO> getRootTradersList() throws SQLException, ClassNotFoundException {

        ResultSet rs = executeQuery("select rt.id,rt.name,parent_trader_id, tr.external_id,tr.document_number from root_trader rt \n" +
                "left join trader tr ON rt.parent_trader_id = tr.id \n" +
                "where rt.parent_trader_id is not null order by rt.name;");
        List<rootTradersDTO> list = new ArrayList<rootTradersDTO>();
        int index = 0;
        while (rs.next()) {

            rootTradersDTO seaports = new rootTradersDTO();
            seaports.setId(rs.getInt("id"));
            seaports.setDocumentNumber(rs.getString("document_number"));
            seaports.setName(rs.getString("name"));
            seaports.setExternal_id(rs.getString("external_id"));
            seaports.setParent_trader_id(rs.getInt("parent_trader_id"));
            list.add(index, seaports);
            index++;

        }

        return list;

    }
}
