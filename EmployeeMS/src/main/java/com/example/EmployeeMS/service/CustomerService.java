package com.example.EmployeeMS.service;


import com.example.EmployeeMS.dto.CustomerDTO;
import com.example.EmployeeMS.dto.EmployeeDTO;
import com.example.EmployeeMS.entity.Customer;
import com.example.EmployeeMS.entity.Employee;
import com.example.EmployeeMS.repo.CustomerRepo;
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
public class CustomerService {
    //EmployeeRepo interface ek inject krgnna tamai meka use kle
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveCustomer(CustomerDTO customerDTO){
        if (customerRepo.existsById(customerDTO.getCusCode())){
            return VarList.RSP_DUPLICATED;
        }else{
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateCustomer(CustomerDTO customerDTO){ //employee kenek update krnna
        if (customerRepo.existsById(customerDTO.getCusCode())){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customerList = customerRepo.findAll();
        return modelMapper.map(customerList, new TypeToken<ArrayList<CustomerDTO>>(){
        }.getType());
    }

    public CustomerDTO searchCustomer(int cusCode){
        if (customerRepo.existsById(cusCode)){
            Customer customer = customerRepo.findById(cusCode).orElse(null);
            return modelMapper.map(customer, CustomerDTO.class );
        }else{
            return null;
        }
    }

    public String deleteCustomer(int cusCode){
        if (customerRepo.existsById(cusCode)){
            customerRepo.deleteById(cusCode);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
