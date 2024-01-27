package com.example.spring_hm_5.services;

import com.example.spring_hm_5.models.Task;
import com.example.spring_hm_5.models.TaskStatus;
import com.example.spring_hm_5.repositories.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TasksService {
  private TasksRepository repository;

  /**
   * Получить весь список задач
   * @return
   */
  public List<Task> getAllTasks(){
    return repository.findAll();
  }

  /**
   * Получить задачу по id
   * @param id
   * @return
   */
  public Optional<Task> getTaskById(Long id){
    return repository.findById(id);
  }

  /**
   * Добавить задачу в БД
   * @param t
   */
  public void saveTask(Task t){
    repository.save(t);
  }

  /**
   * Удалить задачу по id
   * @param id
   */
  public void deleteTask(Long id){
    repository.deleteById(id);
  }

  /**
   * Обновить данные задачи по id
   * @param id
   * @param upTask
   * @return
   */
  public Task updateTask(Long id, Task upTask) {
    Optional<Task> optionalTask = repository.findById(id);
    if (optionalTask.isPresent()) {
      Task newTask = optionalTask.get();
      newTask.setDiscription(upTask.getDiscription());
      newTask.setStatus(upTask.getStatus());
      newTask.setDate(upTask.getDate());
      return repository.save(newTask);
    } else {
      throw new IllegalArgumentException("Task not found with id: " + id);
    }
  }

  /**
   * Получить список задач с определённым статусом
   * @param status
   * @return
   */
  public List<Task> getTaskByStatus(TaskStatus status) {
    return repository.findByStatus(status);
  }
}
