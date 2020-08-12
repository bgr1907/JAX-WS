package client;

import model.Employee;
import ws.EmployeeService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Arrays;

public class ClientTest01 {

    public static void main(String[] args) {
        String address = "http://localhost:8080/JAXWSWeek01Tomcat/employeeServiceWS";

        try{
            URL url = new URL(address);
            QName qName = new QName("http://ws/", "EmployeeServiceImplService");
            Service service = Service.create(url, qName);

            Employee employee = new Employee();
            employee.setId(1);
            employee.setName("Ahmet Buğra");
            employee.setSurname("Karabacak");
            employee.setSalary((double) 6000);

            Employee employee2 = new Employee();
            employee2.setId(1);
            employee2.setName("Cengizhan");
            employee2.setSurname("Aslantaş");
            employee2.setSalary((double) 6000);

            EmployeeService employeeService = service.getPort(EmployeeService.class);
            employeeService.addEmployee(employee);
            employeeService.addEmployee(employee2);

            Employee[] employeesArray = employeeService.getEmployeesWithArray();

            Arrays.stream(employeesArray).forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
