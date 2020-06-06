package com.uabc.edu.appswbd.demo_examen.web;

import java.util.List;
import java.util.Optional;

import com.uabc.edu.appswbd.demo_examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.demo_examen.model.CursosEntity;
import com.uabc.edu.appswbd.demo_examen.service.CursosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cursos")
public class CursosMvcController {

    @Autowired
    CursosService service;

    @RequestMapping("/todos")
    public String getAllCourses(Model model) {
        List<CursosEntity> list = service.getAllCourses();
        model.addAttribute("coursees", list);
        return "list-courses";
    }

    @RequestMapping(path = { "/edit", "/edit/{idC}" })
    public String editCoursesById(Model model, @PathVariable("idC") Optional<Long> idC) throws RecordNotFoundException {
        if (idC.isPresent()) {
            CursosEntity entity = service.getCoursesById(idC.get());
            model.addAttribute("courses", entity);
        } else {
            model.addAttribute("courses", new CursosEntity());
        }
        return "add-edit-courses";
    }

    @RequestMapping(path = "/delete/{idC}")
    public String deleteCoursesById(Model model, @PathVariable("idC") Long idC) throws RecordNotFoundException {
        service.deleteCoursesById(idC);
        return "redirect:/cursos/todos";
    }

    @RequestMapping(path = "/createCourses", method = RequestMethod.POST)
    public String createOrUpdateCourses(CursosEntity courses) throws RecordNotFoundException {
        service.createOrUpdateCourses(courses);
        return "redirect:/cursos/todos";
    }

}
