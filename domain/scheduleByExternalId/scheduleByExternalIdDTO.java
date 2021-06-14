package api.domain.scheduleByExternalId;

import api.base.BaseSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class scheduleByExternalIdDTO {
    private String externalId;
    private String traderName;
    private String shippingCompanyName;
    private String productName;
    private String terminalName;
    private String seaportName;
    private String truckDriverName;
    private String truckDriverCpf;
    private String truckPlateNumber;
    private double compositionLength;
    private String scheduledAt;




    public String getExternalId() {
        return externalId;
    }

    public String getTraderName() {
        return traderName;
    }

    public String getShippingCompanyName() {
        return shippingCompanyName;
    }

    public String getProductName() {
        return productName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public String getSeaportName() {
        return seaportName;
    }

    public String getTruckDriverName() {
        return truckDriverName;
    }

    public String getTruckDriverCpf() {
        return truckDriverCpf;
    }

    public String getTruckPlateNumber() {
        return truckPlateNumber;
    }

    public double getCompositionLength() {
        return compositionLength;
    }

    public String getScheduledAt() {
        return scheduledAt;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductNameById(int id) throws SQLException, ClassNotFoundException {
        BaseSQL sql = new BaseSQL();
        ResultSet rs = sql.executeQuery("select name from product where id = '"+id+"'");
        rs.next();
        String name = rs.getString("name");
        this.productName = name;


    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public void setTerminalNameById(int id) throws SQLException, ClassNotFoundException {
        BaseSQL sql = new BaseSQL();
        ResultSet rs = sql.executeQuery("select name from terminal where id = '"+id+"'");
        rs.next();
        String name = rs.getString("name");
        this.terminalName = name;


    }

    public void setSeaportName(String seaportName) {
        this.seaportName = seaportName;
    }

    public void setTruckDriverName(String truckDriverName) {
        this.truckDriverName = truckDriverName;
    }

    public void setTruckDriverCpf(String truckDriverCpf) {
        this.truckDriverCpf = truckDriverCpf;
    }

    public void setTruckPlateNumber(String truckPlateNumber) {
        this.truckPlateNumber = truckPlateNumber;
    }

    public void setCompositionLength(double compositionLength) {
        this.compositionLength = compositionLength;
    }

    public void setScheduledAt(String scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public void setTraderNameById(int id) throws SQLException, ClassNotFoundException {
        BaseSQL sql = new BaseSQL();
        ResultSet rs = sql.executeQuery("select name from trader where id = '"+id+"'");
        rs.next();
        String name = rs.getString("name");
        this.traderName = name;


    }

    public void setShippingCompanyName(String shippingCompanyName) {
        this.shippingCompanyName = shippingCompanyName;
    }

    public void setShippingCompanyNameById(int id) throws SQLException, ClassNotFoundException {
        BaseSQL sql = new BaseSQL();
        ResultSet rs = sql.executeQuery("select name from shipping_company where id = '"+id+"'");
        rs.next();
        String name = rs.getString("name");
        this.shippingCompanyName = name;


    }
}
