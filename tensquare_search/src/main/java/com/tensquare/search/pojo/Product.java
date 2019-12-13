package com.tensquare.search.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * 文章搜索
 *
 * @ Author        :  huqingsong
 * @ CreateDate    :  2019-09-18 16:03
 */
@Document(indexName = "shop-good-renli-10001", type = "product")
public class Product implements Serializable {

    private Integer basisPrice;

    private String colid;

    private String eName;

    private String firstUpDate;

    private Integer gysId;

    private String gysName;

    private Integer hId;

    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String hName;

    @Id
    private String id;

    private String img;

    private String mCid;

    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String mCname;


    private String ops;

    private Integer parentPlanId;

    private Integer planId;

    private Integer plat;

    private Integer price;

    private Integer sales;

    public Integer getBasisPrice() {
        return basisPrice;
    }

    public void setBasisPrice(Integer basisPrice) {
        this.basisPrice = basisPrice;
    }

    public String getColid() {
        return colid;
    }

    public void setColid(String colid) {
        this.colid = colid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getFirstUpDate() {
        return firstUpDate;
    }

    public void setFirstUpDate(String firstUpDate) {
        this.firstUpDate = firstUpDate;
    }

    public Integer getGysId() {
        return gysId;
    }

    public void setGysId(Integer gysId) {
        this.gysId = gysId;
    }

    public String getGysName() {
        return gysName;
    }

    public void setGysName(String gysName) {
        this.gysName = gysName;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getmCid() {
        return mCid;
    }

    public void setmCid(String mCid) {
        this.mCid = mCid;
    }

    public String getmCname() {
        return mCname;
    }

    public void setmCname(String mCname) {
        this.mCname = mCname;
    }

    public String getOps() {
        return ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public Integer getParentPlanId() {
        return parentPlanId;
    }

    public void setParentPlanId(Integer parentPlanId) {
        this.parentPlanId = parentPlanId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getPlat() {
        return plat;
    }

    public void setPlat(Integer plat) {
        this.plat = plat;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
