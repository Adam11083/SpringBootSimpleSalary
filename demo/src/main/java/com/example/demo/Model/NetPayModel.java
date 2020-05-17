package com.example.demo.Model;

/*
 * NetPayModel
 * 应发工资数据模型
 */
public class NetPayModel {
    // 应发工资总额
    private float NetPayTotal;
    // 岗位工资
    private float PostWage;
    // 薪级工资
    private float PayWage;
    // 基础性绩效工资
    private float BasicMeritPay;
    // 改革性补贴
    private float RevolutionarySubsidy;
    // 独子费
    private float SingleChildSubsidy;
    // 回族补贴
    private float HuiNationSubsidy;
    // 补发1-3月薪级工资
    private float RetroactivePayWage;
    // 岗位变动补发工资
    private float RetroactivePostChangeWage;
    // 教龄津贴
    private float SeniorityAllowance;

    // ** Default Constructor *****************************************************************
    protected NetPayModel() {};

    // ** Custom Constructor *****************************************************************
    public NetPayModel(float postWage,
                       float payWage,
                       float basicMeritPay,
                       float revolutionarySubsidy,
                       float singleChildSubsidy,
                       float huiNationSubsidy,
                       float retroactivePayWage,
                       float retroactivePostChangeWage,
                       float seniorityAllowance) {

        this.PostWage                   = postWage;
        this.PayWage                    = payWage;
        this.BasicMeritPay              = basicMeritPay;
        this.RevolutionarySubsidy       = revolutionarySubsidy;
        this.SingleChildSubsidy         = singleChildSubsidy;
        this.HuiNationSubsidy           = huiNationSubsidy;
        this.RetroactivePayWage         = retroactivePayWage;
        this.RetroactivePostChangeWage  = retroactivePostChangeWage;
        this.SeniorityAllowance         = seniorityAllowance;
        this.NetPayTotal                = PostWage
                                            + PayWage
                                            + BasicMeritPay
                                            + RevolutionarySubsidy
                                            + SingleChildSubsidy
                                            + HuiNationSubsidy
                                            + RetroactivePayWage
                                            + RetroactivePostChangeWage
                                            + SeniorityAllowance;
    }

    // ** Getters **************************************************************************

    public float getNetPayTotal() {
        return NetPayTotal;
    }

    public float getPostWage() {
        return PostWage;
    }

    public float getPayWage() {
        return PayWage;
    }

    public float getBasicMeritPay() {
        return BasicMeritPay;
    }

    public float getRevolutionarySubsidy() {
        return RevolutionarySubsidy;
    }

    public float getSingleChildSubsidy() {
        return SingleChildSubsidy;
    }

    public float getHuiNationSubsidy() {
        return HuiNationSubsidy;
    }

    public float getRetroactivePayWage() {
        return RetroactivePayWage;
    }

    public float getRetroactivePostChangeWage() {
        return RetroactivePostChangeWage;
    }

    public float getSeniorityAllowance() {
        return SeniorityAllowance;
    }

    // ** Setters **************************************************************************

    public void setNetPayTotal(float netPayTotal) {
        NetPayTotal = netPayTotal;
    }

    public void setPostWage(float postWage) {
        PostWage = postWage;
    }

    public void setPayWage(float payWage) {
        PayWage = payWage;
    }

    public void setBasicMeritPay(float basicMeritPay) {
        BasicMeritPay = basicMeritPay;
    }

    public void setRevolutionarySubsidy(float revolutionarySubsidy) {
        RevolutionarySubsidy = revolutionarySubsidy;
    }

    public void setSingleChildSubsidy(float singleChildSubsidy) {
        SingleChildSubsidy = singleChildSubsidy;
    }

    public void setHuiNationSubsidy(float huiNationSubsidy) {
        HuiNationSubsidy = huiNationSubsidy;
    }

    public void setRetroactivePayWage(float retroactivePayWage) {
        RetroactivePayWage = retroactivePayWage;
    }

    public void setRetroactivePostChangeWage(float retroactivePostChangeWage) {
        RetroactivePostChangeWage = retroactivePostChangeWage;
    }

    public void setSeniorityAllowance(float seniorityAllowance) {
        SeniorityAllowance = seniorityAllowance;
    }
}
