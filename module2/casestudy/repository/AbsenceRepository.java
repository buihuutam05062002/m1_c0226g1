package casestudy.repository;

import casestudy.entity.Absence;

import java.util.ArrayList;
import java.util.List;

public class AbsenceRepository {
    private List<Absence>absences = new ArrayList<>();


    public List<Absence> getAll(){
        return new ArrayList<>(absences);
    }
    public int countAbsent(int employeeId){
        int count = 0;
        int n = absences.size();
        for(int i =0; i< n;i++){
            if(absences.get(i).getEmployeeId() == employeeId){
                count++;
            }
        }
        return count;
    }



    public List<Absence> getByEmployee(int employeeId){
        List<Absence> temp = absences.stream().filter(e -> e.getId() == employeeId).toList();
        return new ArrayList<>(temp);
    }

    public boolean add(Absence absence){
        return absences.add(absence);
    }
    public boolean delete(int id){
        return absences.removeIf(e ->e.getId() == id);
    }
    public boolean update(Absence absence){
        int n = absences.size();

        for(int i =0 ; i< n;i++){
            if(absence.getId() == absences.get(i).getId() && absence.getEmployeeId() == absences.get(i).getEmployeeId()){
                absences.get(i).setReason(absence.getReason());
                absences.get(i).setStartDate(absence.getStartDate());
                absences.get(i).setEndDate(absence.getEndDate());
                return true;
            }
        }
        return false;
    }
    public Absence getById(int id){
        int n = absences.size();
        for(int i =0 ; i < n ; i++){
            if(absences.get(i).getId() == id){
                return absences.get(i);
            }
        }
        return null;
    }


}
