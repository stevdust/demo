import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;

    private UserModel user;

    @BeforeEach
    void setup (){
        MockitoAnnotations.initMocks(this);

        user = new UserModel();
        user.setUserId(new Long("15"));
        user.setUserName("Nicky");
        user.setName("Nichole");
        user.setEmail("ngm@gmail.com");
        user.setPhone("311225566");

    }

    @Test
    void getUsersTest () {
        List<UserModel> lista = Arrays.asList(user);
        when(userRepository.findAll()).thenReturn((lista));
        assertNotNull(lista);
    }

    @Test
    void findByMailTest () {
        List<UserModel> lista = Arrays.asList(user);
        when(userRepository.findByEmail("ngm@gmail.com")).thenReturn((lista));
        assertNotNull(lista);
    }
}
