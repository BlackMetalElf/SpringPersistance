package com.server.reactive.domain.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="Contract")
@Table
public class Contract extends ActiveAndDateCreated{
    @Id
    @SequenceGenerator(name="contract_sequence",sequenceName = "contract_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "contract_sequence")
    private long ContractId;
    @Temporal(TemporalType.DATE)
    @Column(name="datefrom",nullable = false)
    private Date DateFrom;
    @Temporal(TemporalType.DATE)
    @Column(name="dateto",nullable = false)
    private Date DateTo;
    @Column(name="salaryperday",nullable = false,columnDefinition = "DECIMAL")
    private float SalaryPerDay;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="EmployeeId")
    private Employee employee;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ContractTypeId")
    private ContractType contractType;
}
