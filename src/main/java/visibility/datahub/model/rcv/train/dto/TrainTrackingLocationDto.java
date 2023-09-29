package visibility.datahub.model.rcv.train.dto;

public class TrainTrackingLocationDto {
	private Integer id;
	private String ifId;
	private double latitude;
    private double longitude;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIfId() {
		return ifId;
	}
	public void setIfId(String ifId) {
		this.ifId = ifId;
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
		return "TrainTrackingLocationDto [id=" + id + ", ifId=" + ifId + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
    
}
