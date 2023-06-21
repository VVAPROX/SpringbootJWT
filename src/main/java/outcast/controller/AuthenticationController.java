package outcast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import outcast.auth.AuthenticationRequest;
import outcast.auth.AuthenticationResponse;
import outcast.auth.AuthenticationService;
import outcast.auth.RegisterRequest;
import outcast.repositories.UserRepository;

import java.util.regex.Pattern;

/**
 * @author outcast c-cute hột me 😳
 */

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        try {
            var user = repository.findByUsername(request.getUserName());
            if (!user.isEmpty()) {
                return ResponseEntity.ok(
                        AuthenticationResponse.builder()
                                .status("error")
                                .message("Tài khoản đã tồn tại")
                                .build()
                );
            }
            if (containsSpecialCharacters(request.getUserName())) {
                return ResponseEntity.ok(
                        AuthenticationResponse.builder()
                                .status("error")
                                .message("Tên tài khoản không được chứa các kí tự đặc biệt")
                                .build()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request) {
        System.err.println("authenticate");
        return ResponseEntity.ok(service.authenticate(request));
    }

    public static boolean containsSpecialCharacters(String input) {
        String specialCharacters = "[!@#$%^&*()_+=\\[\\]{}|:<>?~-]";
        return Pattern.compile(specialCharacters).matcher(input).find();
    }
}
