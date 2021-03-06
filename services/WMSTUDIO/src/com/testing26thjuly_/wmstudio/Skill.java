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

/**
 * Skill generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SKILL`", schema = "SARASWATHI")
public class Skill implements Serializable {

    private double id;
    private String code;
    private Double lastModifiedUserId;
    private List<CallRouting> callRoutings = new ArrayList<>();
    private CfgSkill cfgSkill;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 2, precision = 19)
    public double getId() {
        return this.id;
    }

    public void setId(double id) {
        this.id = id;
    }

    @Column(name = "`CODE`", nullable = true, length = 4)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "`LAST_MODIFIED_USER_ID`", nullable = true, scale = 2, precision = 19)
    public Double getLastModifiedUserId() {
        return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Double lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "skill")
    public List<CallRouting> getCallRoutings() {
        return this.callRoutings;
    }

    public void setCallRoutings(List<CallRouting> callRoutings) {
        this.callRoutings = callRoutings;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`CFG_SKILL_ID`", referencedColumnName = "`ID`", insertable = true, updatable = true)
    public CfgSkill getCfgSkill() {
        return this.cfgSkill;
    }

    public void setCfgSkill(CfgSkill cfgSkill) {
        this.cfgSkill = cfgSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        final Skill skill = (Skill) o;
        return Objects.equals(getId(), skill.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

