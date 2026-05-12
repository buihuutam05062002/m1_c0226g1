package casestudy2.repository;

import casestudy2.entity.Absence;
import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;

import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class AbsenceRepository {
    private List<Absence> absences;
    private String filePath = "src/casestudy2/data/absences.csv";


    private static AbsenceRepository instance;

    public static AbsenceRepository getInstance() {
        if (instance == null) {
            instance = new AbsenceRepository();
        }
        return instance;
    }

    public AbsenceRepository() {
        this.absences = loadFromFile();

    }

    private List<Absence> loadFromFile() {
        List<Absence> absenceList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return absenceList;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Absence e = lineToAbsence(line);
                if (e != null) absenceList.add(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return absenceList;
    }

    private void saveToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Absence e : absences) {
                bufferedWriter.write(absenceToLine(e));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Absence lineToAbsence(String line) {
        try {
            String[] p = line.split(",");
            Absence absence = new Absence();
            absence.setId(Integer.parseInt(p[0].trim()));
            absence.setEmployeeId(Integer.parseInt(p[1].trim()));
            absence.setStartDate(LocalDate.parse(p[2].trim()));
            absence.setEndDate(LocalDate.parse(p[3].trim()));
            absence.setReason(p[4].trim());

            return absence;
        } catch (Exception ex) {
            System.out.println("dòng lỗi");
            return null;
        }
    }

    private String absenceToLine(Absence absence) {
        return String.join(",", String.valueOf(absence.getId()), String.valueOf(absence.getEmployeeId()), absence.getStartDate().toString(), absence.getEndDate().toString(), absence.getReason());
    }


    public List<Absence> getAll() {
        return new ArrayList<>(absences);
    }

    public int countAbsent(int employeeId, YearMonth period) {
        int count = 0;
        int n = absences.size();
        for (int i = 0; i < n; i++) {
            if (absences.get(i).getEmployeeId() == employeeId) {

                LocalDate start = absences.get(i).getStartDate().isBefore(period.atDay(1))
                        ? period.atDay(1) : absences.get(i).getStartDate();
                LocalDate end = absences.get(i).getEndDate().isAfter(period.atEndOfMonth())
                        ? period.atEndOfMonth() : absences.get(i).getEndDate();
                if (!start.isAfter(end)) {
                    count += (int) ChronoUnit.DAYS.between(start, end) + 1;
                }
            }
        }
        return count;
    }


    public List<Absence> getByEmployee(int employeeId) {
        List<Absence> temp = absences.stream().filter(e -> e.getEmployeeId() == employeeId).toList();
        return new ArrayList<>(temp);
    }

    public boolean add(Absence absence) {

        boolean added = absences.add(absence);
        if (added) {
            saveToFile();
        }
        return added;
    }

    public boolean delete(int id) {

        boolean delete = absences.removeIf(e -> e.getId() == id);
        if (delete) {
            saveToFile();
        }
        return delete;
    }

    public boolean update(Absence absence) {
        int n = absences.size();

        for (int i = 0; i < n; i++) {
            if (absence.getId() == absences.get(i).getId() && absence.getEmployeeId() == absences.get(i).getEmployeeId()) {
                absences.get(i).setReason(absence.getReason());
                absences.get(i).setStartDate(absence.getStartDate());
                absences.get(i).setEndDate(absence.getEndDate());
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public Absence getById(int id) {
        int n = absences.size();
        for (int i = 0; i < n; i++) {
            if (absences.get(i).getId() == id) {
                return absences.get(i);
            }
        }
        return null;
    }


}
