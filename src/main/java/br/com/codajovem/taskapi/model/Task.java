package br.com.codajovem.taskapi.model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_task")
    private Long id;

    @Column(name = "nm_task", nullable = false)
    private String name;

    @Column(name = "ds_task", nullable = false)
    private String description;

    @Column(name = "st_task", nullable = false, length = 5)
    private String status;

}
