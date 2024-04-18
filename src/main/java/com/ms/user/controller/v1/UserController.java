package com.ms.user.controller.v1;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService iUserService;

   // public UserController(IUserService iUserService) {
     //   this.iUserService = iUserService;
    //}

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserDto userDto){
        return  this.iUserService.create(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll(){
        return  this.iUserService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(
            @PathVariable("id") String id
    ){
        return this.iUserService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        return this.iUserService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserEntity> updateById(@RequestBody UserEntity userEntity ,@PathVariable("id") String id){
        return  this.iUserService.updateById(userEntity,id);
    }

    @GetMapping("/document-type-document")
    public ResponseEntity<UserEntity> getByDocumentAndTypeDocument(@RequestParam("document") String document,
                                                                   @RequestParam("typeDocument")  String typeDocument){
        return this.iUserService.getByDocumentTypeDocument(document,typeDocument);
    }
}
