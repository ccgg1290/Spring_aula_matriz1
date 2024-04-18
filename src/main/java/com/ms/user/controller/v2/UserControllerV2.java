package com.ms.user.controller.v2;

import com.ms.user.controller.v2.doc.UserDoc;
import com.ms.user.dto.UserDto;
import com.ms.user.exception.MyHandleException;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class UserControllerV2 implements UserDoc {

    private final IUserService iUserService;

  //  public UserControllerV2(IUserService iUserService) {
    //    this.iUserService = iUserService;
    //}

    @Override
    public ResponseEntity<UserEntity> create(UserDto userDto) {
        return  this.iUserService.create(userDto);
    }

    @Override
    public ResponseEntity<?> getAll(){
        return this.iUserService.getAll();
    }

    @Override
    public ResponseEntity<UserEntity> getById(String id) {
        return this.iUserService.getById(id);
    }
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        return this.iUserService.deleteById(id);
    }

    @Override
    public ResponseEntity<UserEntity> getByDocumentAndTypeDocument(String document, String typeDocument)
    {
        return this.iUserService.getByDocumentTypeDocument(document, typeDocument);
    }
    @Override
    public ResponseEntity<UserEntity> updateById(UserEntity userEntity, String id) {
        return iUserService.updateById(userEntity,id);
    }

    @Override
    public ResponseEntity<?> testError(String message) {
        throw new MyHandleException(message);
    }
}
