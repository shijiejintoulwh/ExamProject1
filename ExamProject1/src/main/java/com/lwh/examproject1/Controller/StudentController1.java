@PostMapping("/add")
public ResponseEntity<?> addStudent(@RequestBody Student student) {
    try {
        studentService.addStudent(student);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

@PutMapping("/{id}")
public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody Student student) {
    student.setSid(id);
    studentService.updateStudent(student);
    return ResponseEntity.ok().build();
}