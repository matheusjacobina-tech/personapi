package bootcamp.personapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessMessageDTO {

    private String message;
}
