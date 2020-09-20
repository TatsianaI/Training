package com.collection.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Currency {

    @JsonProperty(value = "Cur_Abbreviation")
    private String curAbbreviation;

    @JsonProperty(value = "Cur_ID")
    private Long curId;

    @JsonProperty(value = "Cur_Name")
    private String curName;

    @JsonProperty(value = "Cur_OfficialRate")
    private BigDecimal curOfficialRate;

    @JsonProperty(value = "Cur_Scale")
    private Integer curScale;

    @JsonProperty(value = "Date")
    private String date;

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public void setCurAbbreviation(String curAbbreviation) {
        this.curAbbreviation = curAbbreviation;
    }

    public Long getCurId() {
        return curId;
    }

    public void setCurId(Long curId) {
        this.curId = curId;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public BigDecimal getCurOfficialRate() {
        return curOfficialRate;
    }

    public void setCurOfficialRate(BigDecimal curOfficialRate) {
        this.curOfficialRate = curOfficialRate;
    }

    public Integer getCurScale() {
        return curScale;
    }

    public void setCurScale(Integer curScale) {
        this.curScale = curScale;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "curAbbreviation='" + curAbbreviation + '\'' +
                ", curId=" + curId +
                ", curName='" + curName + '\'' +
                ", curOfficialRate=" + curOfficialRate +
                ", curScale=" + curScale +
                ", date='" + date + '\'' +
                '}';
    }
}
