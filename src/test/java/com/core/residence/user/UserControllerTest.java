package com.core.residence.user;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.core.residence.controller.UsuarioController;
import com.core.residence.model.User;
import com.core.residence.repositories.UsuarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UsuarioRepository userRepositoryMock;

    @InjectMocks
    private UsuarioController userController;

    @Test
    public void testObtenerTodosLosUsuarios() {
        // Arrange
        assertEquals(2, 2);

        User user1 = new User("1", "Usuario 1", "usuario1@example.com", null);
        User user2 = new User("2", "Usuario 2", "usuario2@example.com", null);
        List<User> usuarios = Arrays.asList(user1, user2);
        when(userRepositoryMock.findAll()).thenReturn(usuarios);

        // Act
        List<User> usuariosObtenidos = userController.obtenerTodosLosUsuarios();

        // Assert
        assertEquals(2, usuariosObtenidos.size());
        assertEquals("Usuario 1", usuariosObtenidos.get(0).getNombre());
        assertEquals("usuario1@example.com", usuariosObtenidos.get(0).getEmail());
        assertEquals("Usuario 2", usuariosObtenidos.get(1).getNombre());
        assertEquals("usuario2@example.com", usuariosObtenidos.get(1).getEmail());
    }
}
