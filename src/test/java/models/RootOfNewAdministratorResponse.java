package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RootOfNewAdministratorResponse {

    public NewAdministratorResponse data;
}
