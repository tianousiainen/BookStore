package homework.bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest 
@AutoConfigureMockMvc 
public class CategoryControllerTest {
    @Autowired 
    private MockMvc mockMvc;

    @Test 
    @WithMockUser 
    public void categoryListOpens() throws Exception{
        mockMvc.perform(get("/booklist"))
        .andExpect(status().isOk());
    }

    @Test 
    @WithMockUser 
    public void addCategoryOpens() throws Exception{
        mockMvc.perform(get("/addcategory"))
        .andExpect(status().isOk());
    }
}
