package eis.model;

import jakarta.persistence.*;

/*企业信息实体类*/

@Table(name = "enterprise") //SQL中以enterprise为表名
@Entity
public class Enterprise {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*字段映射,可扩展新的字段
    * 必须符合数据库的下划线命名
    * 到JAVA的小驼峰命名的对应关系*/

    @Column(name = "name")
    private String name;

    @Column(name = "registered_address")
    private String registeredAddress;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private String date;

    @Column(name = "year")
    private String year;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "industry")
    private String industry;

    @Column(name = "insured_division")
    private String insuredDivision;

    @Column(name = "registered_capital")
    private String registeredCapital;

    @Column(name = "capital_division")
    private String captitalDivision;

    @Column(name = "status")
    private String status;

    @Column(name = "former_name")
    private String formerName;

    @Column(name = "communication_address")
    private String communicationAddress;

    @Column(name = "tax_payer_id")
    private String taxPayerId;

    @Column(name = "registeration_id")
    private String registerationId;

    @Column(name = "organization_id")
    private String organizationId;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "business_scope")
    private String businessScope;

    @Column(name = "listed_or_not")
    private String listedOrNot;

    @Column(name = "listing_type")
    private String listingType;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "products")
    private String products;

    // 无参构造函数
    public Enterprise() {
    }

    // 全参构造函数
    public Enterprise(Long id, String name, String registeredAddress, String type, String date, String year, String province,
                      String city, String district, String industry, String insuredDivision, String registeredCapital,
                      String captitalDivision, String status, String formerName, String communicationAddress, String taxPayerId,
                      String registerationId, String organizationId, String introduction, String businessScope, String listedOrNot,
                      String listingType, String abbreviation, String stockCode, String products) {
        this.id = id;
        this.name = name;
        this.registeredAddress = registeredAddress;
        this.type = type;
        this.date = date;
        this.year = year;
        this.province = province;
        this.city = city;
        this.district = district;
        this.industry = industry;
        this.insuredDivision = insuredDivision;
        this.registeredCapital = registeredCapital;
        this.captitalDivision = captitalDivision;
        this.status = status;
        this.formerName = formerName;
        this.communicationAddress = communicationAddress;
        this.taxPayerId = taxPayerId;
        this.registerationId = registerationId;
        this.organizationId = organizationId;
        this.introduction = introduction;
        this.businessScope = businessScope;
        this.listedOrNot = listedOrNot;
        this.listingType = listingType;
        this.abbreviation = abbreviation;
        this.stockCode = stockCode;
        this.products = products;
    }

    // Getters 和 Setters,供模板调用

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getInsuredDivision() {
        return insuredDivision;
    }

    public void setInsuredDivision(String insuredDivision) {
        this.insuredDivision = insuredDivision;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getCaptitalDivision() {
        return captitalDivision;
    }

    public void setCaptitalDivision(String captitalDivision) {
        this.captitalDivision = captitalDivision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getCommunicationAddress() {
        return communicationAddress;
    }

    public void setCommunicationAddress(String communicationAddress) {
        this.communicationAddress = communicationAddress;
    }

    public String getTaxPayerId() {
        return taxPayerId;
    }

    public void setTaxPayerId(String taxpayerID) {
        this.taxPayerId = taxpayerID;
    }

    public String getRegisterationId() {
        return registerationId;
    }

    public void setRegisterationId(String registerationID) {
        this.registerationId = registerationID;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationID) {
        this.organizationId = organizationID;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getListedOrNot() {
        return listedOrNot;
    }

    public void setListedOrNot(String listedOrNot) {
        this.listedOrNot = listedOrNot;
    }

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}



