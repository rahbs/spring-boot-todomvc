package guide.springboot.sample.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<TaskEntity, String>{
}
