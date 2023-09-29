package visibility.datahub.model.rcv.train.dto;

import java.util.List;

public class TrainTrackingDataDto {

	private String ifId;
	private String docNo;
	private String trainNo;
	private String fromStation;
	private String toStation;
	private String departureDate;
	private String departureTime;
	private String arrivalDate;
	private String arrivalTime;
	private List<TrainTrackingLocationDto> tranLoc;
	public String getIfId() {
		return ifId;
	}
	public void setIfId(String ifId) {
		this.ifId = ifId;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public List<TrainTrackingLocationDto> getTranLoc() {
		return tranLoc;
	}
	public void setTranLoc(List<TrainTrackingLocationDto> tranLoc) {
		this.tranLoc = tranLoc;
	}
	@Override
	public String toString() {
		return "TrainTrackingDataDto [ifId=" + ifId + ", docNo=" + docNo + ", trainNo=" + trainNo + ", fromStation="
				+ fromStation + ", toStation=" + toStation + ", departureDate=" + departureDate + ", departureTime="
				+ departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", tranLoc="
				+ tranLoc + "]";
	}
	
}
