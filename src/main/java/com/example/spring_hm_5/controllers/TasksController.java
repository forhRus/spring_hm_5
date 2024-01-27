package com.example.spring_hm_5.controllers;

import com.example.spring_hm_5.models.Task;
import com.example.spring_hm_5.models.TaskStatus;
import com.example.spring_hm_5.services.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TasksController {
  private TasksService service;

  /**
   * Получить список всех задач
   * @return список задач
   */
  @GetMapping
  public List<Task> getAllTasks(){
    List<Task> tasks = service.getAllTasks();
    System.out.println(tasks.toString());
    return tasks;
  }

  /**
   * Получить задачу по id
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public Task getTasks(@PathVariable("id") long id){
    Task task = service.getTaskById(id).get();
    System.out.println(task);
    return task;
  }

  /**
   * Добавить задачу в БД
   * @param task
   */
  @PostMapping ("/add")
  public void addTask(@RequestBody Task task){
    service.saveTask(task);
  }

  /**
   * Добавить задачу по одному лишь описанию
   * (время будет LocalDateTime.now(), а статус NOT_STARTED )
   * @param d
   */
  @PostMapping ("/add_d")
  public void addTask(@ModelAttribute("discription") String d){
    Task t = new Task(d);
    service.saveTask(t);
  }

  /**
   * удалить задачу по id
   * @param id
   */
  @DeleteMapping("delete/{id}")
  public void deleteTask(@PathVariable("id") long id){
    service.deleteTask(id);
  }

  /**
   * Обновить данные задачи по id
   * @param id
   * @param task
   */
  @PutMapping ("/update/{id}")
  public void updateTask(@PathVariable("id") long id, @RequestBody Task task){
    service.updateTask(id, task);
  }

  /**
   * Получить список задач с определённым статусом
   * @param status
   * @return
   */
  @GetMapping("/status/{status}")
  public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
    List<Task> tasks = service.getTaskByStatus(status);
    System.out.println(tasks.toString());
    return tasks;
  }



}
