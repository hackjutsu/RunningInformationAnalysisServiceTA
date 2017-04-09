package demo.rest;


import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RunningInformationQueryController {
    @Autowired
    private RunningInformationService runningInformationService;

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformationList){
        runningInformationService.saveRunningInformation(runningInformationList);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void purge() {
        runningInformationService.deleteAll();
    }

    @RequestMapping(value = "/running/{heartRate}", method = RequestMethod.GET)
    public Page<RunningInformation> findByHeartRateGreaterThan(
            @PathVariable double heartRate,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size) {
        return this.runningInformationService.findByHeartRateGreaterThan(heartRate, new PageRequest(page, size));
    }
}
