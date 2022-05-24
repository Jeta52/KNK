package model;

public class AddFlight1 {
	public String flight2, airline2,to2, date2, scheduled2, etd2,status2;
	
	
	public AddFlight1(String flight2, String airline2,String to2, String date2,String scheduled2,String etd2,String status2) {
		this.flight2=flight2;
		this.airline2=airline2;
		this.to2=to2;
		this.date2=date2;
		this.scheduled2=scheduled2; 
		this.etd2=etd2;
		this.status2=status2;
		
	}
	public String getFlight() {
		return flight2;
	}
	public void setFlight(String flight2) {
		this.flight2=flight2;
	}
	
	public String getAirline() {
		return airline2;
	}
	public void setAirline(String airline2) {
		this.airline2=airline2;
	}

	public String getDate() {
		return date2;
	}
	public void setDate(String date2) {
		this.date2=date2;
	}
	public String getTo() {
		return to2;
	}
	public void setFrom(String to2) {
		this.to2=to2;
	}

	public String getScheduled() {
		return scheduled2;
	}
	public void setScheduled(String scheduled2) {
		this.scheduled2=scheduled2;
	}

	public String getEtd() {
		return etd2;
	}
	public void setEta(String etd2) {
		this.etd2=etd2;
	}
	
	public String getStatus() {
		return status2;
	}
	public void setStatus(String status2) {
		this.status2=status2;
	}
}

