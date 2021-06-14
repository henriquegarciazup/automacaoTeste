package api.domain.terminals;

import api.base.BaseSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TerminalsSQL extends BaseSQL {
    public List<TerminalsDTO> fillList(ResultSet rs) throws SQLException {

        int index = 0;
        List<TerminalsDTO> list = new ArrayList<TerminalsDTO>();
        while (rs.next()) {
            TerminalsDTO terminal = new TerminalsDTO();
            terminal.setId(rs.getInt("id"));
            terminal.setCreated_at(rs.getTimestamp("created_at"));
            terminal.setUpdated_at(rs.getTimestamp("updated_at"));
            terminal.setExternal_id(rs.getString("external_id"));
            terminal.setName(rs.getString("name"));
            terminal.setTerminal_code(rs.getString("terminal_code"));
            terminal.setTrucks_capacity(rs.getInt("trucks_capacity"));
            terminal.setWarehouse_code(rs.getString("warehouse_code"));
            terminal.setCurrent_trucks_count_id(rs.getInt("current_trucks_count_id"));
            terminal.setTerminal_position(rs.getString("terminal_position"));
            terminal.setWarehouse_position(rs.getString("warehouse_position"));
            terminal.setWarehouse_external_id(rs.getString("warehouse_external_id"));
            terminal.setConditions(rs.getString("conditions"));
            terminal.setTruck_max_size(rs.getInt("truck_max_size"));
            terminal.setTruck_min_size(rs.getInt("truck_min_size"));
            terminal.setMin_delay(rs.getInt("min_delay"));
            terminal.setMin_delay(rs.getInt("min_delay"));
            terminal.setMax_delay(rs.getInt("max_delay"));
            terminal.setTimezone(rs.getString("timezone"));
            terminal.setCnpj(rs.getString("cnpj"));
            list.add(index,terminal);
            index++;
        }
        return list;
    }


    public List<String> getListActiveTerminals() throws ClassNotFoundException, SQLException {

        ResultSet rs = executeQuery("SELECT * FROM terminal where active = true");
        List<String> result = new ArrayList<String>();
        int index = 0;
        while(rs.next()) {
            String id = rs.getString("id");
            result.add(index,id);
            index++;
        }
        return result;

    }
}
