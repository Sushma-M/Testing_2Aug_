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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Urtable1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`URTABLE1`", schema = "dbo")
public class Urtable1 implements Serializable {

    private String id;
    private String company;
    private String contactName;
    private String address;
    private String city;
    private Urtable2 urtable2;

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "`ID`", nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "`Company`", nullable = false, length = 30)
    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    @Transient
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "urtable1")
    public Urtable2 getUrtable2() {
        return this.urtable2;
    }

    public void setUrtable2(Urtable2 urtable2) {
        this.urtable2 = urtable2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Urtable1)) return false;
        final Urtable1 urtable1 = (Urtable1) o;
        return Objects.equals(getId(), urtable1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

