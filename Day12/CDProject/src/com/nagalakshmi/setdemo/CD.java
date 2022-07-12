package com.nagalakshmi.setdemo;

public class CD implements Comparable<CD> {

	private int versionId;
	private String cdName;
	private String cdAuthor;
	private double timeOfPlay;
	public CD(int versionId, String cdName, String cdAuthor, double timeOfPlay) {
		super();
		this.versionId = versionId;
		this.cdName = cdName;
		this.cdAuthor = cdAuthor;
		this.timeOfPlay = timeOfPlay;
	}
	public CD() {
		super();
	}
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public String getCdAuthor() {
		return cdAuthor;
	}
	public void setCdAuthor(String cdAuthor) {
		this.cdAuthor = cdAuthor;
	}
	public double getTimeOfPlay() {
		return timeOfPlay;
	}
	public void setTimeOfPlay(double timeOfPlay) {
		this.timeOfPlay = timeOfPlay;
	}
	@Override
	public String toString() {
		
		return "CD [CD ID="+versionId+", CD Name="+cdName
				+", authorName="+cdAuthor+",Length of CD(in min)="+timeOfPlay+"]";
	}
	@Override
	public int compareTo(CD cd2) {
		
		if(timeOfPlay>cd2.timeOfPlay)
			return 1;
		else if(timeOfPlay<cd2.timeOfPlay)
			return -1;
		else if(timeOfPlay==cd2.timeOfPlay && cdName.equals(cd2.cdName)
				&& cdAuthor.equals(cd2.cdAuthor) && versionId==cd2.versionId)
			return 0;
		else
			return -1;
	}
	
	
}
