package com.flightapp.entity;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_ticket")
public class TicketBooking {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = new Random().nextInt(99999999);

	private String userFirstName;

	private String userLastName;

	private String email;

	private String gender;

	private Integer age;

	private String seat;

	private String meal;

	private String address;

	private Long pnrNumber;

	private String ways;

	private Date startDate;
	private Date endDate;

	private String airlineName;

	private String fromPlace;

	private String toPlace;

	public TicketBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(Long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getWays() {
		return ways;
	}

	public void setWays(String ways) {
		this.ways = ways;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public TicketBooking(Integer id, String userFirstName, String userLastName, String email, String gender,
			Integer age, String seat, String meal, String address, Long pnrNumber, String ways, Date startDate,
			Date endDate, String airlineName, String fromPlace, String toPlace) {
		super();
		this.id = id;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.seat = seat;
		this.meal = meal;
		this.address = address;
		this.pnrNumber = pnrNumber;
		this.ways = ways;
		this.startDate = startDate;
		this.endDate = endDate;
		this.airlineName = airlineName;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
	}

	/*@Override
	public String toString() {
		return "TicketBooking [id=" + id + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", email=" + email + ", gender=" + gender + ", age=" + age + ", seat=" + seat + ", meal=" + meal
				+ ", address=" + address + ", pnrNumber=" + pnrNumber + ", ways=" + ways + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", airlineName=" + airlineName + ", fromPlace=" + fromPlace + ", toPlace="
				+ toPlace + "]";
	}*/

}
