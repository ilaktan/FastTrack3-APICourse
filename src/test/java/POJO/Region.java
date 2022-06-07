package POJO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {

    @JsonProperty("region_id")
    private int regionId;
    @JsonProperty("region_name")
    private String regionName;
    private List<Link> links;
}
