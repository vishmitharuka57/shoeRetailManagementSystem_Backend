package com.example.EmployeeMS.service;

import com.example.EmployeeMS.dto.EmployeeDTO;
import com.example.EmployeeMS.entity.Employee;
import com.example.EmployeeMS.repo.EmployeeRepo;
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
public class EmployeeService {
    //EmployeeRepo interface ek inject krgnna tamai meka use kle
   @Autowired
   private EmployeeRepo employeeRepo;

   @Autowired
   private ModelMapper modelMapper;
    public String saveEmployee(EmployeeDTO employeeDTO){
        if (employeeRepo.existsById(employeeDTO.getEmpCode())){
            return VarList.RSP_DUPLICATED;
        }else{
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO){ //employee kenek update krnna
        if (employeeRepo.existsById(employeeDTO.getEmpCode())){
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<Employee> employeeList = employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>(){
        }.getType());
    }

    public EmployeeDTO searchRmployee(int empCode){
        if (employeeRepo.existsById(empCode)){
            Employee employee = employeeRepo.findById(empCode).orElse(null);
            return modelMapper.map(employee, EmployeeDTO.class );
        }else{
            return null;
        }
    }

    public String deleteEmployee(int empCode){
        if (employeeRepo.existsById(empCode)){
            employeeRepo.deleteById(empCode);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
