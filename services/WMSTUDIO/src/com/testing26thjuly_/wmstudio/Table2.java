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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Table2 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE2`", schema = "SARASWATHI")
public class Table2 implements Serializable {

    private long id;
    private String firmnumber;
    private String email;
    private String note;
    private String filterStatements;
    private char autoSend;
    private Table2 table2ByMergeFirmId;
    private List<Table2> table2sForMergeFirmId = new ArrayList<>();

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 18)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "`FIRMNUMBER`", nullable = false, length = 20)
    public String getFirmnumber() {
        return this.firmnumber;
    }

    public void setFirmnumber(String firmnumber) {
        this.firmnumber = firmnumber;
    }

    @Column(name = "`EMAIL`", nullable = true, length = 20)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`NOTE`", nullable = true, length = 20)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "`FILTER_STATEMENTS`", nullable = true, length = 20)
    public String getFilterStatements() {
        return this.filterStatements;
    }

    public void setFilterStatements(String filterStatements) {
        this.filterStatements = filterStatements;
    }

    @Column(name = "`AUTO_SEND`", nullable = false, length = 1)
    public char getAutoSend() {
        return this.autoSend;
    }

    public void setAutoSend(char autoSend) {
        this.autoSend = autoSend;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"table2ByMergeFirmId", "table2sForMergeFirmId"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`MERGE_FIRM_ID`", referencedColumnName = "`ID`", insertable = true, updatable = true)
    public Table2 getTable2ByMergeFirmId() {
        return this.table2ByMergeFirmId;
    }

    public void setTable2ByMergeFirmId(Table2 table2ByMergeFirmId) {
        this.table2ByMergeFirmId = table2ByMergeFirmId;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"table2ByMergeFirmId", "table2sForMergeFirmId"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "table2ByMergeFirmId")
    public List<Table2> getTable2sForMergeFirmId() {
        return this.table2sForMergeFirmId;
    }

    public void setTable2sForMergeFirmId(List<Table2> table2sForMergeFirmId) {
        this.table2sForMergeFirmId = table2sForMergeFirmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table2)) return false;
        final Table2 table2 = (Table2) o;
        return Objects.equals(getId(), table2.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
