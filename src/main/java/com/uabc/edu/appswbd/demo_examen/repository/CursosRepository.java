package com.uabc.edu.appswbd.demo_examen.repository;

import com.uabc.edu.appswbd.demo_examen.model.CursosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends CrudRepository<CursosEntity, Long> {
}
