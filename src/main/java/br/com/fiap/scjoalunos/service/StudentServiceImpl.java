package br.com.fiap.scjoalunos.service;

import br.com.fiap.scjoalunos.dto.CreateUpdateStudentDTO;
import br.com.fiap.scjoalunos.dto.StudentDTO;
import br.com.fiap.scjoalunos.entity.StudentEntity;
import br.com.fiap.scjoalunos.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> list(String nome) {
        return studentRepository.findAll()
                .stream()
                .map(entity -> {
                    StudentDTO dto = new StudentDTO();
                    dto.setId(entity.getId());
                    dto.setName(entity.getName());
                    dto.setRa(entity.getRa());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Integer id) {
        StudentEntity entity = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRa(entity.getRa());
        return dto;
    }

    @Override
    public StudentDTO create(CreateUpdateStudentDTO createUpdateStudentDTO) {
        StudentEntity entity = new StudentEntity();
        entity.setName(createUpdateStudentDTO.getName());
        entity.setRa(createUpdateStudentDTO.getRa());

        StudentEntity savedEntity = studentRepository.save(entity);

        StudentDTO dto = new StudentDTO();
        dto.setId(savedEntity.getId());
        dto.setName(savedEntity.getName());
        dto.setRa(savedEntity.getRa());
        return dto;
    }

    @Override
    public StudentDTO update(Integer id, CreateUpdateStudentDTO createUpdateStudentDTO) {
        StudentEntity entity = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setName(createUpdateStudentDTO.getName());
        entity.setRa(createUpdateStudentDTO.getRa());

        StudentEntity savedEntity = studentRepository.save(entity);

        StudentDTO dto = new StudentDTO();
        dto.setId(savedEntity.getId());
        dto.setName(savedEntity.getName());
        dto.setRa(savedEntity.getRa());
        return dto;
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

}
