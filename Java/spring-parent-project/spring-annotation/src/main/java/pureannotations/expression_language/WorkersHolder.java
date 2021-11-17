package pureannotations.expression_language;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component("workersHolder")
public class WorkersHolder {
    private List<String> workers = new LinkedList<>();
    private Map<String, Integer> salaryByWorkers = new HashMap<>();

    public WorkersHolder() {
        workers.add("John");
        workers.add("Susie");
        workers.add("Alex");
        workers.add("George");

        salaryByWorkers.put("John", 35000);
        salaryByWorkers.put("Susie", 47000);
        salaryByWorkers.put("Alex", 12000);
        salaryByWorkers.put("George", 14000);
    }

    @Value("#{workersHolder.salaryByWorkers['John']}") // 35000
    private Integer johnSalary;

    @Value("#{workersHolder.salaryByWorkers['George']}") // 14000
    private Integer georgeSalary;

    @Value("#{workersHolder.salaryByWorkers['Susie']}") // 47000
    private Integer susieSalary;

    @Value("#{workersHolder.workers[0]}") // John
    private String firstWorker;

    @Value("#{workersHolder.workers[3]}") // George
    private String lastWorker;

    @Value("#{workersHolder.workers.size()}") // 4
    private Integer numberOfWorkers;
    //Getters and setters


    public List<String> getWorkers() {
        return workers;
    }

    public void setWorkers(List<String> workers) {
        this.workers = workers;
    }

    public Map<String, Integer> getSalaryByWorkers() {
        return salaryByWorkers;
    }

    public void setSalaryByWorkers(Map<String, Integer> salaryByWorkers) {
        this.salaryByWorkers = salaryByWorkers;
    }

    public Integer getJohnSalary() {
        return johnSalary;
    }

    public void setJohnSalary(Integer johnSalary) {
        this.johnSalary = johnSalary;
    }

    public Integer getGeorgeSalary() {
        return georgeSalary;
    }

    public void setGeorgeSalary(Integer georgeSalary) {
        this.georgeSalary = georgeSalary;
    }

    public Integer getSusieSalary() {
        return susieSalary;
    }

    public void setSusieSalary(Integer susieSalary) {
        this.susieSalary = susieSalary;
    }

    public String getFirstWorker() {
        return firstWorker;
    }

    public void setFirstWorker(String firstWorker) {
        this.firstWorker = firstWorker;
    }

    public String getLastWorker() {
        return lastWorker;
    }

    public void setLastWorker(String lastWorker) {
        this.lastWorker = lastWorker;
    }

    public Integer getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(Integer numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }
}