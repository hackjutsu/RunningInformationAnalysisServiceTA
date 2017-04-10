package demo.rest;


import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationQueryController {
    private final String DBG = "-----> ";

    private final String kDefaultPage = "0";
    private final String kDefaultItemPerPage = "30";

    @Autowired
    private RunningInformationService runningInformationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformationList){
        System.out.println(DBG + "The length of the list is " + String.valueOf(runningInformationList.size()));
        runningInformationService.saveRunningInformation(runningInformationList);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void purge() {
        runningInformationService.deleteAll();
    }

    @RequestMapping(value = "/heartRateGreaterThan/{heartRate}", method = RequestMethod.GET)
    public Page<RunningInformation> findByHeartRateGreaterThan(
            @PathVariable Integer heartRate,
            @RequestParam(name = "page", required = false, defaultValue = kDefaultPage) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = kDefaultItemPerPage) Integer size) {

        return this.runningInformationService.findByHeartRateGreaterThan(heartRate, new PageRequest(page, size));
    }

    @RequestMapping(value = "/heartRate/{heartRate}", method = RequestMethod.GET)
    public Page<RunningInformation> findByHeartRate(
            @PathVariable Integer heartRate,
            @RequestParam(name = "page", required = false, defaultValue = kDefaultPage) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = kDefaultItemPerPage) Integer size) {

        return this.runningInformationService.findByHeartRate(heartRate, new PageRequest(page, size));
    }
}
