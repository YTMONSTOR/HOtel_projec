package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.EmployeeType;

@Data
public class Employeee {
    private Integer id;
    private EmployeeType employeeType;
    private Integer userId;
    private String password;

    public Employeee(Integer id, EmployeeType employeeType, Integer userId, String password) {
        this.id = id;
        this.employeeType = employeeType;
        this.userId = userId;
        this.password = password;
    }

    public Employeee() {
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "id=" + id +
                ", employeeType=" + employeeType +
                ", userId=" + userId +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
