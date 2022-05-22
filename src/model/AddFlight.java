package model;

public class AddFlight {
	public String flight2, airline2,from2, date2, scheduled2, eta2,status2;
	
	
	public AddFlight(String flight2, String airline2,String from2, String date2,String scheduled2,String eta2,String status2) {
		this.flight2=flight2;
		this.airline2=airline2;
		this.date2=date2;
		this.from2=from2;
		this.scheduled2=scheduled2;
		this.eta2=eta2;
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
	public String getFrom() {
		return from2;
	}
	public void setFrom(String from2) {
		this.from2=from2;
	}

	public String getScheduled() {
		return scheduled2;
	}
	public void setScheduled(String scheduled2) {
		this.scheduled2=scheduled2;
	}

	public String getEta() {
		return eta2;
	}
	public void setEta(String eta2) {
		this.eta2=eta2;
	}
	
	public String getStatus() {
		return status2;
	}
	public void setStatus(String status2) {
		this.status2=status2;
	}
}
