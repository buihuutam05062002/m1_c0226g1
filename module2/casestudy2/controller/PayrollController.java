package casestudy2.controller;

import casestudy2.entity.Payroll;
import casestudy2.service.IPayrollService;
import casestudy2.service.impl.PayrollService;

import java.util.List;

public class PayrollController {
    private IPayrollService iPayrollManager = new PayrollService();

    public List<Payroll> getAll() {
        return iPayrollManager.getAll();
    }

    public Payroll getById(int id) {
        return iPayrollManager.getById(id);
    }

    public void add(Payroll payroll) {
        iPayrollManager.add(payroll);
    }

    public void delete(int id) {
        iPayrollManager.delete(id);
    }

    public boolean update(Payroll payroll) {
        return iPayrollManager.update(payroll);
    }
    public List<Payroll> getByEmployee(int id){
        return iPayrollManager.getByEmployee(id);
    }
}
