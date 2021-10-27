package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.ApplianceFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    private ApplianceFactory applianceFactory;

    public ApplianceDAOImpl() {
        applianceFactory = new ApplianceFactory();
    }

    @Override
    public Appliance find(Criteria criteria) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("appliances_db.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isLineContainsAllSearchCriteria(line, criteria)) {
                    System.out.println(line);
                    return applianceFactory.getAppliance(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // notify user if file not found
        }
        return null;
    }

    private boolean isLineContainsAllSearchCriteria(String line, Criteria criteria) {
        if (!line.startsWith(criteria.getGroupSearchName())) {
            return false;
        }
        for (Map.Entry<String, Object> entry : criteria.getSearchParams().entrySet()) {
            String searchParam = entry.getKey() + "=" + entry.getValue();
            if (!line.contains(searchParam)) {
                return false;
            }
        }
        return true;
    }
}