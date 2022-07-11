package com.server.reactive.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.GenerationType.SEQUENCE;
@Entity(name="Employee")
@Table
public class Employee extends ActiveAndDateCreated {
    @Id
    @SequenceGenerator(name="employee_sequence",sequenceName = "employee_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "employee_sequence")
    private  int ContractTypeId;
    @Column(name="taxidnumber",nullable = false,columnDefinition = "TEXT")
    private String TaxIdNumber;
    @Column(name="name",nullable = false,columnDefinition = "TEXT")
    private String Name;
    @Column(name="lastname",nullable = false,columnDefinition = "TEXT")
    private String LastName;
    @Temporal(TemporalType.DATE)
    @Column(name="birthdate",nullable = false)
    private Date BirthDate;
    @Column(name="cellphone",nullable = false,columnDefinition = "TEXT")
    private String CellPhone;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Contract> contracts=new ArrayList<>();
}
