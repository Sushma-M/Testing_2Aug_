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
 * CallRouting generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CALL_ROUTING`", schema = "SARASWATHI")
public class CallRouting implements Serializable {

    private double id;
    private double categoryId;
    private char categoryDefault;
    private String keyName;
    private double routingPointId;
    private String buId;
    private String description;
    private Double lastModifiedUserId;
    private Double vqCategoryId;
    private Skill skill;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 2, precision = 19)
    public double getId() {
        return this.id;
    }

    public void setId(double id) {
        this.id = id;
    }

    @Column(name = "`CATEGORY_ID`", nullable = false, scale = 2, precision = 19)
    public double getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(double categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "`CATEGORY_DEFAULT`", nullable = false, length = 1)
    public char getCategoryDefault() {
        return this.categoryDefault;
    }

    public void setCategoryDefault(char categoryDefault) {
        this.categoryDefault = categoryDefault;
    }

    @Column(name = "`KEY_NAME`", nullable = false, length = 200)
    public String getKeyName() {
        return this.keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Column(name = "`ROUTING_POINT_ID`", nullable = false, scale = 2, precision = 19)
    public double getRoutingPointId() {
        return this.routingPointId;
    }

    public void setRoutingPointId(double routingPointId) {
        this.routingPointId = routingPointId;
    }

    @Column(name = "`BU_ID`", nullable = false, length = 15)
    public String getBuId() {
        return this.buId;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }

    @Column(name = "`DESCRIPTION`", nullable = true, length = 1000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`LAST_MODIFIED_USER_ID`", nullable = true, scale = 2, precision = 19)
    public Double getLastModifiedUserId() {
        return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Double lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    @Column(name = "`VQ_CATEGORY_ID`", nullable = true, scale = 2, precision = 19)
    public Double getVqCategoryId() {
        return this.vqCategoryId;
    }

    public void setVqCategoryId(Double vqCategoryId) {
        this.vqCategoryId = vqCategoryId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SKILL_ID`", referencedColumnName = "`ID`", insertable = true, updatable = true)
    public Skill getSkill() {
        return this.skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CallRouting)) return false;
        final CallRouting callRouting = (CallRouting) o;
        return Objects.equals(getId(), callRouting.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

