package visibility.datahub.domain;

public class InputData {

	private String dataId;
	private String shprId;
	private String cneeId;
	private String containerNo;
	private String locNm;
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getShprId() {
		return shprId;
	}
	public void setShprId(String shprId) {
		this.shprId = shprId;
	}
	public String getCneeId() {
		return cneeId;
	}
	public void setCneeId(String cneeId) {
		this.cneeId = cneeId;
	}
	public String getContainerNo() {
		return containerNo;
	}
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}
	public String getLocNm() {
		return locNm;
	}
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	@Override
	public String toString() {
		return "InputData [dataId=" + dataId + ", shprId=" + shprId + ", cneeId=" + cneeId + ", containerNo="
				+ containerNo + ", locNm=" + locNm + "]";
	}
}
