package model;

public class Flight1 {
String flight1, airline1,to, date1, scheduled1, etd,status1;

	
	
	
	public Flight1(String flight1,String airline1,String to,String date1,String scheduled1,String etd,String status1) {
		this.flight1=flight1;
		this.airline1=airline1;
		this.date1=date1;
		this.to=to;
		this.scheduled1=scheduled1;
		this.etd=etd;
		this.status1=status1;
		
	}
	public String getFlight1() {
		return flight1;
	}
	public void setFlight1(String flight1) {
		this.flight1=flight1;
	}
	
	public String getAirline1() {
		return airline1;
	}
	public void setAirline1(String airline1) {
		this.airline1=airline1;
	}

	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1=date1;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to=to;
	}

	public String getScheduled1() {
		return scheduled1;
	}
	public void setScheduled1(String scheduled1) {
		this.scheduled1=scheduled1;
	}

	public String getEtd() {
		return etd;
	}
	public void setEtd(String etd) {
		this.etd=etd;
	}
	
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1=status1;
}
}
