/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.db123testing;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class ViewUserId implements Serializable {

    private int userId;
    private String userName;
    private String password;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViewUser)) return false;
        final ViewUser viewUser = (ViewUser) o;
        return Objects.equals(getUserId(), viewUser.getUserId()) &&
                Objects.equals(getUserName(), viewUser.getUserName()) &&
                Objects.equals(getPassword(), viewUser.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(),
                getUserName(),
                getPassword());
    }
}
