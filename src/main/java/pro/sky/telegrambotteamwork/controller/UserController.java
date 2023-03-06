package pro.sky.telegrambotteamwork.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambotteamwork.model.User;
import pro.sky.telegrambotteamwork.service.UserService;

@RestController
@RequestMapping("user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Информация о пользователе",
            description = "Позволяет получить информацию о пользователе из системы")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = User.class))
    )

    @GetMapping("{id}")
    public User getUserInfo(@PathVariable Long id) {
        return userService.readInfo(id);
    }

    @Operation(
            summary = "Регистрация нового пользователя",
            description = "Позволяет зарегистрировать нового пользователя в системе")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = User.class))
    )

    @PostMapping
    public HttpStatus registerNewUser(@RequestBody User user) {
        userService.addUser(user);
        return HttpStatus.OK;
    }

    @Operation(
            summary = "Удаление пользователя",
            description = "Позволяет удалить пользователя из системы")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation =  User.class))
    )

    @DeleteMapping
    public HttpStatus deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return HttpStatus.OK;
    }
}