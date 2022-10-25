package br.com.fiap.scjoalunos.service;

import br.com.fiap.scjoalunos.dto.CreateUpdateStudentDTO;
import br.com.fiap.scjoalunos.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> list(String nome);
    StudentDTO findById(Integer id);
    StudentDTO create(CreateUpdateStudentDTO createUpdateStudentDTO);
    StudentDTO update(Integer id, CreateUpdateStudentDTO createUpdateStudentDTO);
    void delete(Integer id);

}
