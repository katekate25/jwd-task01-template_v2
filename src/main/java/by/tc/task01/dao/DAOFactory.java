package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceDAOImpl;

/**
 * DAOFactory
 */
public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	
	private DAOFactory() {}

	/**
	 * GetApplianceDAO
	 *
	 * @return applianceDAO
	 */
	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
