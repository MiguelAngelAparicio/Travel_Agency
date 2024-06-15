package com.miguelprojects.travel_agency.Models;

import com.miguelprojects.travel_agency.Enums.TicketClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name ="flights")
@DynamicUpdate
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightId;

    @NotBlank(message = "First Name is mandatory")
    @Column(name = "flight_number")
    private String flightNumber;

    private String airline;

    @NotBlank(message = "Origin is mandatory")
    private String origin;

    @NotBlank(message = "Destination is mandatory")
    private String destination;

    private Integer mileage;

    private Integer duration;

    @Column(name = "date_of_flight")
    @NotNull(message = "Date of Flight is mandatory")
    private LocalDate dateOfFlight;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @NotBlank(message = "Seat Number is mandatory")
    @Column(name = "seat_number")
    private String seatNumber;

    @NotNull(message = "Ticket Class is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_class")
    private TicketClass ticketClass;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    public Flight() {    }

    public Flight(Long flightId, String flightNumber, String airline, String origin, String destination,
                  Integer mileage, Integer duration, LocalDate dateOfFlight, LocalDateTime departureTime,
                  LocalDateTime arrivalTime, String seatNumber, TicketClass ticketClass, Travel travel) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.mileage = mileage;
        this.duration = duration;
        this.dateOfFlight = dateOfFlight;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatNumber = seatNumber;
        this.ticketClass = ticketClass;
        this.travel = travel;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(LocalDate dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightId, flight.flightId) && Objects.equals(flightNumber, flight.flightNumber)
                && Objects.equals(airline, flight.airline) && Objects.equals(origin, flight.origin)
                && Objects.equals(destination, flight.destination) && Objects.equals(mileage, flight.mileage)
                && Objects.equals(duration, flight.duration) && Objects.equals(dateOfFlight, flight.dateOfFlight)
                && Objects.equals(departureTime, flight.departureTime) && Objects.equals(arrivalTime, flight.arrivalTime)
                && Objects.equals(seatNumber, flight.seatNumber) && ticketClass == flight.ticketClass
                && Objects.equals(travel, flight.travel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, airline, origin, destination, mileage, duration,
                dateOfFlight, departureTime, arrivalTime, seatNumber, ticketClass, travel);
    }
}
