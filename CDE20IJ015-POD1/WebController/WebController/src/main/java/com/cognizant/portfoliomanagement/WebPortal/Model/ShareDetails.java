package com.cognizant.portfoliomanagement.WebPortal.Model;


public class ShareDetails {
	
	private String shareId;
	
	private String shareName;
	
	private double shareValue;

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public ShareDetails(String shareId, String shareName, double shareValue) {
		super();
		this.shareId = shareId;
		this.shareName = shareName;
		this.shareValue = shareValue;
	}

	public ShareDetails() {
		super();
	}

	@Override
	public String toString() {
		return "ShareDetails [shareId=" + shareId + ", shareName=" + shareName + ", shareValue=" + shareValue + "]";
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public double getShareValue() {
		return shareValue;
	}

	public void setShareValue(double shareValue) {
		this.shareValue = shareValue;
	}

}
