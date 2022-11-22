package com.ta.operations.model;

public class DBModel {

	private String agentCode;
	private String agentName;
	private String workArea;
	private String phoneNumber;
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

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public DBModel() {

	}

	public DBModel(String agentCode, String agentName, String workArea, String phoneNumber,String country) {
		this.agentCode = agentCode;
		this.agentName = agentName;
		this.workArea = workArea;
		this.phoneNumber = phoneNumber;
		this.country = country;
	}

//	public DBModel(String agentCode, String agentName, String phoneNumber) {
//		this.agentCode = agentCode;
//		this.agentName = agentName;
//		this.phoneNumber = phoneNumber;
//	}

	@Override
	public String toString() {
		return "DBModel [AgentCode=" + agentCode + ", AgentName=" + agentName + ", WorkArea=" + workArea
				+ ", PhoneNumber=" + phoneNumber + ", Country=" + country + "]";
	}

}