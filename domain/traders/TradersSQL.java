package api.domain.traders;

import api.base.BaseSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TradersSQL extends BaseSQL {



    //Recebe um ResultSet da query SQL e extrai apenas o id de todas as traders associadas ao usuário
    public List<String> extractTradersId(ResultSet rs) throws SQLException{

        List<String> result = new ArrayList<String>();
        int index = 0;
        while(rs.next()) {
            String traderId = rs.getString("traders_id");
            result.add(index,traderId);
            index++;
        }
        return result;
    }


    public List<String> checkDataBaseTraders() throws ClassNotFoundException, SQLException {

        String trader_user_id = "246743";
        ResultSet rs = executeQuery("SELECT * FROM trader_user_traders where trader_user_id ="+trader_user_id);
        List<String> result = extractTradersId(rs);
        return result;

    }


}
