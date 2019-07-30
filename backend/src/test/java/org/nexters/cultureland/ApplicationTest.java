package org.nexters.cultureland;

import org.junit.jupiter.api.Test;
import org.nexters.cultureland.model.service.CultureService;
import org.nexters.cultureland.model.service.CultureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private CultureServiceImpl cultureService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void 조회_테스트() throws Exception {
        mockMvc.perform(get("/cultureInfos"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void 카테고리조회_테스트() throws Exception {
        mockMvc.perform(get("/cultureInfos/concert"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }
}
