package kz.sai_ven.advproject.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentDTO {
    private Incident incident;
    private User user;
    private User policyUser;
}
