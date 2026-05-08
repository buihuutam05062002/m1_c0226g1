package casestudy.repository;


import casestudy.entity.Payroll;

import java.util.ArrayList;
import java.util.List;

public class PayrollRepository {
    private List<Payroll> payrolls = new ArrayList<>();

    public List<Payroll> getAll(){
        return new ArrayList<>(payrolls);
    }
    public Payroll getById(int id){
        int n = payrolls.size();
        for(int i = 0 ; i < n;i++){
            if(payrolls.get(i).getId() == id){
                return payrolls.get(i);
            }
        }
        return null;
    }
    public boolean add(Payroll payroll){
        return payrolls.add(payroll);
    }
    public boolean delete(int id){
        int n = payrolls.size();
        for(int i = 0 ; i < n;i++){
            if(payrolls.get(i).getId() == id){
                payrolls.remove(payrolls.get(i));
                return true;
            }
        }
        return false;
    }
    public boolean update(Payroll payroll){
        int n = payrolls.size();
        for(int i = 0 ; i< n;i++){
            if(payrolls.get(i).getId() == payroll.getId() ){
                payrolls.get(i).setEmployeeId(payroll.getEmployeeId());
                payrolls.get(i).setBonus(payroll.getBonus());
                payrolls.get(i).setBaseSalary(payroll.getBaseSalary());
                payrolls.get(i).setGrossSalary(payroll.getGrossSalary());
                payrolls.get(i).setPeriod(payroll.getPeriod());
                return true;
            }
        }
        return false;
    }
}
