package com.dungken.scientificresearch2024backend.service;

import com.dungken.scientificresearch2024backend.dao.UserRepository;
import com.dungken.scientificresearch2024backend.entity.Notification;
import com.dungken.scientificresearch2024backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailServiceImpl mailService;
    public ResponseEntity<?> registerUser(User user){
        // Kiểm tra tên đăng nhập đã tồn tại chưa?
        if(userRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().body(new Notification("Username available."));
        }

        // Kiểm tra email đã tồn tại chưa?
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body(new Notification("Email available."));
        }

        // Mã hóa mật khẩu
        String encryptPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptPassword);

        // Set thong tin kich hoat tai khoan user
        user.setActive(false);
        user.setActiveCode(generateActivationCode());

        // Lưu người dùng người dùng vào DB
        userRepository.save(user);

        // Gui mail kich hoat tai khoan nguoi dung
        sendActivationEmail(user.getEmail(), user.getActiveCode());

        return ResponseEntity.ok("Sign Up Success");
    }

    private String generateActivationCode(){
        // Tạo mã ngẫu nhiên
        return UUID.randomUUID().toString();
    }

    private void sendActivationEmail(String email, String activeCode){
        String subject = "Kích hoạt tài khoản của bạn tại Website hỗ trợ toán rời rạc";
        String text = "Vui lòng sử dụng mã sau để kich hoạt cho tài khoản <"+email+">:" +
                "<html><body><br/><h1>"+activeCode+"</h1></body></html>";
        text+="<br/> Click vào đường link để kích hoạt tài khoản: ";
        String url = "http://localhost:3000/active/"+email+"/"+activeCode;
        text+=("<br/> <a href="+url+">"+url+"</a> ");

        mailService.sendMail("phpmaster.dungken.dev@gmail.com", email, subject, text);
    }
    public ResponseEntity<?> activeAccount(String email, String activeCode) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return ResponseEntity.badRequest().body(new Notification("User does not exist!"));
        }

        if (user.isActive()) {
            return ResponseEntity.badRequest().body(new Notification("Account has been activated!"));
        }

        if (activeCode.equals(user.getActiveCode())) {
            user.setActive(true);
            userRepository.save(user);
            return ResponseEntity.ok("Account activation successful!");
        } else {
            return ResponseEntity.badRequest().body(new Notification("Activation code is incorrect!"));
        }
    }
}
