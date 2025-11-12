package ticket.booking.entities;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date bookingDate;
    private Date dateOfTravel;
    private Train train;

    // Getter and Setter for ticketId
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter and Setter for source
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    // Getter and Setter for destination
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    // Getter and Setter for bookingDate
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    // Getter and Setter for dateOfTravel
    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    // Getter and Setter for train
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTicketInfo(){
        return String.format("Ticket Id: %s belongs to User: %s from %s to %s on %s", ticketId, userId, source, destination, dateOfTravel);
    }
}
