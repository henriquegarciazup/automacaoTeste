package api.domain.demandPlan;

import java.sql.Timestamp;

public class DemandPlanDTO {

    private int id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp arrival_day;
    private int demand_volume_id;
    private int demand_volume_split_id;
    private int origin_id;
    private int product_id;
    private int trader_id;
    private int shipping_company_id;
    private int terminal_id;
    private int user_id;
    private int total_weight;
    private int split_weight;
    private int associated_weight;
    private String action;
    private String status;

    public int getId() {
        return id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Timestamp getArrival_day() {
        return arrival_day;
    }

    public int getDemand_volume_id() {
        return demand_volume_id;
    }

    public int getDemand_volume_split_id() {
        return demand_volume_split_id;
    }

    public int getOrigin_id() {
        return origin_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getTrader_id() {
        return trader_id;
    }

    public int getShipping_company_id() {
        return shipping_company_id;
    }

    public int getTerminal_id() {
        return terminal_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getTotal_weight() {
        return total_weight;
    }

    public int getSplit_weight() {
        return split_weight;
    }

    public int getAssociated_weight() {
        return associated_weight;
    }

    public String getAction() {
        return action;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setArrival_day(Timestamp arrival_day) {
        this.arrival_day = arrival_day;
    }

    public void setDemand_volume_id(int demand_volume_id) {
        this.demand_volume_id = demand_volume_id;
    }

    public void setDemand_volume_split_id(int demand_volume_split_id) {
        this.demand_volume_split_id = demand_volume_split_id;
    }

    public void setOrigin_id(int origin_id) {
        this.origin_id = origin_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setTrader_id(int trader_id) {
        this.trader_id = trader_id;
    }

    public void setShipping_company_id(int shipping_company_id) {
        this.shipping_company_id = shipping_company_id;
    }

    public void setTerminal_id(int terminal_id) {
        this.terminal_id = terminal_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTotal_weight(int total_weight) {
        this.total_weight = total_weight;
    }

    public void setSplit_weight(int split_weight) {
        this.split_weight = split_weight;
    }

    public void setAssociated_weight(int associated_weight) {
        this.associated_weight = associated_weight;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
