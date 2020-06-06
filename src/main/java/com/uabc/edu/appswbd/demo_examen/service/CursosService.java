package com.uabc.edu.appswbd.demo_examen.service;

import com.uabc.edu.appswbd.demo_examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.demo_examen.model.CursosEntity;
import com.uabc.edu.appswbd.demo_examen.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursosService {
        @Autowired
       CursosRepository repository;

        public List<CursosEntity> getAllCourses()
        {
            List<CursosEntity> result = (List<CursosEntity>) repository.findAll();

            if(result.size() > 0) {
                return result;
            } else {
                return new ArrayList<CursosEntity>();
            }
        }


    public CursosEntity getCoursesById(Long idC) throws RecordNotFoundException
        {
            Optional<CursosEntity> courses = repository.findById(idC);

            if(courses.isPresent()) {
                return courses.get();
            } else {
                throw new RecordNotFoundException("No courses record exist for given id");
            }
        }

        public CursosEntity createOrUpdateCourses(CursosEntity entity)throws RecordNotFoundException
        {
            if(entity.getIdC()  == null)
            {
                entity = repository.save(entity);

                return entity;
            }
            else
            {
                Optional<CursosEntity> courses = repository.findById(entity.getIdC());

                if(courses.isPresent())
                {
                    CursosEntity CnewEntity = courses.get();
                    CnewEntity.setNameCurso(entity.getNameCurso());
                    CnewEntity.setDescripCurso(entity.getDescripCurso());
                    CnewEntity.setDuracionCurso(entity.getDuracionCurso());
                    CnewEntity.setUrlCurso(entity.getUrlCurso());

                    CnewEntity = repository.save(CnewEntity);
                    return CnewEntity;
                } else {
                    entity = repository.save(entity);

                    return entity;
                }
            }
        }

        public void deleteCoursesById(Long id) throws RecordNotFoundException
        {
            Optional<CursosEntity> courses = repository.findById(id);

            if(courses.isPresent())
            {
                repository.deleteById(id);
            } else {
                throw new RecordNotFoundException("No courses record exist for given id");
            }
        }



}

