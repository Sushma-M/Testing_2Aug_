/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.testingdb123;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table7 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE7`")
public class Table7 implements Serializable {

    private long id;
    private String column2;
    private String column4;
    private Long column3;
    private Integer column5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 20)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @Column(name = "`COLUMN3`", nullable = true, scale = 0, precision = 20)
    public Long getColumn3() {
        return this.column3;
    }

    public void setColumn3(Long column3) {
        this.column3 = column3;
    }

    @Column(name = "`COLUMN5`", nullable = true, scale = 0, precision = 10)
    public Integer getColumn5() {
        return this.column5;
    }

    public void setColumn5(Integer column5) {
        this.column5 = column5;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table7)) return false;
        final Table7 table7 = (Table7) o;
        return Objects.equals(getId(), table7.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
