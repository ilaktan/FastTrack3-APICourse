package POJO;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Jobs {

    @JsonProperty("job_id")
    private String jobId;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("min_salary")
    private int minSalary;

    @JsonProperty("max_salary")
    private int maxSalary;

    private List<Link> links;


}
