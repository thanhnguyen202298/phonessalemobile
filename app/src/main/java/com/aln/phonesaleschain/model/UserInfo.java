package com.aln.phonesaleschain.model;

import com.google.gson.annotations.SerializedName;

public class UserInfo
{
    @SerializedName("UserID")
    public String UserID;
    @SerializedName("UserName")
    public String sms;
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

    public String password;

    public boolean isAdmin() {
        return GroupID == 1;

    }
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    private boolean isAdmin;

    public UserInfo(String userID, String sms, int groupID, String groupName, String employeeCode, String employeeName, String divisionName) {
        UserID = userID;
        this.sms = sms;
        GroupID = groupID;
        GroupName = groupName;
        EmployeeCode = employeeCode;
        EmployeeName = employeeName;
        DivisionName = divisionName;
    }

    public UserInfo() {
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
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

    @Override
    public String toString() {
        return "DataResultLogin{" +
                "UserID='" + UserID + '\'' +
                ", sms='" + sms + '\'' +
                ", GroupID='" + GroupID + '\'' +
                ", GroupName='" + GroupName + '\'' +
                ", EmployeeCode='" + EmployeeCode + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", DivisionName='" + DivisionName + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
