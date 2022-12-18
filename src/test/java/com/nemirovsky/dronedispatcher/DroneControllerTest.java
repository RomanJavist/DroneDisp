package com.nemirovsky.dronedispatcher;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DroneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllDronesAndCount() throws Exception {

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.get("/drones").with(user("admin1").password("password1").roles(
                                "USER", "ADMIN")))
                        .andExpect(status().isOk())
                        .andExpect(view().name("drones"))
                        .andExpect(model().attribute("droneCount", equalTo(5)));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
    }

    @Test
    public void getSingleDroneById() throws Exception {
        mockMvc.perform(get("/drone/D001").with(user("admin1").password("password1").roles(
                        "USER", "ADMIN")))
                .andExpect(status().isOk())
                .andExpect(view().name("drone"))
                .andExpect(model().attribute("errMsg", equalTo(null)))
                .andExpect(model().attribute("showMedication", equalTo(true)));
    }


}