package com.uabc.edu.appswbd.demo_examen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.uabc.edu.appswbd.demo_examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.demo_examen.model.EmployeeEntity;
import com.uabc.edu.appswbd.demo_examen.model.TakeCourseEntity;
import com.uabc.edu.appswbd.demo_examen.repository.EmployeeRepository;
import com.uabc.edu.appswbd.demo_examen.repository.TakeCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakeCourseService {

    @Autowired
    TakeCourseRepository repository;

    public List<TakeCourseEntity> getAllTakeCourses() {
        List<TakeCourseEntity> result = (List<TakeCourseEntity>) repository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<TakeCourseEntity>();
        }
    }

    public TakeCourseEntity getTakeCourseById(Integer idTC) throws RecordNotFoundException {
        Optional<TakeCourseEntity> takecourses = repository.findById(idTC);

        if (takecourses.isPresent()) {
            return takecourses.get();
        } else {
            throw new RecordNotFoundException("No takecourse record exist for given id");
        }
    }

    public TakeCourseEntity createOrUpdateTakeCourse(TakeCourseEntity entity) {
        if (entity.getIdTC() == null) {
            entity = repository.save(entity);

            return entity;
        } else {
            Optional<TakeCourseEntity> takecourses = repository.findById(entity.getIdTC());

            if (takecourses.isPresent()) {
                TakeCourseEntity newEntity = takecourses.get();
                newEntity.setEmployee(entity.getEmployee());
                newEntity.setCourse(entity.getCourse());
                newEntity.setDateC(entity.getDateC());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteTakeCourseById(Integer idTC) throws RecordNotFoundException {
        Optional<TakeCourseEntity> takecourses = repository.findById(idTC);

        if (takecourses.isPresent()) {
            repository.deleteById(idTC);
        } else {
            throw new RecordNotFoundException("No takecourse record exist for given id");
        }
    }
}
