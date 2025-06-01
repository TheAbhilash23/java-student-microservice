package com.example.student.services.interfaces;

import com.example.student.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getList();

    StudentDto getById(Long id);

    StudentDto createRecord(StudentDto studentDto);

    StudentDto updateRecord(Long id, StudentDto studentDto);

    void deleteRecord(Long id);

}
