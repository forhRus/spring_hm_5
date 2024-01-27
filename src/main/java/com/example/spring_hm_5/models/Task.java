package com.example.spring_hm_5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tasks")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false)
  private String discription;
  @Column(nullable = false)
  private TaskStatus status;
  @Column(nullable = false)
  private LocalDateTime date;

  /**
   * Конструктор для создания задачи по одному лишь описанию
   * (время будет LocalDateTime.now(), а статус NOT_STARTED )
   * @param discription
   */
  public Task(String discription) {
    this.discription = discription;
    status = TaskStatus.NOT_STARTED;
    date = LocalDateTime.now();
  }


}
