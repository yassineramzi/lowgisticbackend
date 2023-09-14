package com.lowgistic.management.service.impl;

import com.lowgistic.management.domain.Role;
import com.lowgistic.management.domain.User;
import com.lowgistic.management.enums.ERole;
import com.lowgistic.management.repository.RoleRepository;
import com.lowgistic.management.repository.UserRepository;
import com.lowgistic.management.sender.Sender;
import com.lowgistic.management.service.UserService;
import com.lowgistic.management.service.dto.RoleDto;
import com.lowgistic.management.service.dto.UserDto;
import com.lowgistic.management.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final Sender emailSender;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, Sender emailSender) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
    }

    @Override
    public UserDto create(UserDto userDto) throws Exception {
        log.info("Request to save User : {}", userDto);
        if(this.userRepository.existsByEmail(userDto.getEmail())){
            throw new Exception("User existe already with this email : "+ userDto.getEmail());
        }
        User user = userMapper.toEntity(userDto);
        // Set password
        String password = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        // Set role
        Set<Role> roles = new HashSet<>();
        userDto.getRoles().add(new RoleDto(ERole.ROLE_ADMIN));
        userDto.getRoles().parallelStream().forEach(
                roleDTO -> {
                    Optional<Role> optionalRole = this.roleRepository.findByNomRole(roleDTO.getNomRole());
                    optionalRole.ifPresent(roles::add);
                }
        );
        user.setRoles(roles);
        // Save user
        user = userRepository.save(user);
        // Send mail
        UserDto returnedUser = userMapper.toDto(user);
        returnedUser.setPassword(password);
        this.emailSender.send("USER_REGISTERED_TOPIC", returnedUser);
        return returnedUser;
    }
}
