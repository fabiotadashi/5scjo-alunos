package br.com.fiap.scjoalunos.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_STUDENTS")
@EntityListeners(AuditingEntityListener.class)
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String ra;

    @Column(updatable = false, nullable = false)
    @CreatedDate
    private Date createdDate;

    @Column(updatable = true, nullable = false)
    @LastModifiedDate
    private Date lastCreatedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastCreatedDate() {
        return lastCreatedDate;
    }

    public void setLastCreatedDate(Date lastCreatedDate) {
        this.lastCreatedDate = lastCreatedDate;
    }
}
