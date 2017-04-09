package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {

    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList);

    public Page<RunningInformation> findByHeartRateGreaterThan(double heartRate, Pageable pageable);

    public Page<RunningInformation> findAllRunningInformationOrderByHeathLevel(Pageable pageable);

    public void deleteAll();
}
