/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.testingdb123;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table55 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE55`")
public class Table55 implements Serializable {

    private long column2;
    private int id;
    private String column3;

    @Id
    @Column(name = "`COLUMN2`", nullable = false, scale = 0, precision = 20)
    public long getColumn2() {
        return this.column2;
    }

    public void setColumn2(long column2) {
        this.column2 = column2;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table55)) return false;
        final Table55 table55 = (Table55) o;
        return Objects.equals(getColumn2(), table55.getColumn2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn2());
    }
}

