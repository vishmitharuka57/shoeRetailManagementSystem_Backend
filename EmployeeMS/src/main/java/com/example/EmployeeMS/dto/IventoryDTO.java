package com.example.EmployeeMS.dto;

import com.example.EmployeeMS.enums.Category;
import com.example.EmployeeMS.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IventoryDTO {
    private int itemCode;
    private String itemDesc;
    private String itemPic;
    private Category itemCategory;
    private int itemSize;
    private int supCode;
    private String supName;
    private double unitPriceBuy;
    private double unitPriceSale;
    private double expectedProfit;
    private String profitMargin;
    private Status itemStatus;

}
