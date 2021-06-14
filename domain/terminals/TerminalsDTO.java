package api.domain.terminals;
import java.sql.Timestamp;

public class TerminalsDTO {

    private int id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String external_id;
    private String name;
    private String terminal_code;
    private int trucks_capacity;
    private String warehouse_code;
    private int current_trucks_count_id;
    private String terminal_position;
    private String warehouse_position;
    private String warehouse_external_id;
    private String description;
    private String conditions;
    private int truck_max_size;
    private int truck_min_size;
    private int min_delay;
    private int max_delay;
    private String timezone;
    private String cnpj;


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

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerminal_code() {
        return terminal_code;
    }

    public void setTerminal_code(String terminal_code) {
        this.terminal_code = terminal_code;
    }

    public int getTrucks_capacity() {
        return trucks_capacity;
    }

    public void setTrucks_capacity(int trucks_capacity) {
        this.trucks_capacity = trucks_capacity;
    }

    public String getWarehouse_code() {
        return warehouse_code;
    }

    public void setWarehouse_code(String warehouse_code) {
        this.warehouse_code = warehouse_code;
    }

    public int getCurrent_trucks_count_id() {
        return current_trucks_count_id;
    }

    public void setCurrent_trucks_count_id(int current_trucks_count_id) {
        this.current_trucks_count_id = current_trucks_count_id;
    }

    public String getTerminal_position() {
        return terminal_position;
    }

    public void setTerminal_position(String terminal_position) {
        this.terminal_position = terminal_position;
    }

    public String getWarehouse_external_id() {
        return warehouse_external_id;
    }

    public void setWarehouse_external_id(String warehouse_external_id) {
        this.warehouse_external_id = warehouse_external_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getTruck_min_size() {
        return truck_min_size;
    }

    public void setTruck_min_size(int truck_min_size) {
        this.truck_min_size = truck_min_size;
    }

    public int getMin_delay() {
        return min_delay;
    }

    public void setMin_delay(int min_delay) {
        this.min_delay = min_delay;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getWarehouse_position() {
        return warehouse_position;
    }

    public void setWarehouse_position(String warehouse_position) {
        this.warehouse_position = warehouse_position;
    }

    public int getTruck_max_size() {
        return truck_max_size;
    }

    public void setTruck_max_size(int truck_max_size) {
        this.truck_max_size = truck_max_size;
    }

    public int getMax_delay() {
        return max_delay;
    }

    public void setMax_delay(int max_delay) {
        this.max_delay = max_delay;
    }
}
