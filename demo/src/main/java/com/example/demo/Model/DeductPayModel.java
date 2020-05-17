package com.example.demo.Model;

/*
 * DeductPayModel
 * 应扣费用数据模型
 */
public class DeductPayModel {
    // 应扣费用总额
    private float DeductPayTotal;
    // 补发失业保险
    private float UnemploymentInsurance_Retroactive;
    // 三月失业保险
    private float UnemploymentInsurance_March;
    // 二月个税
    private float IndividualIncomeTax_Feb;
    // 四月公积金
    private float AccumulationFund_April;
    // 四月医疗保险
    private float HealthInsurance_April;
    // 补充医疗保险
    private float HealthInsurance_Additional;
    // 四月养老保险
    private float Pension_April;
    // 四月职业年金
    private float OccupationalPension_April;

    // ** Default Constructor *****************************************************************
    protected  DeductPayModel() {};

    // ** Custom Constructor *****************************************************************
    public DeductPayModel(float unemploymentInsurance_Retroactive,
                          float unemploymentInsurance_March,
                          float individualIncomeTax_Feb,
                          float accumulationFund_April,
                          float healthInsurance_April,
                          float healthInsurance_Additional,
                          float pension_April,
                          float occupationalPension_April) {

        this.UnemploymentInsurance_Retroactive  = unemploymentInsurance_Retroactive;
        this.UnemploymentInsurance_March        = unemploymentInsurance_March;
        this.IndividualIncomeTax_Feb            = individualIncomeTax_Feb;
        this.AccumulationFund_April             = accumulationFund_April;
        this.HealthInsurance_April              = healthInsurance_April;
        this.HealthInsurance_Additional         = healthInsurance_Additional;
        this.Pension_April                      = pension_April;
        this.OccupationalPension_April          = occupationalPension_April;
        this.DeductPayTotal                     = UnemploymentInsurance_Retroactive
                                                    + UnemploymentInsurance_March
                                                    + IndividualIncomeTax_Feb
                                                    + AccumulationFund_April
                                                    + HealthInsurance_April
                                                    + HealthInsurance_Additional
                                                    + Pension_April
                                                    + OccupationalPension_April;
    }

    // ** Getters **************************************************************************

    public float getDeductPayTotal() {
        return DeductPayTotal;
    }

    public float getUnemploymentInsurance_Retroactive() {
        return UnemploymentInsurance_Retroactive;
    }

    public float getUnemploymentInsurance_March() {
        return UnemploymentInsurance_March;
    }

    public float getIndividualIncomeTax_Feb() {
        return IndividualIncomeTax_Feb;
    }

    public float getAccumulationFund_April() {
        return AccumulationFund_April;
    }

    public float getHealthInsurance_April() {
        return HealthInsurance_April;
    }

    public float getHealthInsurance_Additional() {
        return HealthInsurance_Additional;
    }

    public float getPension_April() {
        return Pension_April;
    }

    public float getOccupationalPension_April() {
        return OccupationalPension_April;
    }

    // ** Setters **************************************************************************

    public void setDeductPayTotal(float deductPayTotal) {
        DeductPayTotal = deductPayTotal;
    }

    public void setUnemploymentInsurance_Retroactive(float unemploymentInsurance_Retroactive) {
        UnemploymentInsurance_Retroactive = unemploymentInsurance_Retroactive;
    }

    public void setUnemploymentInsurance_March(float unemploymentInsurance_March) {
        UnemploymentInsurance_March = unemploymentInsurance_March;
    }

    public void setIndividualIncomeTax_Feb(float individualIncomeTax_Feb) {
        IndividualIncomeTax_Feb = individualIncomeTax_Feb;
    }

    public void setAccumulationFund_April(float accumulationFund_April) {
        AccumulationFund_April = accumulationFund_April;
    }

    public void setHealthInsurance_April(float healthInsurance_April) {
        HealthInsurance_April = healthInsurance_April;
    }

    public void setHealthInsurance_Additional(float healthInsurance_Additional) {
        HealthInsurance_Additional = healthInsurance_Additional;
    }

    public void setPension_April(float pension_April) {
        Pension_April = pension_April;
    }

    public void setOccupationalPension_April(float occupationalPension_April) {
        OccupationalPension_April = occupationalPension_April;
    }
}
