package api1.Controllers;

import java.util.*;
import api1.Entities.Patient;
import api1.Services.PatientService;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/patients")
    public List<Patient> list() {
        return service.listAll();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> get(@PathVariable Integer id) {
        try {
            Patient patient = service.get(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patients")
    public void add(@RequestBody Patient patient) {
        service.save(patient);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<?> update(@RequestBody Patient patient, @PathVariable Integer id) {
        try {
            Patient existPatient = service.get(id);
            service.save(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patients/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
