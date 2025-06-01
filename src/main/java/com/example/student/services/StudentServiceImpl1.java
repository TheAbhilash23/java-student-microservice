package com.example.student.services;

import com.example.student.dto.StudentDto;
import com.example.student.entities.StudentEntity;
import com.example.student.repositories.StudentRepository;
import com.example.student.services.interfaces.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl1 implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getList() {
        return studentRepository.findAll().stream().map(x -> StudentDto.builder().id(x.getId()).name(x.getName()).contactNumber(x.getContactNumber()).build()).toList();
    }

    @Override
    public StudentDto getById(Long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id.toString());
        if (studentEntity.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }
        return StudentDto.builder().id(studentEntity.get().getId()).name(studentEntity.get().getName()).contactNumber(studentEntity.get().getContactNumber()).build();
    }

    @Override
    public StudentDto createRecord(StudentDto studentDto) {
        StudentEntity student = StudentEntity.builder().name(studentDto.getName()).contactNumber(studentDto.getContactNumber()).build();
        studentRepository.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    @Override
    public StudentDto updateRecord(Long id, StudentDto studentDto) {
        Optional<StudentEntity> oldStudentEntity = studentRepository.findById(id.toString());
        if (oldStudentEntity.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }
        StudentEntity updatedStudent = StudentEntity.builder().
                name(studentDto.getName().isBlank() ? oldStudentEntity.get().getName() : studentDto.getName()).
                contactNumber(studentDto.getContactNumber().isBlank() ? oldStudentEntity.get().getContactNumber() : studentDto.getContactNumber()).
                build();
        studentRepository.save(updatedStudent);
        return studentDto;
    }

    @Override
    public void deleteRecord(Long id) {

        try{
            studentRepository.deleteById(id.toString());
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("User Not Found");
        }
    }
}
