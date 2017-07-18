package com.webmyne.rentalapp.model;

import java.io.Serializable;

/**
 * Created by gulamhusen on 18-07-2017.
 */

public class MembershipPlan implements Serializable{

    private String planName, planDuration, planRegistration, planRefundable, planPayable, planDelivery, planDiscount, planTraffic;

    public MembershipPlan(String planName, String planDuration, String planRegistration, String planRefundable, String planPayable, String planDelivery, String planDiscount, String planTraffic) {
        this.planName = planName;
        this.planDuration = planDuration;
        this.planRegistration = planRegistration;
        this.planRefundable = planRefundable;
        this.planPayable = planPayable;
        this.planDelivery = planDelivery;
        this.planDiscount = planDiscount;
        this.planTraffic = planTraffic;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDuration() {
        return planDuration;
    }

    public void setPlanDuration(String planDuration) {
        this.planDuration = planDuration;
    }

    public String getPlanRegistration() {
        return planRegistration;
    }

    public void setPlanRegistration(String planRegistration) {
        this.planRegistration = planRegistration;
    }

    public String getPlanRefundable() {
        return planRefundable;
    }

    public void setPlanRefundable(String planRefundable) {
        this.planRefundable = planRefundable;
    }

    public String getPlanPayable() {
        return planPayable;
    }

    public void setPlanPayable(String planPayable) {
        this.planPayable = planPayable;
    }

    public String getPlanDelivery() {
        return planDelivery;
    }

    public void setPlanDelivery(String planDelivery) {
        this.planDelivery = planDelivery;
    }

    public String getPlanDiscount() {
        return planDiscount;
    }

    public void setPlanDiscount(String planDiscount) {
        this.planDiscount = planDiscount;
    }

    public String getPlanTraffic() {
        return planTraffic;
    }

    public void setPlanTraffic(String planTraffic) {
        this.planTraffic = planTraffic;
    }
}
