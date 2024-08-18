package dev.alfrendosilalahi.firstapp.controller;

import dev.alfrendosilalahi.common.dto.UsersResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/consumer")
@RequiredArgsConstructor
public class UserConsumerController {

    private final RestTemplate restTemplate;

    @GetMapping("/users")
    public ResponseEntity<UsersResponseDTO> getUsers() {
        ResponseEntity<UsersResponseDTO> response = restTemplate.getForEntity("http://localhost:8081/api/producer/users", UsersResponseDTO.class);
        if (response.getStatusCode().isError()) {
            throw new RuntimeException("ERROR");
        }
        return ResponseEntity.ok(response.getBody());
    }

}
