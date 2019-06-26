import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.packs.ossf.controllers.AuthController;
import com.packs.ossf.models.entity.User;
import com.packs.ossf.models.requests.LoginRequest;
import com.packs.ossf.models.requests.SignUpRequest;
import com.packs.ossf.repositories.UserRepository;
import com.packs.ossf.services.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.print.Book;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TestAuthController {
    private MockMvc mockMvc;

    @Mock
    UserRepository userRepository;

    @Mock
    SignUpRequest signUpRequest;

    private static final ObjectMapper om = new ObjectMapper();

//    SignUpRequest newSignUpRequest=new SignUpRequest("testuser","testuser123","testuser@mailinator.com","123456");
//    SignUpRequest oldSignUpRequest=new SignUpRequest("testuser","testuser123","testuser@mailinator.com","123456");


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AuthController()).build();
    }

    @Test
    public void trueRegisterUserTest() throws Exception {
        this.mockMvc.perform(get("/api/auth/test"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void falseRegisterUserTest() throws Exception {
        this.mockMvc.perform(get("/api/test"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void trueNewSignUpTest() throws Exception {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setName("tset");
        signUpRequest.setUsername("sfsdf");
        signUpRequest.setEmail("asd");
        signUpRequest.setPassword("asdfsf");


        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth/signup")
                        .content(om.writeValueAsString(signUpRequest))
                        .header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void trueLoginTest() throws Exception {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsernameOrEmail("testuser");
        loginRequest.setPassword("123456");
        System.out.println("===================>>>>>>>>>>>>>>>>>>>"+om.writeValueAsString(loginRequest));

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth/signin")
                        .content(om.writeValueAsString(loginRequest))
                        .header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }
}
