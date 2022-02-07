import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author :Noufal Mc
 * Date :07/02/2022
 * Payroll Services
 */
public class employeePayrollService {
    public enum IOService
    {
        CONSOLE_IO,FILE_IO,DB_IO,REST_IO;
    }
    private List<employeePayroll>employeePayrolls;
    public  employeePayrollService(List<employeePayroll> employeePayrolls)
    {
        this.employeePayrolls=employeePayrolls;
    }
    public static void main(String args[])
    {
        ArrayList<employeePayroll> employeePayrolls=new ArrayList<>();
        employeePayrollService employeePayrollService=new employeePayrollService(employeePayrolls);
        Scanner consoleInputReader=new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writePayrollData();

    }
    private void readEmployeePayrollData(Scanner consoleInputReader)
    {
            System.out.println("Enter Employee Id");
            int id=consoleInputReader.nextInt();
            System.out.println("Enter Employee Name");
            String name=consoleInputReader.next();
            System.out.println("Enter Yor salary");
            Double salary=consoleInputReader.nextDouble();
            employeePayrolls.add(new employeePayroll(id,name,salary));
    }
    private void writePayrollData()
    {
        System.out.println("The added data is"+employeePayrolls);
    }
}
