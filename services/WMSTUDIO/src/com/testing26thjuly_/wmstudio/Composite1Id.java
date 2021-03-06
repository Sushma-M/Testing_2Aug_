/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class Composite1Id implements Serializable {

    private String stringCol;
    private int id;
    private short shortCol;

    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(short shortCol) {
        this.shortCol = shortCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composite1)) return false;
        final Composite1 composite1 = (Composite1) o;
        return Objects.equals(getStringCol(), composite1.getStringCol()) &&
                Objects.equals(getId(), composite1.getId()) &&
                Objects.equals(getShortCol(), composite1.getShortCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStringCol(),
                getId(),
                getShortCol());
    }
}
