package br.edu.imepac.api_student.services;

import br.edu.imepac.api_student.entities.Student;
import br.edu.imepac.api_student.repositores.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> listarTodos() {
        return studentRepository.findAll();
    }

    public void deletar(Long id) {
        studentRepository.deleteById(id);
    }

    public Student buscarPorId(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student atualizarStudent(Long id, Student student) {
        Student student1 = buscarPorId(id);
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        return studentRepository.save(student1);
    }
    public Student atualizarParcial(Long id, Student student) {
        Student studentExistente = buscarPorId(id);

        if (student.getName() != null) {
            studentExistente.setName(student.getName());
        }

        if (student.getEmail() != null) {
            studentExistente.setEmail(student.getEmail());
        }

        return studentRepository.save(studentExistente);
    }
}
