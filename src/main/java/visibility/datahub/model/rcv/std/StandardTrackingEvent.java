package visibility.datahub.model.rcv.std;

public class StandardTrackingEvent {

	private String eventNo;
    private String eventTime;
    private String eventType;
    private double latitude;
    private double longitude;
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "StandardTrackingEvent [eventNo=" + eventNo + ", eventTime=" + eventTime + ", eventType=" + eventType
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
    
    
}
