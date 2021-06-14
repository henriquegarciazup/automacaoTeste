package api.domain.signedUsersSchedules;

import java.sql.Timestamp;

public class SignedUsersSchedulesDTO {
    private String terminal_code;
    private String plate_number;
    private String movement_type;
    private String trader;
    private String truck_driver;
    private String output_at;
    private String scheduled_at;
    private String status;

    public String getTerminal_code() {
        return terminal_code;
    }

    public void setTerminal_code(String terminal_code) {
        this.terminal_code = terminal_code;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public String getMovement_type() {
        return movement_type;
    }

    public void setMovement_type(String movement_type) {
        this.movement_type = movement_type;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getTruck_driver() {
        return truck_driver;
    }

    public void setTruck_driver(String truck_driver) {
        this.truck_driver = truck_driver;
    }

    public String getOutput_at() {
        return output_at;
    }

    public void setOutput_at(String output_at) {
        this.output_at = output_at;
    }

    public String getScheduled_at() {
        return scheduled_at;
    }

    public void setScheduled_at(String scheduled_at) {
        this.scheduled_at = scheduled_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
