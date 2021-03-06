/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.demo;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class ViewTable1Id implements Serializable {

    private int id;
    private Byte column2;
    private String column3;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getColumn2() {
        return this.column2;
    }

    public void setColumn2(Byte column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViewTable1)) return false;
        final ViewTable1 viewTable1 = (ViewTable1) o;
        return Objects.equals(getId(), viewTable1.getId()) &&
                Objects.equals(getColumn2(), viewTable1.getColumn2()) &&
                Objects.equals(getColumn3(), viewTable1.getColumn3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getColumn2(),
                getColumn3());
    }
}
