package model;

public class Flight2 {
	
	public String flight, airline,from, date, scheduled, eta,status;
	
	
	
	public Flight2(String flight,String airline,String from,String date,String scheduled,String eta,String status) {
		this.flight=flight;
		this.airline=airline;
		this.date=date;
		this.from=from;
		this.scheduled=scheduled;
		this.eta=eta;
		this.status=status;
		
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight=flight;
	}
	
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline=airline;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from=from;
	}

	public String getScheduled() {
		return scheduled;
	}
	public void setScheduled(String scheduled) {
		this.scheduled=scheduled;
	}

	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta=eta;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
}

