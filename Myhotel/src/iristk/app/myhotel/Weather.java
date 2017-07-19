package iristk.app.myhotel;

import java.io.IOException;

import org.json.JSONException;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.OpenWeatherMap.Units;

public class Weather {

	OpenWeatherMap owm = new OpenWeatherMap("369ddea27e95cfbc3d130543c4372525");
	
	public String getweather() {
		
		owm.setUnits(Units.METRIC);
		CurrentWeather cw = null;
		try {
			cw = owm.currentWeatherByCityName("Glasgow");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String description = cw.getWeatherInstance(0).getWeatherDescription();
		float temperature = cw.getMainInstance().getTemperature();
		float temmax = cw.getMainInstance().getMaxTemperature();
		float temmin = cw.getMainInstance().getMinTemperature();
		
		String weather = "Today's weather in Glasgow is "+description+". The maximum tempearture is "+temmax+
						 ", the minimum tempearture is "+temmin+" and the current tempearture is "+temperature;
		
		return weather;
	}
		
	
}
