package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.User;
import ticket.booking.utils.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;
    List<User> userList = new ArrayList<>();
    private static final String USERS_PATH="../localDB/users.json";
    ObjectMapper mapper= new ObjectMapper();


    public UserBookingService(User currentUser) throws IOException {
        this.user=currentUser;
        getUsers();
    }
    public UserBookingService() throws IOException{
        getUsers();
    }
    public List<User> getUsers() throws IOException {
        File users= new File(USERS_PATH);
        return mapper.readValue(users, new TypeReference<List<User>>() {});
    }
    public boolean loginUser(){
        Optional<User> foundUser= userList.stream().filter(currentUser->{
            return currentUser.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), currentUser.getHashPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
    public boolean signUp(User newUser){
        try{
            userList.add(newUser);
            File users= new File(USERS_PATH);
            mapper.writeValue(users, newUser);
            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }

    }
    public void fetchBookings(){
        user.printTickets();
    }
    public boolean cancelBooking(String ticketId){
        try{
            List<Ticket> bookings=user.getTicketsBooked();
            if (bookings == null || bookings.isEmpty()) return false;
            Optional<Ticket> ticketToCancel= bookings.stream().filter({ticket -> ticket.getTicketId().equals(ticketId)});
            if(ticketToCancel.isPresent()){
                bookings.remove(ticketToCancel.get());
                user.setTicketsBooked(bookings);
                for(User u : userList){
                    if(u.getName().equals(user.getName())){
                        u.setTicketsBooked(bookings);
                    }
                }
            }
            File users= new File(USERS_PATH);
            mapper.writeValue(users, userList);
           return Boolean.TRUE;
        }catch(Exception e){
            return Boolean.FALSE;
        }
    }

}
