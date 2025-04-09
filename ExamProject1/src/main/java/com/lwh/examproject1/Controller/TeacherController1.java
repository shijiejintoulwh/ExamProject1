@PostMapping("/add")
public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher) {
    try {
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

@PutMapping("/{id}")
public ResponseEntity<?> updateTeacher(@PathVariable String id, @RequestBody Teacher teacher) {
    teacher.setTid(id);
    teacherService.updateTeacher(teacher);
    return ResponseEntity.ok().build();
}