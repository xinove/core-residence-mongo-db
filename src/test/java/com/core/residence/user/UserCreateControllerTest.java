package com.core.residence.user;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.core.residence.controller.UsuarioController;
import com.core.residence.dto.UserDto;
import com.core.residence.model.User;
import com.core.residence.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.bson.types.ObjectId;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UsuarioController.class)
public class UserCreateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private UserService userService;

    @InjectMocks
    private UsuarioController userController;

    @Test
    public void testCreateUser() throws Exception {
        // Given
        UserDto userDto = new UserDto();
        userDto.setUsername("testuser");
        userDto.setPassword("testpassword");
        userDto.setEmail("test@example.com");

        User newUser = new User();
        
        ObjectId objectId = new ObjectId("1");

        newUser.setId(objectId);
        newUser.setName(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());

        when(userService.createUser(any(UserDto.class))).thenReturn(newUser);

        // When
        MvcResult mvcResult = mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isCreated())
                .andReturn();

        // Then
        String responseBody = mvcResult.getResponse().getContentAsString();
        User createdUser = objectMapper.readValue(responseBody, User.class);
        // Here you can assert the properties of the created user if needed
    }
}
