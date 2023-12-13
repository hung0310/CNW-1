package Model.BO;



import java.util.ArrayList;

import Model.BEAN.Tour;
import Model.DAO.functionDAO;

public class functionBO {
	functionDAO funcDAO = new functionDAO();
	public boolean addTour(String location, String description, String number_day, String filepath) {
		return funcDAO.addTour(location,  description,  number_day,  filepath);
		
	}
	public ArrayList<Tour> getAllTour(){
		return funcDAO.getAllTours();
	}
}
