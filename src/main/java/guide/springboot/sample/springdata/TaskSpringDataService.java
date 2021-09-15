package guide.springboot.sample.springdata;

import java.util.List;

public class TaskSpringDataService implements TaskService {


    private final TaskSpringDataRepository taskSpringDataRepository;
    TaskSpringDataService(
            final TaskSpringDataRepository taskSpringDataRepository
    ) {
        this.taskSpringDataRepository = taskSpringDataRepository;

    }

    @Override
    public List<TaskEntity> selectAll() {
        final var tasks = taskSpringDataRepository.findAll();
        return tasks;
    }

    @Override
    public String insert(TaskEntity taskEntity) {
        final var saved = taskSpringDataRepository.save(taskEntity);
        return saved.getId();
    }
}
