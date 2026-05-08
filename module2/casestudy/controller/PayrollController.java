package casestudy.controller;

import casestudy.entity.Payroll;
import casestudy.service.IPayrollManager;
import casestudy.service.impl.PayrollService;

import java.util.ArrayList;
import java.util.List;

public class PayrollController {
    private IPayrollManager iPayrollManager = new PayrollService();

    public List<Payroll> getAll(){
        return iPayrollManager.getAll();
    }
    public Payroll getById(int id){
        return iPayrollManager.getById(id);
    }
    public void add(Payroll payroll){
         iPayrollManager.add(payroll);
    }
    public void delete(int id){
         iPayrollManager.delete(id);
    }
    public boolean update(Payroll payroll){
        return iPayrollManager.update(payroll);
    }
}
