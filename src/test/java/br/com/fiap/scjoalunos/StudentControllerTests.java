package br.com.fiap.scjoalunos;

import br.com.fiap.scjoalunos.controller.StudentController;
import br.com.fiap.scjoalunos.dto.CreateUpdateStudentDTO;
import br.com.fiap.scjoalunos.dto.StudentDTO;
import br.com.fiap.scjoalunos.service.StudentService;
import br.com.fiap.scjoalunos.service.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StudentControllerTests {

	@Test
	void createStudent() {

		// Setup
		StudentService studentService = Mockito.mock(StudentServiceImpl.class);

		StudentController studentController = new StudentController(studentService);

		CreateUpdateStudentDTO createUpdateDTO = new CreateUpdateStudentDTO();

		// Mock
		StudentDTO mockStudent = new StudentDTO();
		mockStudent.setId(1);
		mockStudent.setName("Fabio");
		Mockito.when(studentService.create(createUpdateDTO)).thenReturn(mockStudent);

		// Call
		StudentDTO studentDTO = studentController.create(createUpdateDTO);

		// Assertions
		Assertions.assertEquals("Fabio", studentDTO.getName());
		Assertions.assertNotNull(studentDTO.getId());
	}

}
