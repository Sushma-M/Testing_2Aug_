/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.db123testing;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Urtable2 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`URTABLE2`", schema = "dbo")
public class Urtable2 implements Serializable {

    private String id;
    private String companyName;
    private String contactName;
    private String address;
    private String city;
    private Urtable1 urtable1;

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign", 
            parameters = @Parameter(name = "property", value = "urtable1"))
    @GeneratedValue(generator = "generator")
    @Column(name = "`ID`", nullable = false, insertable = false, updatable = false, length = 36)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "`CompanyName`", nullable = false, length = 30)
    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "`ContactName`", nullable = false, length = 60)
    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Column(name = "`Address`", nullable = false, length = 30)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "`City`", nullable = false, length = 30)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @PrimaryKeyJoinColumn
    @OneToOne(fetch = FetchType.EAGER)
    public Urtable1 getUrtable1() {
        return this.urtable1;
    }

    public void setUrtable1(Urtable1 urtable1) {
        this.urtable1 = urtable1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Urtable2)) return false;
        final Urtable2 urtable2 = (Urtable2) o;
        return Objects.equals(getId(), urtable2.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

