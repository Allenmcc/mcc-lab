package stringTest;

import lombok.Data;

import java.io.Serializable;

public class ProductVO implements Serializable {

    private Integer id;
    private String opportunityId;
    private Integer productId;
    private Integer family;
    private String familyName;
    private Integer line;
    private String lineName;
    private String series;
    private String seriesName;
    private Integer quantity;
    //品牌
    private String brand;
    //单位
    private String unit;
    private Double cost;
    //成本价格
    private Double price;
    //rl权限价格 用于计算维保
    private Double rlPrice;
    //权限价格
    private Double authPrice;
    private Double total;

    //名称
    private String name;
    //类别
    private Integer category;
    private String categoryName;
    //类型 软硬件
    private String type;
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getFamily() {
        return family;
    }

    public void setFamily(Integer family) {
        this.family = family;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRlPrice() {
        return rlPrice;
    }

    public void setRlPrice(Double rlPrice) {
        this.rlPrice = rlPrice;
    }

    public Double getAuthPrice() {
        return authPrice;
    }

    public void setAuthPrice(Double authPrice) {
        this.authPrice = authPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
