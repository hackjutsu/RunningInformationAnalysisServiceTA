package demo.service.impl;


import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationServiceImpl implements RunningInformationService {

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationServiceImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList) {
        return runningInformationRepository.save(runningInformationList);
    }

    @Override
    public Page<RunningInformation> findByHeartRateGreaterThan(
            double heartRate,
            Pageable pageable) {
        return runningInformationRepository.findByHeartRateGreaterThan(heartRate, pageable);
    }

    @Override
    public Page<RunningInformation> findAllRunningInformationOrderByHeathLevel(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteAll() {
        runningInformationRepository.deleteAll();
    }
}
