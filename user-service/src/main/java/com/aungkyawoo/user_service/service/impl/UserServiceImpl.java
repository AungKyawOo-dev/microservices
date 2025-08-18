package com.aungkyawoo.user_service.service.impl;

import com.aungkyawoo.user_service.dto.UserDto;
import com.aungkyawoo.user_service.dto.request.UserRequestDto;
import com.aungkyawoo.user_service.entity.User;
import com.aungkyawoo.user_service.exception.ResourceNotFoundException;
import com.aungkyawoo.user_service.exception.UserAlreadyExistsException;
import com.aungkyawoo.user_service.repository.UserRepository;
import com.aungkyawoo.user_service.service.IUserService;
import com.aungkyawoo.user_service.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.aungkyawoo.user_service.mapper.UserMapper.mapUserDtoToUser;
import static com.aungkyawoo.user_service.mapper.UserMapper.mapUserToUserDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    /** Inject User Service */
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setId(StringUtils.getUUID());
        mapUserDtoToUser(userRequestDto, user);
        Optional<User> optionalCustomer = userRepository.findByEmail(user.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new UserAlreadyExistsException("User already registered with email: " + user.getEmail());
        }
        userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto fetchUser(String id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User", "ID", id));
        return mapUserToUserDto(user);
    }

    @Override
    public void updateUser(String id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User", "ID", id));
        mapUserDtoToUser(userRequestDto, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User", "ID", id));
        userRepository.delete(user);
    }


}
