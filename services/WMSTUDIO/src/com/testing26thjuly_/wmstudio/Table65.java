/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Table65 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE65`", schema = "SARASWATHI")
@IdClass(Table65Id.class)
public class Table65 implements Serializable {

    private String stringCol;
    private int id;
    private short shortCol;
    private String column4;
    private List<Composite1> composite1s = new ArrayList<>();

    @Id
    @Column(name = "`StringCol`", nullable = false, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "`ShortCol`", nullable = false, scale = 0, precision = 4)
    public short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(short shortCol) {
        this.shortCol = shortCol;
    }

    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "table65")
    public List<Composite1> getComposite1s() {
        return this.composite1s;
    }

    public void setComposite1s(List<Composite1> composite1s) {
        this.composite1s = composite1s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table65)) return false;
        final Table65 table65 = (Table65) o;
        return Objects.equals(getStringCol(), table65.getStringCol()) &&
                Objects.equals(getId(), table65.getId()) &&
                Objects.equals(getShortCol(), table65.getShortCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStringCol(),
                getId(),
                getShortCol());
    }
}
