package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "RUNNING_INFORMATION")
public class RunningInformation {

    @Id
    @GeneratedValue
    private Long id;

    // Create an embedded field
    @Embedded
    private final UserInfo userInfo;

    private String runningId;

    private double longitude;
    private double latitude;

    private double runningDistance;
    private double totalRunningTIme;

    private double heartRate;

    private Date timestamp = new Date();

    // Deserialize json object and create Java object
    @JsonCreator
    public RunningInformation(
            @JsonProperty("username") String username,
            @JsonProperty("address") String address) {
        this.userInfo = new UserInfo(username, address);
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getUsername() {
        return this.userInfo == null ? null : this.userInfo.getUsername();
    }

    public String getAddress() {
        return this.userInfo == null ? null : this.userInfo.getAddress();
    }
}
