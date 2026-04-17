package br.edu.imepac.api_student.controllers;

import br.edu.imepac.api_student.entities.Student;
import br.edu.imepac.api_student.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Student student) {
        Student studentSave = studentService.create(student);
        return ResponseEntity.ok(studentSave);
    }

    @GetMapping
    public ResponseEntity<List<Student>> listar() {
        List<Student> studentsListAll = studentService.listarTodos();
        return ResponseEntity.ok(studentsListAll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        studentService.deletar(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> buscarPorId(@PathVariable Long id) {
        Student studentlistID = studentService.buscarPorId(id);
        return ResponseEntity.ok(studentlistID);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> atualizar(@PathVariable Long id, @RequestBody Student student) {
        Student studentAtt = studentService.atualizarStudent(id, student);
        return ResponseEntity.ok(studentAtt);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Student> atualizarParcial(@PathVariable Long id, @RequestBody Student student) {
        Student studentAtt = studentService.atualizarParcial(id, student);
        return ResponseEntity.ok(studentAtt);
    }
}
