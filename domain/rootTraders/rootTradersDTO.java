package api.domain.rootTraders;

public class rootTradersDTO {

    private int id;
    private String name;
    private int parent_trader_id;
    private String external_id;
    private String document_number;

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getDocumentNumber() {
        return document_number;
    }

    public void setDocumentNumber(String cnpj) {
        this.document_number = document_number;
    }

    public int getParent_trader_id() {
        return parent_trader_id;
    }

    public void setParent_trader_id(int parent_trader_id) {
        this.parent_trader_id = parent_trader_id;
    }

}
