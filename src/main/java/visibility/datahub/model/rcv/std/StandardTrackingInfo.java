package visibility.datahub.model.rcv.std;

public class StandardTrackingInfo {

	private Integer id;
	private String trackingDataNo;
    private String infoType;
    private String infoContent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrackingDataNo() {
		return trackingDataNo;
	}
	public void setTrackingDataNo(String trackingDataNo) {
		this.trackingDataNo = trackingDataNo;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	@Override
	public String toString() {
		return "StandardTrackingInfo [id=" + id + ", trackingDataNo=" + trackingDataNo + ", infoType=" + infoType
				+ ", infoContent=" + infoContent + "]";
	}

}
