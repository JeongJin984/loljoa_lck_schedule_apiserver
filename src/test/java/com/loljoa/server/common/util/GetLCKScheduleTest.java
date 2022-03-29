package com.loljoa.server.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class GetLCKScheduleTest {
    @Autowired
    private GetLCKSchedule getLCKSchedule;

    @Test
    void test() throws IOException {
        getLCKSchedule.getLCKSchedule();
    }
}