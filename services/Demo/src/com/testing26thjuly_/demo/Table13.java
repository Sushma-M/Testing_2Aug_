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
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Table13 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE13`")
@IdClass(Table14Id.class)
public class Table13 implements Serializable {

    private int id;
    private String column2;
    private String column3;
    private String column4;
    private Table14 table14;

    @Id
    @Column(name = "`ID`", nullable = false, insertable = false, updatable = false, scale = 0, precision = 10)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "`COLUMN2`", nullable = false, insertable = false, updatable = false, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Id
    @Column(name = "`COLUMN3`", nullable = false, insertable = false, updatable = false, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @PrimaryKeyJoinColumn
    @OneToOne(fetch = FetchType.EAGER)
    public Table14 getTable14() {
        return this.table14;
    }

    public void setTable14(Table14 table14) {
        this.id = table14.getId();
        this.column2 = table14.getColumn2();
        this.column3 = table14.getColumn3();

        this.table14 = table14;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table13)) return false;
        final Table13 table13 = (Table13) o;
        return Objects.equals(getId(), table13.getId()) &&
                Objects.equals(getColumn2(), table13.getColumn2()) &&
                Objects.equals(getColumn3(), table13.getColumn3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getColumn2(),
                getColumn3());
    }
}

