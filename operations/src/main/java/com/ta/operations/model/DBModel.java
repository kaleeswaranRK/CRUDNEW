package com.ta.operations.model;

public class DBModel {

	private String agentCode;
	private String agentName;
	private String workingArea;
	private String phoneNo;
	private String country;

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getworkingArea() {
		return workingArea;
	}

	public void setworkingArea(String workingArea) {
		this.workingArea = workingArea;
	}

	public String getphoneNo() {
		return phoneNo;
	}

	public void setphoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public DBModel() {

	}

	public DBModel(String agentCode, String agentName, String workingArea, String phoneNo,String country) {
		this.agentCode = agentCode;
		this.agentName = agentName;
		this.workingArea = workingArea;
		this.phoneNo = phoneNo;
		this.country = country;
	}

//	public DBModel(String agentCode, String agentName, String phoneNo) {
//		this.agentCode = agentCode;
//		this.agentName = agentName;
//		this.phoneNo = phoneNo;
//	}

	@Override
	public String toString() {
		return "DBModel [AgentCode=" + agentCode + ", AgentName=" + agentName + ", workingArea=" + workingArea
				+ ", phoneNo=" + phoneNo + ", Country=" + country + "]";
	}

}