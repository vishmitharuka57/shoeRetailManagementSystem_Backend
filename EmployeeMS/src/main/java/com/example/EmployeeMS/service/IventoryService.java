package com.example.EmployeeMS.service;


import com.example.EmployeeMS.dto.EmployeeDTO;
import com.example.EmployeeMS.dto.IventoryDTO;
import com.example.EmployeeMS.entity.Employee;
import com.example.EmployeeMS.entity.Iventory;
import com.example.EmployeeMS.repo.EmployeeRepo;
import com.example.EmployeeMS.repo.IventoryRepo;
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
public class IventoryService {
    //EmployeeRepo interface ek inject krgnna tamai meka use kle
    @Autowired
    private IventoryRepo iventoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    public String saveIventory(IventoryDTO iventoryDTO){
        if (iventoryRepo.existsById(iventoryDTO.getItemCode())){
            return VarList.RSP_DUPLICATED;
        }else{
            iventoryRepo.save(modelMapper.map(iventoryDTO, Iventory.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateIventory(IventoryDTO iventoryDTO){ //employee kenek update krnna
        if (iventoryRepo.existsById(iventoryDTO.getItemCode())){
            iventoryRepo.save(modelMapper.map(iventoryDTO, Iventory.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<IventoryDTO> getAllIventories(){
        List<Iventory> iventoryList = iventoryRepo.findAll();
        return modelMapper.map(iventoryList, new TypeToken<ArrayList<IventoryDTO>>(){
        }.getType());
    }

    public IventoryDTO searchIventory(int itemCode){
        if (iventoryRepo.existsById(itemCode)){
            Iventory iventory = iventoryRepo.findById(itemCode).orElse(null);
            return modelMapper.map(iventory, IventoryDTO.class );
        }else{
            return null;
        }
    }

    public String deleteIventory(int itemCode){
        if (iventoryRepo.existsById(itemCode)){
            iventoryRepo.deleteById(itemCode);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
