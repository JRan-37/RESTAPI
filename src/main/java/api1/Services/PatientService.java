package api1.Services;

import java.util.List;

import javax.transaction.Transactional;

import api1.Entities.Patient;
import api1.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<Patient> listAll() {
        return repo.findAll();
    }

    public void save(Patient patient) {
        repo.save(patient);
    }

    public Patient get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
