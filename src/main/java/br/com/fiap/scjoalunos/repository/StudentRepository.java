package br.com.fiap.scjoalunos.repository;

import br.com.fiap.scjoalunos.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findAllByNameContaining(String name);

    @Query(value = "from StudentEntity where name like :name")
    List<StudentEntity> listarPorNome(String name);

}
