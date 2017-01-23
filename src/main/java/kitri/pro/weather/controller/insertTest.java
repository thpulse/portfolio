package kitri.pro.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class insertTest {
	@Autowired
	WeatherController weatherController;
	
	static WeatherController staticWeatherController;
	
	@Autowired
	public void setStaticWeatherController(WeatherController weatherController){
		insertTest.staticWeatherController=weatherController;
		staticWeatherController.insert();
	}
	
	public static void main(String[] args) {

	}
}