package br.com.fiap.scjoalunos.service;

import br.com.fiap.scjoalunos.dto.CreateUpdateStudentDTO;
import br.com.fiap.scjoalunos.dto.StudentDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<StudentDTO> list(String nome) {
        return null;
    }

    @Override
    public StudentDTO findById(Integer id) {
        return null;
    }

    @Override
    public StudentDTO create(CreateUpdateStudentDTO createUpdateStudentDTO) {
        return null;
    }

    @Override
    public StudentDTO update(Integer id, CreateUpdateStudentDTO createUpdateStudentDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
