package com.uabc.edu.appswbd.demo_examen.web;

import java.util.List;
import java.util.Optional;

import com.uabc.edu.appswbd.demo_examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.demo_examen.model.CursosEntity;
import com.uabc.edu.appswbd.demo_examen.model.EmployeeEntity;
import com.uabc.edu.appswbd.demo_examen.model.TakeCourseEntity;
import com.uabc.edu.appswbd.demo_examen.service.CursosService;
import com.uabc.edu.appswbd.demo_examen.service.EmployeeService;
import com.uabc.edu.appswbd.demo_examen.service.TakeCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tomarcurso")
public class TakeCourseMvcController {

    @Autowired
    TakeCourseService service;
    @Autowired
    CursosService cursosService;
    @Autowired
    EmployeeService empleadoServicio;

    @RequestMapping("/todos")
    public String getAllTakeCourses(Model model) {
        List<TakeCourseEntity> list = service.getAllTakeCourses();

        model.addAttribute("takecoursees", list);
        return "list-take-course";
    }

    @RequestMapping(path = { "/edit", "/edit/{idTC}" })
    public String editTakeCourseById(Model model, @PathVariable("idTC") Optional<Integer> idTC)
            throws RecordNotFoundException {
        if (idTC.isPresent()) {
            TakeCourseEntity entity = service.getTakeCourseById(idTC.get());
            model.addAttribute("takecourses", entity);
        } else {
            model.addAttribute("takecourses", new TakeCourseEntity());
        }
        List<CursosEntity> cursos = cursosService.getAllCourses(); 
        List<EmployeeEntity> empleados = empleadoServicio.getAllEmployees(); 
        model.addAttribute("cursos", cursos);
        model.addAttribute("empleados", empleados);
        return "take-course";
    }

    @RequestMapping(path = "/delete/{idTC}")
    public String deleteTakeCourseById(Model model, @PathVariable("idTC") Integer idTC) throws RecordNotFoundException {
        service.deleteTakeCourseById(idTC);
        return "redirect:/tomarcurso/todos";
    }

    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public String createOrUpdateTakeCourse(TakeCourseEntity takecourses) {
        service.createOrUpdateTakeCourse(takecourses);
        return "redirect:/tomarcurso/todos";
    }

}
