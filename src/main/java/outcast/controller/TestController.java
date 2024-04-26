package outcast.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import outcast.auth.AuthenticationRequest;
import outcast.auth.AuthenticationResponse;

/**
 * @author outcast c-cute hột me 😳
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World!");
    }
}
