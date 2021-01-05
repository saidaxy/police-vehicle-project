package kz.reself.advproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private IncidentStatus incidentStatus;

//    @ElementCollection(targetClass = IncidentType.class)
//    @Enumerated(EnumType.STRING)
//    private Set<IncidentType> incidentType;

    private String address;
    private Integer rank;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "police_user_id")
    private Integer policeUserId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User applicant;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "police_user_id", referencedColumnName = "id")
//    private User policeWorker;
}
