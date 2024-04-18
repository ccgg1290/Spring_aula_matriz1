package com.ms.user.controller.v1;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ejemplo")
public class EjemploController {

    @GetMapping("/sumar")
    public int sumar(@RequestParam("valor1") int valor1 ,@RequestParam("valor2")  int valor2){
        return valor1+valor2;
    }


    @GetMapping("/{name}")
    public String saludo(@PathVariable("name") String name){
        return """
                welcome to aulamatriz %s"""
                .formatted(name);
    }

    @GetMapping()
    public String saludDefaulto(){
        return """
                welcome to aulamatriz""";
    }

}
