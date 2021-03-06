/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Table37 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE37`", schema = "SARASWATHI")
public class Table37 implements Serializable {

    private int id;
    private Table10 table10;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`COLUMN2`", referencedColumnName = "`ID`", insertable = true, updatable = true)
    public Table10 getTable10() {
        return this.table10;
    }

    public void setTable10(Table10 table10) {
        this.table10 = table10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table37)) return false;
        final Table37 table37 = (Table37) o;
        return Objects.equals(getId(), table37.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

