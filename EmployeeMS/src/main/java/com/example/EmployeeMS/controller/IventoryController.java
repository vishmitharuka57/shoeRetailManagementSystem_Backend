package com.example.EmployeeMS.controller;


import com.example.EmployeeMS.dto.EmployeeDTO;
import com.example.EmployeeMS.dto.IventoryDTO;
import com.example.EmployeeMS.dto.ResponseDTO;
import com.example.EmployeeMS.service.EmployeeService;
import com.example.EmployeeMS.service.IventoryService;
import com.example.EmployeeMS.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //meka rest api ekk nisa rest controller ek dagannawa
@RequestMapping("api/v1/iventory")
@CrossOrigin
public class IventoryController {
    @Autowired
    private IventoryService iventoryService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveIventory")         //save krn ekk hnd postMapping annotation ek use krnne
    public ResponseEntity saveIventory(@RequestBody IventoryDTO iventoryDTO){//data tika genna ganne requestBody eka athule
        try{
            String res = iventoryService.saveIventory(iventoryDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("save Success");
                responseDTO.setContent(iventoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Iventory Registered");
                responseDTO.setContent(iventoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping (value = "/updateIventory")         //update krn ekk hnd putMapping annotation ek use krnne
    public ResponseEntity updateIventory(@RequestBody IventoryDTO iventoryDTO){//data tika genna ganne requestBody eka athule
        try{
            String res = iventoryService.updateIventory(iventoryDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("save Success");
                responseDTO.setContent(iventoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not A Registered Iventory");
                responseDTO.setContent(iventoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllIventories") //get all employees
    public ResponseEntity getAllIventories(){
        try{
            List<IventoryDTO> iventoryDTOList = iventoryService.getAllIventories();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(iventoryDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchIventory/{itemCode}")
    public ResponseEntity searchIventory(@PathVariable int itemCode){
        try{
            IventoryDTO iventoryDTO = iventoryService.searchIventory(itemCode);
            if (iventoryDTO != null){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(iventoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else{
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Iventory Available For This itemCode");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(ex);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteIventory/{itemCode}")
    public ResponseEntity deleteIventory(@PathVariable int itemCode){
        try{
            String  res = iventoryService.deleteIventory(itemCode);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else{
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Iventory Available For This empCode");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(ex);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
