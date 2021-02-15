package com.exercises;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {

    private long accountNumber;
    private String owner;
    private String branch;
    private BigDecimal balance;
    private BigDecimal interestRate;

    public static void main(String[] args) {
        BankAccount td123 = new BankAccount.AccountBuilder(1234L)
                .withOwner("Marge")
                .atBranch("Springfield")
                .openingBalance(new BigDecimal("100"))
                .atRate(new BigDecimal("2.5"))
                .build();

        BankAccount wellsFargo23 = new BankAccount.AccountBuilder(4567L)
                .withOwner("Homer")
                .atBranch("Springfield")
                .openingBalance(new BigDecimal("1000"))
                .atRate(new BigDecimal("27"))
                .build();

        System.out.println(td123);
        td123.setBalance(new BigDecimal("10000.23"));
        System.out.println(td123);
    }

    public static class AccountBuilder {

        private final long accountNumber;
        private String owner;
        private String branch;
        private BigDecimal balance;
        private BigDecimal interestRate;

        public AccountBuilder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public AccountBuilder withOwner(String owner){
            this.owner = owner;
            return this;
        }

        public AccountBuilder atBranch(String branch){
            this.branch = branch;
            return this;
        }

        public AccountBuilder openingBalance(BigDecimal balance){
            this.balance = balance;
            return this;
        }

        public AccountBuilder atRate(BigDecimal interestRate){
            this.interestRate = interestRate;
            return this;
        }

        public BankAccount build(){
            // Here we create the actual bank account object, which is always in a fully
            // initialised state when it's returned. Since the builder is in the
            // BankAccount class, we can invoke its private constructor.
            BankAccount account = new BankAccount();
            account.accountNumber = this.accountNumber;
            account.owner = this.owner;
            account.branch = this.branch;
            account.balance = this.balance;
            account.interestRate = this.interestRate;

            return account;
        }
    }

    // Constructor is now private.
    private BankAccount() {
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber == that.accountNumber &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(branch, that.branch) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(interestRate, that.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, owner, branch, balance, interestRate);
    }

    @Override
    public String toString() {
        return "BankAccountBuilder{" +
                "accountNumber=" + accountNumber +
                ", owner='" + owner + '\'' +
                ", branch='" + branch + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }

}
