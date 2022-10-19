package test;

import com.google.gson.JsonObject;
import com.spring.spring.config.RootConfig;
import com.spring.spring.config.ServletConfig;
import com.spring.spring.config.WebConfig;
import com.spring.spring.controller.TestController;
import com.spring.spring.service.TestService;
import com.spring.spring.vo.TestVo;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class Test {
    private MockMvc mock;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    @Qualifier("testService")
    TestService testService;

    @Autowired
    @Qualifier("testController")
    TestController testController;

    @Before
    public void beforeClass() {
        System.out.println("-----테스트 시작-----");
        this.mock = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @After
    public void afterClass() {
        System.out.println("-----테스트 종료-----");
    }

    @org.junit.Test
    public void test() throws Exception {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", "id");
        obj.addProperty("name", "name");

        RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/test").contentType(MediaType.APPLICATION_JSON).characterEncoding(String.valueOf(StandardCharsets.UTF_8)).content(obj.toString());
        mock.perform(reqBuilder)
                .andExpect(status().isOk())
                .andDo(print());
        reqBuilder = MockMvcRequestBuilders.get("/test").contentType(MediaType.TEXT_PLAIN).characterEncoding(String.valueOf(StandardCharsets.UTF_8)).content("id");
        mock.perform(reqBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("name"))
                .andDo(print());


    }
}
