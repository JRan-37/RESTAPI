package api2.Controllers;

import java.util.*;
import api2.Entities.Doctor;
import api2.Services.DoctorService;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping("/doctors")
    public List<Doctor> list() {
        return service.listAll();
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Integer id) {
        try {
            Doctor doctor = service.get(id);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/doctors")
    public void add(@RequestBody Doctor doctor) {
        service.save(doctor);
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<?> update(@RequestBody Doctor doctor, @PathVariable Integer id) {
        try {
            Doctor existPatient = service.get(id);
            service.save(doctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/doctors/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
