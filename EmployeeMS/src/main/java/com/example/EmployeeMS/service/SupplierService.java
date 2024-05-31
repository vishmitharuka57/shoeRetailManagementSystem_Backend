package com.example.EmployeeMS.service;

import com.example.EmployeeMS.dto.EmployeeDTO;
import com.example.EmployeeMS.dto.SupplierDTO;
import com.example.EmployeeMS.entity.Employee;
import com.example.EmployeeMS.entity.Supplier;
import com.example.EmployeeMS.repo.SupplierRepo;
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
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveSupplier(SupplierDTO supplierDTO){
        if (supplierRepo.existsById(supplierDTO.getSupCode())){
            return VarList.RSP_DUPLICATED;
        }else{
            supplierRepo.save(modelMapper.map(supplierDTO, Supplier.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateSupplier(SupplierDTO supplierDTO){
        if (supplierRepo.existsById(supplierDTO.getSupCode())){
            supplierRepo.save(modelMapper.map(supplierDTO, Supplier.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<SupplierDTO> getAllSuppliers(){
        List<Supplier>supplierList = supplierRepo.findAll();
        return modelMapper.map(supplierList, new TypeToken<ArrayList<SupplierDTO>>(){}.getType());

    }

    public SupplierDTO searchSupplier(int supCode){
        if (supplierRepo.existsById(supCode)){
            Supplier supplier  = supplierRepo.findById(supCode).orElse(null);
            return modelMapper.map(supplier, SupplierDTO.class );
        }else{
            return null;
        }
    }

    public String deleteSupplier(int supCode){
        if (supplierRepo.existsById(supCode)){
            supplierRepo.deleteById(supCode);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
