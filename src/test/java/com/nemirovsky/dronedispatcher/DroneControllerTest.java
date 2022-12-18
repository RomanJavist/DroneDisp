package com.nemirovsky.dronedispatcher;

import com.nemirovsky.dronedispatcher.controller.DroneController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebMvcTest(controllers = DroneController.class)
public class DroneControllerTest {

    @Value("${program.name}")
    private String programName;

    @Value("${program.version}")
    private String programVersion;
    @Autowired
    private MockMvc mockMvc;
    private final String helloString = programName + " " + programVersion;

    @Test
    public void getAllDrones() throws Exception {


        ResultActions resultActions = mockMvc.perform(get("/drones"))
                .andExpect(status().isOk())
                .andExpect(view().name("drones"))
                .andExpect(model().attribute("helloMessage", equalTo(helloString)))
                .andExpect(content().string(containsString(helloString)));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
    }

    @Test
    public void getDroneById() throws Exception {
        mockMvc.perform(get("/drone/D001"))
                .andExpect(status().isOk())
                .andExpect(view().name("drones"))
                .andExpect(model().attribute("helloMessage", equalTo(helloString)))
                .andExpect(content().string(containsString(helloString)));
    }


}