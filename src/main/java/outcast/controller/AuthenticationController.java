package outcast.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

import java.io.IOException;
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
                return ResponseEntity.ok(generateResponse("error", "Tài khoản đã tồn tại!"));
            }
            if (containsSpecialCharacters(request.getUserName())) {
                return ResponseEntity.ok(generateResponse("error", "Tên tài khoản không được chứa các kí tự đặc biệt!"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(service.register(request));
    }

    private AuthenticationResponse generateResponse(String status, String message) {
        return AuthenticationResponse.builder()
                .status(status)
                .message(message)
                .build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

    public static boolean containsSpecialCharacters(String input) {
        String specialCharacters = "[!@#$%^&*()_+=\\[\\]{}|:<>?~-]";
        return Pattern.compile(specialCharacters).matcher(input).find();
    }
}
