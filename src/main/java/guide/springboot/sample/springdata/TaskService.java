package guide.springboot.sample.springdata;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<TaskEntity> selectAll();
    String insert(final TaskEntity taskEntity);
    TaskEntity patch(final String id, final TaskEntity taskEntity);
    Optional<TaskEntity> select(final String id);
    void delete(final String id);
    TaskEntity update(final String id, final TaskEntity taskEntity);
}
