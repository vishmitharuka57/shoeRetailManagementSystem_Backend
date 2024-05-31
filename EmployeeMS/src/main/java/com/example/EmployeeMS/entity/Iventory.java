package com.example.EmployeeMS.entity;

import com.example.EmployeeMS.enums.Category;
import com.example.EmployeeMS.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Iventory")
public class Iventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//meken apita auto empCode eka genarate krgnna puluwn
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
