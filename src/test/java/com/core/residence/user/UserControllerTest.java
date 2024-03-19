package com.core.residence.user;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.core.residence.controller.UsuarioController;
import com.core.residence.dto.UserDto;
import com.core.residence.model.User;
import com.core.residence.repositories.UsuarioRepository;
import com.core.residence.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserControllerTest {

    @Mock
    private UsuarioRepository userRepositoryMock;

    @InjectMocks
    private UsuarioController userController;

//    @Test
//    public void testObtenerTodosLosUsuarios() {
//        // Arrange
//        assertEquals(2, 2);
//
//        UserDto user1 = new UserDto(1L, "Usuario 1", "pass1",  "usuario1@example.com");
//        UserDto user2 = new UserDto(2L, "Usuario 2", "pass2",  "usuario2@example.com");
//        List<UserDto> usuarios = Arrays.asList(user1, user2);
//        userController.createUser(user1);
//        userController.createUser(user2);
//        log.info("Hola");
//        List<User> user = null;
//
//        when(userRepositoryMock.findAll()).thenReturn(user);
//
//        // Act
//        List<User> usuariosObtenidos = userController.obtenerTodosLosUsuarios();
//
//        // Assert
//        assertEquals(2, usuariosObtenidos.size());
//        assertEquals("Usuario 1", usuariosObtenidos.get(0).getName());
//        assertEquals("usuario1@example.com", usuariosObtenidos.get(0).getEmail());
//        assertEquals("Usuario 2", usuariosObtenidos.get(1).getName());
//        assertEquals("usuario2@example.com", usuariosObtenidos.get(1).getEmail());
//    }


    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UsuarioController()).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("testuser");
        userDto.setPassword("password123");
        userDto.setEmail("test@example.com");
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("testuser"))
                .andExpect(jsonPath("$.email").value("test@example.com"));
    
    
    
    
    
    
    
    
    
    
    
    
    }

	public void testObtenerTodosLosUsuarios() {
		// TODO Auto-generated method stub
		
	}
}
