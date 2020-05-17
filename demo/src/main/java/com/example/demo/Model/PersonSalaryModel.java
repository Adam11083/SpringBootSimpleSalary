package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * PersonSalaryModel
 * 人员工资数据模型
 */
@Document(collection = "PersonSalary")
public class PersonSalaryModel {
    // MongoDB Id
    @Id
    private String id;
    // 姓名
    private String name;
    // 应发工资
    private NetPayModel NetPay;
    // 应扣费用
    private DeductPayModel DeductPay;
    // 实发工资
    private float PayTotal;

    // ** Default Constructor *****************************************************************
    protected PersonSalaryModel() {};

    // ** Custom Constructor *****************************************************************
    public PersonSalaryModel( String name,
                             NetPayModel netPay,
                             DeductPayModel deductPay) {
        this.name       = name;
        this.NetPay     = netPay;
        this.DeductPay  = deductPay;
        this.PayTotal   = NetPay.getNetPayTotal() - DeductPay.getDeductPayTotal();
    }

    // ** Getters **************************************************************************

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public NetPayModel getNetPay() {
        return NetPay;
    }

    public DeductPayModel getDeductPay() {
        return DeductPay;
    }

    public float getPayTotal() {
        return PayTotal;
    }

    // ** Setters **************************************************************************

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetPay(NetPayModel netPay) {
        NetPay = netPay;
    }

    public void setDeductPay(DeductPayModel deductPay) {
        DeductPay = deductPay;
    }

    public void setPayTotal(float payTotal) {
        PayTotal = payTotal;
    }
}
