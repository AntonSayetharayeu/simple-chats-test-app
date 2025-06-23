package testapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import testapp.dto.request.RegisterDTO;
import testapp.dto.request.UserUpdateDTO;
import testapp.dto.responce.LoggedUserDTO;
import testapp.dto.responce.UserDTO;
import testapp.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "userName", target = "name")
    @Mapping(source = "userEmail", target = "email")
    @Mapping(source = "userPassword", target = "password")
    User toEntity(RegisterDTO dto);

    @Mapping(source = "id", target = "userID")
    @Mapping(source = "name", target = "userName")
    @Mapping(source = "email", target = "userEmail")
    @Mapping(source = "createdAt", target = "userCreatedAt")
    UserDTO toResponseDTO(User user);

    @Mapping(source = "id", target = "userID")
    @Mapping(source = "name", target = "userName")
    LoggedUserDTO toLoggedResponseDTO(User user);

    @Mapping(source = "userName", target = "name")
    @Mapping(source = "userEmail", target = "email")
    @Mapping(source = "userPassword", target = "password")
    void updateUserFromDto(UserUpdateDTO dto, @MappingTarget User user);
}
