package homework.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest 
@AutoConfigureMockMvc 
public class BookStoreControllerTest {
    @Autowired 
    private MockMvc mockMvc;

    @Test 
    @WithMockUser
    void loginPageOpens() throws Exception{
        mockMvc.perform(get("/login"))
        .andExpect(status().isOk());
    }

    @Test 
    @WithMockUser 
    void indexPageOpens() throws Exception{
        mockMvc.perform(get("/index"))
        .andExpect(status().isOk());
    }

    @Test 
    @WithMockUser 
    void bookListOpens() throws Exception{
        mockMvc.perform(get("/booklist"))
        .andExpect(status().isOk());
    }

    @Test 
    @WithMockUser 
    void addBookPageOpens() throws Exception{
        mockMvc.perform(get("/addbook"))
        .andExpect(status().isOk());
    }
}
