package com.hhbravo.springmongodbdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhbravo.springmongodbdemo.config.ConfigServerWithFongoConfiguration;
import com.hhbravo.springmongodbdemo.document.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ConfigServerWithFongoConfiguration.class }, properties = {
        "server.port=8980" }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = { "spring.data.mongodb.database=test" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringMongodbDemoApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper jsonMapper;

    @Before
    public void setUp() {
        jsonMapper = new ObjectMapper();
    }

    @Test
    public void getUserTest() throws Exception {

        Users usersInput = new Users();
        usersInput.setId(1);
        usersInput.setName("hans");
        usersInput.setTeamName("development");
        usersInput.setSalary(3000L);
        mongoTemplate.createCollection("users");
        mongoTemplate.insert(usersInput);

        ResultActions resultAction = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8090/api/users/1"));
        resultAction.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        MvcResult result = resultAction.andReturn();
        Users users= jsonMapper.readValue(result.getResponse().getContentAsString(), Users.class);
        Assert.assertEquals(usersInput.getId(), users.getId());
        Assert.assertEquals(usersInput.getName(),users.getName());
        Assert.assertEquals(usersInput.getTeamName(), users.getTeamName());

    }
}

