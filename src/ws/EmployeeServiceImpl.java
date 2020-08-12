package ws;

import model.Employee;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@WebService(endpointInterface = "ws.EmployeeService")
public class EmployeeServiceImpl implements ws.EmployeeService {

    public static List<Employee> employeeList = new ArrayList<Employee>();

    @Override
    public void addEmployee(Employee employee) {
        System.out.println("addEmployee is invoked!");
        employeeList.add(employee);
        System.out.println(employee);
    }

    @Override
    public Employee getEmployee(int id) {

        Predicate<Employee> predicate = e -> e.getId() == id;
        return employeeList.stream().filter(predicate).findAny().orElse(null);

    }

    @Override
    public Employee[] getEmployeesWithArray() {
        return employeeList.toArray(new Employee[employeeList.size()]);
    }
}
