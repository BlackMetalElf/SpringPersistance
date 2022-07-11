package com.server.reactive.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="ContractType")
@Table
public class ContractType extends ActiveAndDateCreated{
    @Id
    @SequenceGenerator(name="contract_type_sequence",sequenceName = "contract_type_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "contract_type_sequence")
    private Short ContractTypeId;
    @Column(name="name",nullable = false, columnDefinition = "TEXT")
    private String Name;
    @Column(name="description",nullable = true, columnDefinition = "TEXT")
    private String Description;

    public String getName() {
        return Name;
    }

    public ContractType(String name, String description) {
        Name = name;
        Description = description;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ContractType() {
    }
    @OneToMany(cascade= CascadeType.ALL)
    private List<Contract> contracts=new ArrayList<>();
}
