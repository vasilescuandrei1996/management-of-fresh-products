package net.metrosystems.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import net.metrosystems.domain.User;
import net.metrosystems.repositories.UserRepository;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        
        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setUsername("admin");
        admin.setPassword("admin");
        userRepository.save(admin);
        
        log.info("Saved user - id: " + admin.getUserId());
        

    }
}