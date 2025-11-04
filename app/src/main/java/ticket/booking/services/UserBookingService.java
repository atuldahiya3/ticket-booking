package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        File users= new File(USERS_PATH);
        userList=mapper.readValue(users, new TypeReference<List<User>>() {});
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
    public boolean cancelBooking(){
        try{
            
        }
    }

}
