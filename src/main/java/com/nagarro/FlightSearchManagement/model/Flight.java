package com.nagarro.FlightSearchManagement.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@Column(length = 64)
	private String flightNo;//Unique flight number, starting with 2 letter airline code
	private String departureLocation;//Departure location code
	private String arrivalLocation;//Arrival location code
	private Date flightDate;//Date (DD-MM-YYYY) till which each flight is available. It means that this flight will
							//fly once everyday till this date
	private String flightTime;//local time (HHmm) at which flight departs from departure location
	private Double flightDuration;//Flight Duration from departure location to arrival location
	private Double fare;//This is the fare of the flight per person in INR
	private String seatAvailability;//Y or N
	private String flightClass;//E or B or EB [E- economic, B- Business]
	public Flight(String flightNo,String departureLocation,String arrivalLocation,String flightDate,
			String flightTime,String flightDuration,String fare, String seatAvailability,String flightClass)
	{
		this.flightNo=flightNo;
		this.departureLocation=departureLocation;
		this.arrivalLocation=arrivalLocation;
		this.flightTime=flightTime;
		this.flightDuration=Double.parseDouble(flightDuration);
		this.fare=Double.parseDouble(fare);
		this.seatAvailability=seatAvailability;
		this.flightClass=flightClass;
		try {
			this.flightDate=new SimpleDateFormat("dd-MM-yyyy").parse(flightDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", flightDate=" + flightDate + ", flightTime=" + flightTime + ", flightDuration="
				+ flightDuration + ", fare=" + fare + ", seatAvailability=" + seatAvailability + ", flightClass="
				+ flightClass + "]";
	}
	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}
	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	/**
	 * @return the departureLocation
	 */
	public String getDepartureLocation() {
		return departureLocation;
	}
	/**
	 * @param departureLocation the departureLocation to set
	 */
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	/**
	 * @return the arrivalLocation
	 */
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	/**
	 * @param arrivalLocation the arrivalLocation to set
	 */
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	/**
	 * @return the flightDate
	 */
	public Date getFlightDate() {
		return flightDate;
	}
	/**
	 * @param flightDate the flightDate to set
	 */
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	/**
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return flightTime;
	}
	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	/**
	 * @return the flightDuration
	 */
	public Double getFlightDuration() {
		return flightDuration;
	}
	/**
	 * @param flightDuration the flightDuration to set
	 */
	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}
	/**
	 * @return the fare
	 */
	public Double getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(Double fare) {
		this.fare = fare;
	}
	/**
	 * @return the seatAvailability
	 */
	public String getSeatAvailability() {
		return seatAvailability;
	}
	/**
	 * @param seatAvailability the seatAvailability to set
	 */
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}
	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	
	
}
