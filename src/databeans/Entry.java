package databeans;

public class Entry {
	private int id;
	private String cityName;
	private String timeZone;
	private int temperature;
	
	public int getId() { return id; }
	public String getCityName() { return cityName; }
	public String getTimeZone() { return timeZone; }
	public int getTemperature() { return temperature; }
	
	public void setId(int i) { id = i; }
	public void setCityName(String s) { cityName = s; }
	public void setTimeZone(String s) { timeZone = s; }
	public void setTempurature(int i) { temperature = i; }
	
}
