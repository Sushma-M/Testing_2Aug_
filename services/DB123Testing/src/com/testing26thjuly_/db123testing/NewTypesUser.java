/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.db123testing;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * NewTypesUser generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`NewTypes_User`", schema = "dbo")
public class NewTypesUser implements Serializable {

    private int id;
    private Byte byteCol;
    private Short shortCol;
    private Double doubleCol;
    private BigInteger longCol;
    private BigInteger bigIntCol;
    private BigDecimal bigDecCol;
    private Float floatCol;
    private String stringCol;
    private Character charCol;
    private String textCol;
    private String clobCol;
    private Date dateCol;
    private Date timeCol;
    private Date timestampCol;
    private Boolean booleanCol;
    @JsonIgnore
    private byte[] blobCol;
    private Date datetimeCol;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "`Byte Col`", nullable = true, scale = 0, precision = 2)
    public Byte getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Byte byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`Short Col`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Column(name = "`Double Col`", nullable = true, scale = 8, precision = 18)
    public Double getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(Double doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Column(name = "`Long Col`", nullable = true, scale = 0, precision = 18)
    public BigInteger getLongCol() {
        return this.longCol;
    }

    public void setLongCol(BigInteger longCol) {
        this.longCol = longCol;
    }

    @Column(name = "`BigInt Col`", nullable = true, scale = 0, precision = 35)
    public BigInteger getBigIntCol() {
        return this.bigIntCol;
    }

    public void setBigIntCol(BigInteger bigIntCol) {
        this.bigIntCol = bigIntCol;
    }

    @Column(name = "`BigDec Col`", nullable = true, scale = 15, precision = 35)
    public BigDecimal getBigDecCol() {
        return this.bigDecCol;
    }

    public void setBigDecCol(BigDecimal bigDecCol) {
        this.bigDecCol = bigDecCol;
    }

    @Column(name = "`Float Col`", nullable = true, scale = 4, precision = 8)
    public Float getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Float floatCol) {
        this.floatCol = floatCol;
    }

    @Column(name = "`String Col`", nullable = true, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`Char Col`", nullable = true, length = 1)
    public Character getCharCol() {
        return this.charCol;
    }

    public void setCharCol(Character charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`Text Col`", nullable = true, length = 255)
    public String getTextCol() {
        return this.textCol;
    }

    public void setTextCol(String textCol) {
        this.textCol = textCol;
    }

    @Column(name = "`Clob Col`", nullable = true, length = 255)
    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`Date Col`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "`Time Col`", nullable = true)
    public Date getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Date timeCol) {
        this.timeCol = timeCol;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`Timestamp Col`", nullable = true)
    public Date getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Date timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Column(name = "`Boolean Col`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`Blob Col`", nullable = true)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`Datetime Col`", nullable = true)
    public Date getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(Date datetimeCol) {
        this.datetimeCol = datetimeCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewTypesUser)) return false;
        final NewTypesUser newTypesUser = (NewTypesUser) o;
        return Objects.equals(getId(), newTypesUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

