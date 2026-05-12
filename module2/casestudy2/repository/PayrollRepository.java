package casestudy2.repository;


import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;
import casestudy2.entity.Payroll;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class PayrollRepository {
    private List<Payroll> payrolls;
    private String filePath = "src/casestudy2/data/payrolls.csv";


    private static PayrollRepository instance;

    private PayrollRepository() {
        this.payrolls = loadFromFile();
    }

    public static PayrollRepository getInstance() {
        if (instance == null) instance = new PayrollRepository();
        return instance;
    }

    private List<Payroll> loadFromFile() {
        List<Payroll> payrolls1 = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return payrolls1;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Payroll e = lineToPayroll(line);
                if (e != null) payrolls1.add(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return payrolls1;
    }

    private void saveToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Payroll e : payrolls) {
                bufferedWriter.write(payrollToLine(e));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Payroll lineToPayroll(String line) {
        try {
            String[] p = line.split(",");
            Payroll payroll = new Payroll();
            payroll.setId(Integer.parseInt(p[0].trim()));
            payroll.setEmployeeId(Integer.parseInt(p[1].trim()));
            payroll.setBaseSalary(new BigDecimal(p[2].trim()));
            payroll.setBonus(new BigDecimal(p[3].trim()));
            payroll.setPeriod(YearMonth.parse(p[4].trim()));
            payroll.setGrossSalary(new BigDecimal(p[5].trim()));
            payroll.setNetSalary(new BigDecimal(p[6].trim()));

            return payroll;
        } catch (Exception ex) {
            System.out.println("dòng lỗi");
            return null;
        }
    }

    private String payrollToLine(Payroll e) {
        return String.join(",",
                String.valueOf(e.getId()),
                String.valueOf(e.getEmployeeId()),
                e.getBaseSalary().toString(),
                e.getBonus().toString(),
                e.getPeriod().toString(),
                e.getGrossSalary().toString(),
                e.getNetSalary().toString()
        );
    }


    public List<Payroll> getAll() {
        return new ArrayList<>(payrolls);
    }
    public List<Payroll> getByEmployee(int idEmployee){
        int n = payrolls.size();
        List<Payroll> payrolls1  = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(payrolls.get(i).getEmployeeId() == idEmployee){
                payrolls1.add(payrolls.get(i));
            }
        }
        return payrolls1;
    }



    public Payroll getById(int id) {
        int n = payrolls.size();
        for (int i = 0; i < n; i++) {
            if (payrolls.get(i).getId().equals(id)) {
                return payrolls.get(i);
            }
        }
        return null;
    }

    public boolean add(Payroll payroll) {
        boolean added = payrolls.add(payroll);
        if (added) {
            saveToFile();
        }
        return added;
    }

    public boolean delete(int id) {
        boolean delete = payrolls.removeIf(e -> e.getId() == id);
        if (delete) {
            saveToFile();
        }
        return delete;
    }

    public boolean update(Payroll payroll) {
        int n = payrolls.size();
        for (int i = 0; i < n; i++) {
            if (payrolls.get(i).getId().equals(payroll.getId())) {
                payrolls.get(i).setEmployeeId(payroll.getEmployeeId());
                payrolls.get(i).setBonus(payroll.getBonus());
                payrolls.get(i).setBaseSalary(payroll.getBaseSalary());
                payrolls.get(i).setPeriod(payroll.getPeriod());
                payrolls.get(i).setGrossSalary(payroll.getGrossSalary());
                payrolls.get(i).setNetSalary(payroll.getNetSalary());
                saveToFile();
                return true;
            }
        }
        return false;
    }
}
