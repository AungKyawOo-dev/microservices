package com.aungkyawoo.user_service.service.impl;

import com.aungkyawoo.user_service.dto.request.CreateUserRequestDto;
import com.aungkyawoo.user_service.entity.User;
import com.aungkyawoo.user_service.exception.UserAlreadyExistsException;
import com.aungkyawoo.user_service.mapper.UserMapper;
import com.aungkyawoo.user_service.repository.UserRepository;
import com.aungkyawoo.user_service.service.IUserService;
import com.aungkyawoo.user_service.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    /** Inject User Service */
    private final UserRepository userRepository;

    @Override
    public void createUser(CreateUserRequestDto userRequestDto) {
        User user = UserMapper.mapUserDtoToUser(userRequestDto);
        user.setId(StringUtils.getUUID());
        Optional<User> optionalCustomer = userRepository.findByEmail(user.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new UserAlreadyExistsException("User already registered with email: " + user.getEmail());
        }
        userRepository.save(user);
    }
}
