package org.training.oops.encapsulation;

public class CalculateSimpleInterest {
    private int principal, time, rate, interest;
    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getInterest() {
        calculateSimpleInterest();
        return interest;
    }

    private void calculateSimpleInterest() {
        interest = (principal * rate * time) / 100;
    }
}
