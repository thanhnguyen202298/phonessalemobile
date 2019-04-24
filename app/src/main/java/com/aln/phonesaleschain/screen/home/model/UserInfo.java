package com.aln.phonesaleschain.screen.home.model;

import com.google.gson.annotations.SerializedName;

public class UserInfo
{
    @SerializedName("UserID")
    public String UserID;
    @SerializedName("UserName")
    public String UserName;
    @SerializedName("Pass")
    public String Pass;
    @SerializedName("GroupID")
    public int GroupID;
    @SerializedName("GroupName")
    public String GroupName;
    @SerializedName("EmployeeCode")
    public String EmployeeCode;
    @SerializedName("EmployeeName")
    public String EmployeeName;
    @SerializedName("DivisionName")
    public String DivisionName;

    public boolean isAdmin() {
        return GroupID == 1;

    }
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    private boolean isAdmin;



    public UserInfo() {
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }


    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getDivisionName() {
        return DivisionName;
    }

    public void setDivisionName(String divisionName) {
        DivisionName = divisionName;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

}
