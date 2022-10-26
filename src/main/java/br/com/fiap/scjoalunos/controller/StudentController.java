package br.com.fiap.scjoalunos.controller;

import br.com.fiap.scjoalunos.dto.CreateUpdateStudentDTO;
import br.com.fiap.scjoalunos.dto.StudentDTO;
import br.com.fiap.scjoalunos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> listAll(@RequestParam(required = false) String name){
        return studentService.list(name);
    }

    @GetMapping("{id}")
    public StudentDTO findById(@PathVariable Integer id){
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO create(@RequestBody CreateUpdateStudentDTO createUpdateStudentDTO){
        return studentService.create(createUpdateStudentDTO);
    }

    @PutMapping("{id}")
    public StudentDTO update(@PathVariable Integer id,
                             @RequestBody CreateUpdateStudentDTO createUpdateStudentDTO){
        return studentService.update(id, createUpdateStudentDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }

}
