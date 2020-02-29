/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.invierno;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControladorAlumno {
    @Autowired RepositorioAlumno repoAlumno;
 
   
   @GetMapping("/alumno")
   public List<Alumno> buscarTodos(){
    
       return repoAlumno.findAll();
}
   
   @PostMapping("/alumno")
   public Estatus guardar(@RequestBody String json)throws Exception{
       
      ObjectMapper maper=new ObjectMapper();
      Alumno a=maper.readValue(json, Alumno.class);
      repoAlumno.save(a);
      Estatus e=new Estatus();
      e.setMensaje("Guardado con exitooooo");
      e.setSuccess(true);
      return e;
   }
    
}
