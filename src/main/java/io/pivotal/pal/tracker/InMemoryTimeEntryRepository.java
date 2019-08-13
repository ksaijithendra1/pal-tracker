package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    Map<Long,TimeEntry> timeEntryMap = new HashMap<Long,TimeEntry>();
    private long id = 1;

    public TimeEntry find(long id) {
        TimeEntry result = null;
        result = timeEntryMap.get(id);
        return result;
    }

    public List<TimeEntry> list() {
        List<TimeEntry> result = null;
        result = new ArrayList<TimeEntry>(timeEntryMap.values());
        return result;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newTimeEntry = new TimeEntry(id, timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryMap.put(id++,newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if ( false == timeEntryMap.containsKey(id)){
            return null;
        }
        TimeEntry result = null;
        TimeEntry newTimeEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryMap.put(id,newTimeEntry);
        result = find(id);
        return result;
    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }
}
