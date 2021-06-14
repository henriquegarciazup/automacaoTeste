package api.domain.quota;

import java.sql.Timestamp;

public class QuotaDTO {
    private int id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp arrival_at;
    private String availability;
    private float total_amount;
    private float used_amount;
    private int product_id;
    private int seaport_id;
    private int terminal_id;
    private int trader_id;
    private String movement_type;
    private int shipping_company_id;

    /*public QuotaDTO(int id, Timestamp created_at, Timestamp updated_at, Timestamp arrival_at, String availability, float total_amount, float used_amount, int product_id, int seaport_id, int terminal_id, int trader_id, String movement_type, int shipping_company_id) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.arrival_at = arrival_at;
        this.availability = availability;
        this.total_amount = total_amount;
        this.used_amount = used_amount;
        this.product_id = product_id;
        this.seaport_id = seaport_id;
        this.terminal_id = terminal_id;
        this.trader_id = trader_id;
        this.movement_type = movement_type;
        this.shipping_company_id = shipping_company_id;
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getArrival_at() {
        return arrival_at;
    }

    public void setArrival_at(Timestamp arrival_at) {
        this.arrival_at = arrival_at;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public float getUsed_amount() {
        return used_amount;
    }

    public void setUsed_amount(float used_amount) {
        this.used_amount = used_amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSeaport_id() {
        return seaport_id;
    }

    public void setSeaport_id(int seaport_id) {
        this.seaport_id = seaport_id;
    }

    public int getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(int terminal_id) {
        this.terminal_id = terminal_id;
    }

    public int getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(int trader_id) {
        this.trader_id = trader_id;
    }

    public String getMovement_type() {
        return movement_type;
    }

    public void setMovement_type(String movement_type) {
        this.movement_type = movement_type;
    }

    public int getShipping_company_id() {
        return shipping_company_id;
    }

    public void setShipping_company_id(int shipping_company_id) {
        this.shipping_company_id = shipping_company_id;
    }
}
