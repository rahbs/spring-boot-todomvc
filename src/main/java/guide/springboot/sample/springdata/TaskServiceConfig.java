package guide.springboot.sample.springdata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskServiceConfig {
    @Bean
    TaskService TaskService(
            final TaskSpringDataRepository TaskSpringDataRepository
    ) {
        return new TaskSpringDataService(
                TaskSpringDataRepository
        );
    }
}
