package com.example.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "user", description = "the user API")
@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersRepository repository;
    private final UsersService service;

    public UsersController(UsersRepository repository, UsersService service) {
        this.repository = repository;
        this.service = service;
    }

    @Operation(summary = "Update an existing user", description = "Update an existing user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
    })
    @PutMapping(value = "/{id}", consumes = "application/json")
    public User updateUser(
            @Parameter(description = "Update an existing user", required = true) @RequestBody User user,
            @Parameter(description = "User id to update", required = true) @PathVariable Long id) {
        return service.updateUser(user, id);
    }

    @Operation(summary = "Add a new user", description = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(
            @Parameter(description = "Create a new user", required = true) @RequestBody User user) {
        return service.createUser(user);
    }

    @Operation(summary = "Find user by ID", description = "Returns a single user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
    })
    @GetMapping(value = "/{id}", produces = "application/json" )
    public User getUser(
            @Parameter(description = "ID of user to return", required = true) @PathVariable Long id) {
        return service.getUserById(id);
    }

    @Operation(summary = "Get all Users", description = "Get all Users")
    @GetMapping(produces = "application/json")
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
