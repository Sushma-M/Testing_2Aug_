/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.db123testing;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class UtableCompositesId implements Serializable {

    private String id;
    private String companyId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtableComposites)) return false;
        final UtableComposites utableComposites = (UtableComposites) o;
        return Objects.equals(getId(), utableComposites.getId()) &&
                Objects.equals(getCompanyId(), utableComposites.getCompanyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getCompanyId());
    }
}