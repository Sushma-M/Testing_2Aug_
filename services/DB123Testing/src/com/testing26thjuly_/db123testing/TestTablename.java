/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.db123testing;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TestTablename generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Test_Tablename`", schema = "dbo")
public class TestTablename implements Serializable {

    private int id;
    private String stringCol;
    private Date dateCol;
    private Date timestampCol;
    private Date timeCol;
    private Boolean booleanCol;
    private Date datetimeCol;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "`String Col`", nullable = true, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`Date Col`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`Timestamp Col`", nullable = true)
    public Date getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Date timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "`Time Col`", nullable = true)
    public Date getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Date timeCol) {
        this.timeCol = timeCol;
    }

    @Column(name = "`Boolean Col`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
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
        if (!(o instanceof TestTablename)) return false;
        final TestTablename testTablename = (TestTablename) o;
        return Objects.equals(getId(), testTablename.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

