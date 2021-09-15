package guide.springboot.sample.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskSpringDataRepository extends JpaRepository<TaskEntity, String>{
}
