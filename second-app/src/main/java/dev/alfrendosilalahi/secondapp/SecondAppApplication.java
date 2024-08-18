package dev.alfrendosilalahi.secondapp;

import dev.alfrendosilalahi.common.dto.UsersResponseDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/producer")
public class SecondAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondAppApplication.class, args);
	}

	@GetMapping("/users")
	public ResponseEntity<UsersResponseDTO> getUsers() {
		var users = new UsersResponseDTO();
		var user1 = UsersResponseDTO.UserResponseDTO.builder()
				.username("johndoe")
				.email("johndoe@email.com")
				.build();
		var user2 = UsersResponseDTO.UserResponseDTO.builder()
				.username("janedoe")
				.email("janedoe@email.com")
				.build();
		users.setUsers(List.of(user1, user2));
		return ResponseEntity.ok(users);
	}

}
