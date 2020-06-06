package com.uabc.edu.appswbd.demo_examen.repository;

import com.uabc.edu.appswbd.demo_examen.model.TakeCourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeCourseRepository extends CrudRepository<TakeCourseEntity, Integer> {

}
