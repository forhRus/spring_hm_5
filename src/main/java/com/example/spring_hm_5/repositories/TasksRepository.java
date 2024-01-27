package com.example.spring_hm_5.repositories;

import com.example.spring_hm_5.models.Task;
import com.example.spring_hm_5.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

  /**
   * Получить список задач с определённым статусом
   * @param status
   * @return
   */
  List<Task> findByStatus(TaskStatus status);
}
