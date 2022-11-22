package com.example.register.Service;

import com.example.register.Model.Bank_model;
import com.example.register.Request.Bank_request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Bank_service {
    @Autowired
    com.example.register.Repository.Bank_repo Bank_repo;

    //service method for credit
    public boolean credit(Bank_request obj) throws Exception {
        Bank_model model_obj = new Bank_model();
        String type;
        if (obj.getType().equals(" "))
            throw new Exception("type can't be empty");
        else if (obj.getAcc_no().equals(" "))
            throw new Exception("acc_no can't be empty");
        else if (obj.getAmount() < 0.0)
            throw new Exception("amount can't be empty");
        else if (obj.getType().equals("credit"))
            type = "credit";
        else
            throw new Exception("out of selection");
        model_obj.setAcc_no(obj.getAcc_no());
        model_obj.setAmount(obj.getAmount());
        model_obj.setType(type);
        this.Bank_repo.save(model_obj);
        return true;
    }

    //service method for debit
    public boolean debit(Bank_request obj) throws Exception {
        Bank_model model_obj = new Bank_model();
        String type;
        if (obj.getType().equals(" "))
            throw new Exception("type can't be empty");
        else if (obj.getAcc_no().equals(" "))
            throw new Exception("acc_no can't be empty");
        else if (obj.getAmount() < 0)
            throw new Exception("amount can't be empty");
        else if (obj.getType().equals("debit"))
            type = "debit";
        else
            throw new Exception("out of selection");
        model_obj.setAcc_no(obj.getAcc_no());
        model_obj.setAmount(obj.getAmount());
        model_obj.setType(type);
        this.Bank_repo.save(model_obj);
        return true;
    }

    public List<Bank_model> getuserfromusertable() {
        List<Bank_model> list_obj = this.Bank_repo.findAll(); //the final asnwer will be collection of list
        return list_obj;
    }

    public double getallBalance() {
        List<Bank_model> userList = this.Bank_repo.findAll();//get all the data from the table.
        double total = 0;///init
        for (Bank_model um : userList) {
            total = total + um.getAmount();
        }
        System.out.println("total " + total);
        return total;
    }
    //method for credit balance only
    public double creditbalance() {
        List<Bank_model> obj = this.Bank_repo.getCreditData();
        double total = 0;///init
        for (Bank_model um : obj) {
            total = total + um.getAmount();
        }
        System.out.println("total " + total);
        return total;
    }

    //method for debit balance only
    public double debitbalance() {
        List<Bank_model> obj = this.Bank_repo.getdebittData();
        double total = 0;///init
        for (Bank_model um : obj) {
            total = total + um.getAmount();
        }
        System.out.println("total " + total);
        return total;
    }

    // method for update the balance
    public void updatebalance(){
        this.Bank_repo.updatebalance();
    }

    //method for add and updates amount
    public Double updateamount(Integer id,Double amount) throws Exception{
        Optional<Bank_model> bank=this.Bank_repo.findById(id);
        if(bank.isPresent()){
            Bank_model bank_model=bank.get(); //retrive from the optional
            double final_amount = bank_model.getAmount() + amount;
            this.Bank_repo.updatebalance1(final_amount,id);
            return final_amount ;
        }
        else
            throw  new Exception("account not fount");
    }
}
