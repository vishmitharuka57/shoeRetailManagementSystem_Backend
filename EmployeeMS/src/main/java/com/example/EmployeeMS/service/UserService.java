package com.example.EmployeeMS.service;

import com.example.EmployeeMS.dto.UserDTO;
import com.example.EmployeeMS.entity.User;
import com.example.EmployeeMS.repo.UserRepo;
import com.example.EmployeeMS.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    public String saveUser(UserDTO userDTO){
        if (userRepo.existsById(userDTO.username())){
            return VarList.RSP_DUPLICATED;
        }else{
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateUser(UserDTO userDTO){ //employee kenek update krnna
        if (userRepo.existsById(userDTO.username())){
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<ArrayList<UserDTO>>(){
        }.getType());
    }

    public UserDTO searchUser(String username){
        if (userRepo.existsById(username)){
            User user = userRepo.findById(username).orElse(null);
            return modelMapper.map(user, UserDTO.class );
        }else{
            return null;
        }
    }

    public String deleteUser(String username){
        if (userRepo.existsById(username)){
            userRepo.deleteById(username);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
