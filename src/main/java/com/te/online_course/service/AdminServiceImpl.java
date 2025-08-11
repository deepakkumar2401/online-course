package com.te.online_course.service;

import com.te.online_course.dto.RoleDto;
import com.te.online_course.entity.Role;
import com.te.online_course.exception.DataFoundException;
import com.te.online_course.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDto addRole(RoleDto roleDto) {
        Optional<Role> byName = roleRepository.findByName(roleDto.getName());
        if (byName.isEmpty()) {
            Role role = new Role();
            BeanUtils.copyProperties(roleDto, role);
            Role save = roleRepository.save(role);
            BeanUtils.copyProperties(save, roleDto);
            return roleDto;
        }
        throw new DataFoundException("Role already Exist");
    }
}
