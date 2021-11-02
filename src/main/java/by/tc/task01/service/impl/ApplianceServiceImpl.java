package by.tc.task01.service.impl;

import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;


public class ApplianceServiceImpl implements ApplianceService
{
	private final ApplianceDAO applianceDAO;

	public ApplianceServiceImpl()
	{
		DAOFactory factory = DAOFactory.getInstance();
		applianceDAO = factory.getApplianceDAO();
	}

	@Override
	public List<Appliance> find(Criteria criteria)
	{
		Validator.validateCriteria(criteria);
		return applianceDAO.find(criteria);
	}

}
