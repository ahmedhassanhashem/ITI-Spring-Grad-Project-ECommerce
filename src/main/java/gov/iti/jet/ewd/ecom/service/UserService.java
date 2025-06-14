package gov.iti.jet.ewd.ecom.service;

import gov.iti.jet.ewd.ecom.dto.CreditBalanceDTO;
import gov.iti.jet.ewd.ecom.dto.ChangePasswordDTO;
import gov.iti.jet.ewd.ecom.dto.LoginRequestDTO;
import gov.iti.jet.ewd.ecom.dto.UserDTO;
import gov.iti.jet.ewd.ecom.entity.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface UserService {

    public User getUserByEmail(String email);

    public User getUserById(int userId) ;

    public List<User> getAllUsers();

    User createUser(User user);

    public void forgotPassword(String email);
    boolean verifyOtp(String email, String otpCode);
    void resetPassword(String email, String newPassword);


    public double changeBalance(CreditBalanceDTO creditBalanceDto, HttpSession session);

   public boolean emailExists(String email);

   public boolean updateProfile(UserDTO user);

   public boolean phoneExists(String phone);


    /************************ AuthService (login , logout) ***************/
    UserDTO login(LoginRequestDTO loginRequestDto, HttpSession session);
    void logout(HttpSession session);


    void changePassword(int userId, ChangePasswordDTO changePasswordDto);


}
