package api2.Services;

import java.util.List;

import javax.transaction.Transactional;

import api2.Entities.Doctor;
import api2.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    public List<Doctor> listAll() {
        return repo.findAll();
    }

    public void save(Doctor patient) {
        repo.save(patient);
    }

    public Doctor get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
