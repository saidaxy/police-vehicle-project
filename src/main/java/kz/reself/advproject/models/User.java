package kz.reself.advproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usrs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private String login;
    private String password;
    private Date birthdayDate;
    private String phone;
    private String address;

    @OneToOne(mappedBy = "applicant")
    private Incident incident;

    @OneToOne(mappedBy = "policeWorker")
    private Incident currentIncident;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name="vehicle_id", referencedColumnName="id")
    private Vehicle vehicle;
}
