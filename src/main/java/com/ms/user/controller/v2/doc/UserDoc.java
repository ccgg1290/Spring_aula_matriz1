package com.ms.user.controller.v2.doc;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// si se consume http://localhost:8081/swagger-ui/index.html
@Tag(name = "User" , description = "API exposed for management all user")
@RequestMapping("/api/v2/user")
public interface UserDoc {


    @Operation(summary = "create user"
    ,description = "This operation is for creating user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "user Created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "endpoint not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @PostMapping
    ResponseEntity<UserEntity> create(@Valid @RequestBody UserDto userDto);

    @Operation(summary = "get users"
            ,description = "This operation is for get all the users")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List of users",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "endpoint not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @GetMapping
     ResponseEntity<?> getAll();


    @Operation(
            summary = "find by id user",
            description = "This operation is for finding a user by ID. If the user with the specified ID is found, it will be returned. ID must be provided in the path parameter.")
    @ApiResponse(
            responseCode = "200",
            description = "The user with the specified ID was found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
    )
    @GetMapping("/{id}")
    ResponseEntity<UserEntity> getById(@PathVariable String id);

    @Operation(
            summary ="delete user"
            ,description = "this operation is for delete a user"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "user deleted",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "404",
                            description = "endpoint not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "500",
                            description = "internal server Error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") String id);


    @Operation(summary = "Get users by type document and document")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List of users",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "endpoint not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @GetMapping("/find-by-document/")
    ResponseEntity<UserEntity> getByDocumentAndTypeDocument(@RequestParam String document, @RequestParam String typeDocument);

    @Operation(summary = "update user"
            ,description = "This operation is for update user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "user update",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "endpoint not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })

    @PatchMapping("/{id}")
    ResponseEntity<UserEntity> updateById(@RequestBody UserEntity userEntity ,@PathVariable("id") String id);


    @GetMapping("/test-error")
    ResponseEntity<?> testError(@RequestParam("message") String message);
}