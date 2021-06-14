package api.domain.signedUsersSchedules;

import api.base.BaseSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignedUsersSchedulesSQL extends BaseSQL {

    public List<SignedUsersSchedulesDTO> fillList(ResultSet rs) throws SQLException {
        int index = 0;
        ArrayList<SignedUsersSchedulesDTO> list = new ArrayList<SignedUsersSchedulesDTO>();
        while (rs.next()) {
            SignedUsersSchedulesDTO signedUsersSchedules = new SignedUsersSchedulesDTO();
            signedUsersSchedules.setTerminal_code(rs.getString("terminal_code"));
            signedUsersSchedules.setPlate_number(rs.getString("plate_number"));
            signedUsersSchedules.setMovement_type(rs.getString("movement_type"));
            signedUsersSchedules.setTrader(rs.getString("trader"));
            signedUsersSchedules.setTruck_driver(rs.getString("truck_driver"));
            signedUsersSchedules.setOutput_at(rs.getString("output_at"));
            signedUsersSchedules.setScheduled_at(rs.getString("scheduled_at"));
            signedUsersSchedules.setStatus(rs.getString("status"));

            list.add(index, signedUsersSchedules);
            index++;
        }
        return list;
    }


    //Retorna a lista com os 15 agendamentos mais recentes
    public List<SignedUsersSchedulesDTO> getSignedUsersSchedules() throws ClassNotFoundException, SQLException {
        ResultSet rs = executeQuery("select\n" +
                "\tte.terminal_code,\n" +
                "\ttru.plate_number, \n" +
                "\ttd.movement_type, \n" +
                "\tt.name as trader,\n" +
                "\ttb.name as truck_driver,\n" +
                "\ttd.output_at, \n" +
                "\ttd.scheduled_at,\n" +
                "\ttd.status \n" +
                "from\n" +
                "\ttruck_driver_schedule td\n" +
                "left join truck tru on\n" +
                "\t(td.truck_id = tru.id)\n" +
                "left join terminal te on\n" +
                "\t(te.id = td.terminal_id)\n" +
                "left join trader t on\n" +
                "\t(td.trader_id = t.id)\n" +
                "left join tb_user tb on\n" +
                "\t(td.truck_driver_id = tb.id and tb.id = tb.id)\n" +
                "order by\n" +
                "\ttd.created_at desc limit 15");
        ArrayList<SignedUsersSchedulesDTO> result = new ArrayList<SignedUsersSchedulesDTO>();
        int index = 0;
        while (rs.next()) {
            SignedUsersSchedulesDTO signedUsersSchedules = new SignedUsersSchedulesDTO();
            signedUsersSchedules.setTerminal_code(rs.getString("terminal_code"));
            signedUsersSchedules.setPlate_number(rs.getString("plate_number"));
            signedUsersSchedules.setMovement_type(rs.getString("movement_type"));
            signedUsersSchedules.setTrader(rs.getString("trader"));
            signedUsersSchedules.setTruck_driver(rs.getString("truck_driver"));
            //signedUsersSchedules.setOutput_at(rs.getString("output_at"));
            //signedUsersSchedules.setScheduled_at(rs.getString("scheduled_at"));
            signedUsersSchedules.setStatus(rs.getString("status"));

            result.add(index, signedUsersSchedules);
            index++;
        }
        return result;
    }

    public int getTotalSchedules() throws SQLException, ClassNotFoundException {
        ResultSet rs = executeQuery("select count(*) from truck_driver_schedule where (status <> 'ORDER_PENDING' and status<>'ORDER_ACTIVE')");
        String temp = new String();
            if(rs.next()) {
                temp = rs.getString(1);
            }
            return Integer.parseInt(temp);

    }


}
