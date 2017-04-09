package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
@RequiredArgsConstructor
public class UserInfo {
    private String username;
    private String address;

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
