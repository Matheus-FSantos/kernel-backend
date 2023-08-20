package io.github.MatheusFSantos.Kernel.KNUsers.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_backup")
public class UsersBackup {

    @Id
    private String id;

    @Column(nullable=false)
    private String data;

    @Column(nullable=false)
    private LocalDateTime createdAt;
    
}
