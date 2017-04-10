package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "RUNNING_INFORMATION")
public class RunningInformation {

    private final String DBG = "-----> ";

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

    private int heartRate;

    private Date timestamp = new Date();

    public RunningInformation() {
        this.userInfo = null;
    }

    public RunningInformation(String username, String address) {
        System.out.println(DBG + "Inside constructor 1");
        System.out.println(DBG + username);
        System.out.println(DBG + address);

        this.userInfo = new UserInfo(username, address);
    }

    // Deserialize json object and create Java object
    @JsonCreator
    public RunningInformation(
            @JsonProperty("runningId") String runningId,
            @JsonProperty("latitude") String latitude,
            @JsonProperty("longitude") String longitude,
            @JsonProperty("runningDistance") String runningDistance,
            @JsonProperty("totalRunningTime") String totalRunningTime,
            @JsonProperty("heartRate") String heartRate,
            @JsonProperty("timestamp") String timestamp,
            @JsonProperty("userInfo") UserInfo userInfo) {

        this.runningId = runningId;
        this.latitude= Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTIme = Double.parseDouble(totalRunningTime);
        this.heartRate = _getRandomHeartRate(60, 200);
        this.timestamp = new Date();
        this.userInfo = userInfo;

        System.out.println(DBG + this.heartRate);
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

    private int _getRandomHeartRate(int min, int max) {
        Random rn = new Random();
        return min + rn.nextInt(max - min + 1);
    }
}
