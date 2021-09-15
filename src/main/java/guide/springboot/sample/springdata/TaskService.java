package guide.springboot.sample.springdata;

import java.util.List;

public interface TaskService {

//    void delete(final int id);
//
//    Optional<Task> select(final TaskIdentifier id);

    List<TaskEntity> selectAll();
    String insert(final TaskEntity taskEntity);

}
