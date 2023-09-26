package visibility.datahub.model.rcv.std;

public class StandardTrackingInfo {

    private String infoType;
    private String infoContent;

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
		return "StandardTrackingInfo [infoType=" + infoType + ", infoContent=" + infoContent + "]";
	}
}
