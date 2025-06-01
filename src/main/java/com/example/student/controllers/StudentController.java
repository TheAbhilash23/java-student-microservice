package com.example.student.controllers;

import com.example.student.dto.StudentDto;
import com.example.student.services.interfaces.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name = "User Management", description = "APIs for managing users")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "No items found")
    })
    @GetMapping("")
    public List<StudentDto> studentList() {
        return studentService.getList();
    }

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "No items found")
    })
    @PostMapping("/")
    public StudentDto createStudent(@RequestBody StudentDto data) {
        return studentService.createRecord(data);
    }

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "No items found")
    })
    @PatchMapping("{id}/")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto data) {
        return studentService.updateRecord(id, data);
    }

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "No items found")
    })
    @GetMapping("{id}")
    public StudentDto retrieveStudent(@PathVariable Long id){
        return studentService.getById(id);
    }

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "No items found")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteRecord(id);
        return new ResponseEntity<>("User with id: " + id + "deleted successfully", HttpStatus.NO_CONTENT);
    }

}
