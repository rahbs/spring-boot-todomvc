package guide.springboot.sample.springdata;

import java.util.List;
import java.util.Optional;

public class TaskSpringDataService implements TaskService {
    private final TaskRepository taskRepository;

    TaskSpringDataService(
            final TaskRepository taskRepository
    ) {
        this.taskRepository = taskRepository;

    }

    @Override
    public List<TaskEntity> selectAll() {
        final var tasks = taskRepository.findAll();
        return tasks;
    }
    @Override
    public Optional<TaskEntity> select(final String id){
        return taskRepository.findById(id).map(it->{
            final var taskEntity = new TaskEntity();
            taskEntity.setDetails(it.getDetails());
            taskEntity.setStatus(it.getStatus());
            return taskEntity;
        });
    }
    @Override
    public String insert(TaskEntity taskEntity) {
        final var saved = taskRepository.save(taskEntity);
        return saved.getId();
    }
    @Override
    public TaskEntity patch(String id, TaskEntity taskEntity){
        final var existingTask = taskRepository.findById(id).orElseThrow();

        if(taskEntity.getDetails()!=null){
            existingTask.setDetails(taskEntity.getDetails());
        }
        if(taskEntity.getStatus()!=null){
            existingTask.setStatus(taskEntity.getStatus());
        }

        final var saved = taskRepository.save(existingTask);

        final var savedTaskEntity = new TaskEntity();
        savedTaskEntity.setDetails(saved.getDetails());
        savedTaskEntity.setStatus(saved.getStatus());
        savedTaskEntity.setId(saved.getId());
        return savedTaskEntity;
    }

    @Override
    public TaskEntity update(String id, TaskEntity taskEntity) {
        final var existingTask = taskRepository.findById(id).orElseThrow();

        existingTask.setDetails(taskEntity.getDetails());
        existingTask.setStatus(taskEntity.getStatus());

        final var saved = taskRepository.save(existingTask);

        final var savedTaskEntity = new TaskEntity();
        savedTaskEntity.setDetails(saved.getDetails());
        savedTaskEntity.setStatus(saved.getStatus());
        return savedTaskEntity;
    }

    @Override
    public void delete(final String id) {
        taskRepository.deleteById(id);
    }
}
