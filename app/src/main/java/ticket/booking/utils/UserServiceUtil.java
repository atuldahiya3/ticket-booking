package ticket.booking.utils;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {
    public static String hashPassword(String userPassword){
        return BCrypt.hashpw(userPassword,BCrypt.gensalt());
    }
    public static boolean checkPassword(String userPassword, String hashPassword){
        return BCrypt.checkpw(userPassword,hashPassword);
    }
}
