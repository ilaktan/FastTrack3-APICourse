package POJO;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    private String rel;
    private String href;
}
