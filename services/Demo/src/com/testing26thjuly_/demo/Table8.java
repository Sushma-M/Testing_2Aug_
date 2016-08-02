/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.demo;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Table8 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE8`")
public class Table8 implements Serializable {

    private int id;
    private String column3;
    private Table1 table1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`COLUMN2`", referencedColumnName = "`ID`", insertable = true, updatable = true)
    public Table1 getTable1() {
        return this.table1;
    }

    public void setTable1(Table1 table1) {
        this.table1 = table1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table8)) return false;
        final Table8 table8 = (Table8) o;
        return Objects.equals(getId(), table8.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
