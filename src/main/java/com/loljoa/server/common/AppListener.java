package com.loljoa.server.common;

import com.loljoa.server.common.util.GetLCKSchedule;
import com.loljoa.server.common.vo.LCKScheduleVO;
import com.loljoa.server.db.entity.League;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//@Component
//@RequiredArgsConstructor
public class AppListener implements ApplicationListener<ApplicationEvent> {
    private EntityManagerFactory emf;
    private GetLCKSchedule getLCKSchedule;
    private boolean isActivated = false;

    @Value("${spring.profiles.active}")
    private String activeProfiles;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(isActivated) return;
        if(activeProfiles.equals("dev")) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction tr = em.getTransaction();

            tr.begin();
            try {
                Map<String, Object> lckSchedule = getLCKSchedule.getLCKSchedule();
                for(String weekNum : lckSchedule.keySet()) {
                    Map<String, Object> schedules = (HashMap)lckSchedule.get(weekNum);
                    for(String time : schedules.keySet()) {
                        List<LinkedHashMap> list = (List)schedules.get(time);
                        Boolean toggle = true;
                        for(LinkedHashMap map : list) {
                            String longTime;
                            if(toggle) {
                                longTime = time.substring(4) + " 05:00";
                            } else {
                                longTime = time.substring(4) + " 08:00";
                            }
                            League league = new League(weekNum, map.get("left_team_name") + "vs" + map.get("right_team_name"), LocalDateTime.parse(longTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), null);
                            em.persist(league);
                            em.flush();
                            toggle = !toggle;
                        }
                    }
                }
                tr.commit();
                em.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(activeProfiles.equals("prod")) {

        } else {

        }
        isActivated = true;
    }
}
