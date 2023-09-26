package visibility.datahub.model.rcv.std;

import java.util.List;


public class StandardTrackingData {
	
	private String trackingDataNo;
    private String transMode;
    private String transStatus;
    private String refDocType;
    private String refDocNo;
    private String transMethodNo;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String fromTime;
    private String toDate;
    private String toTime;
    private List<StandardTrackingEvent> trackingEvent;
    private List<StandardTrackingInfo> trackingInfo;
	public String getTrackingDataNo() {
		return trackingDataNo;
	}
	public void setTrackingDataNo(String trackingDataNo) {
		this.trackingDataNo = trackingDataNo;
	}
	public String getTransMode() {
		return transMode;
	}
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	public String getRefDocType() {
		return refDocType;
	}
	public void setRefDocType(String refDocType) {
		this.refDocType = refDocType;
	}
	public String getRefDocNo() {
		return refDocNo;
	}
	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}
	public String getTransMethodNo() {
		return transMethodNo;
	}
	public void setTransMethodNo(String transMethodNo) {
		this.transMethodNo = transMethodNo;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public List<StandardTrackingEvent> getTrackingEvent() {
		return trackingEvent;
	}
	public void setTrackingEvent(List<StandardTrackingEvent> trackingEvent) {
		this.trackingEvent = trackingEvent;
	}
	public List<StandardTrackingInfo> getTrackingInfo() {
		return trackingInfo;
	}
	public void setTrackingInfo(List<StandardTrackingInfo> trackingInfo) {
		this.trackingInfo = trackingInfo;
	}
	@Override
	public String toString() {
		return "StandardTrackingData [trackingDataNo=" + trackingDataNo + ", transMode=" + transMode + ", transStatus="
				+ transStatus + ", refDocType=" + refDocType + ", refDocNo=" + refDocNo + ", transMethodNo="
				+ transMethodNo + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDate="
				+ fromDate + ", fromTime=" + fromTime + ", toDate=" + toDate + ", toTime=" + toTime + ", trackingEvent="
				+ trackingEvent + ", trackingInfo=" + trackingInfo + "]";
	}
}
