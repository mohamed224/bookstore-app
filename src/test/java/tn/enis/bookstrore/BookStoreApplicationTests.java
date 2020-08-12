package tn.enis.bookstrore;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tn.enis.bookstrore.dao.ClientRepository;
import tn.enis.bookstrore.model.Client;
import tn.enis.bookstrore.service.impl.ClientService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookStoreApplicationTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void getClient() throws Exception {
        MvcResult result = mockMvc.perform(get("/clients/1")).andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        Client response = mapper.readValue(resultContent,Client.class);
        Assertions.assertTrue(response.getLastName().equals("Diaby"));

    }

}
