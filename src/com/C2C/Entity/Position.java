package com.C2C.Entity;

public class Position {

	private int idposition;
	private String positionName;
	private String firstWorld;
	private String range;
	private String secondWorld;

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getSecondWorld() {
		return secondWorld;
	}

	public void setSecondWorld(String secondWorld) {
		this.secondWorld = secondWorld;
	}

	public int getIdposition() {
		return idposition;
	}

	public void setIdposition(int idposition) {
		this.idposition = idposition;
	}

	public String getPositionName() {
		return positionName;
	}

	@Override
	public String toString() {
		return "Position [idposition=" + idposition + ", positionName=" + positionName + ", range=" + range + "]";
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getFirstWorld() {
		return firstWorld;
	}

	public void setFirstWorld(String firstWorld) {
		this.firstWorld = firstWorld;
	}

}
