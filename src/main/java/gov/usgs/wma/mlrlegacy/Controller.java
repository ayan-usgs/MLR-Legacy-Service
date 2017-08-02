package gov.usgs.wma.mlrlegacy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/monitoringLocations")
public class Controller {
    
    @Autowired
    public MonitoringLocationDao mLDao;
    
    @GetMapping()
    public List<MonitoringLocation> getMonitoringLocations() {
        return mLDao.getByMap(null);
    }
    
    @GetMapping("/{id}")
    public MonitoringLocation getMonitoringLocation(@PathVariable("id") String id) {
        return mLDao.getById(id);
    }
    
    @PostMapping()
    public MonitoringLocation createMonitoringLocation(@RequestBody MonitoringLocation ml) {
        String newId = mLDao.create(ml);
        return mLDao.getById(newId);
    }
    
    @PutMapping("/{id}")
    public MonitoringLocation updateMonitoringLocation(@PathVariable("id") String id, @RequestBody MonitoringLocation ml) {
        ml.setId(id);
        mLDao.update(ml);
        return mLDao.getById(id);
    }
    
}
