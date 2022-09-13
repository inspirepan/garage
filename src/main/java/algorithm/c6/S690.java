package algorithm.c6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (var em : employees) {
            map.put(em.id, em);
        }
        return helper(id, map);
    }

    private int helper(int id, Map<Integer, Employee> map) {
        Employee curr = map.get(id);
        int t = curr.importance;
        for (int subId : curr.subordinates) {
            t += helper(subId, map);
        }
        return t;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
