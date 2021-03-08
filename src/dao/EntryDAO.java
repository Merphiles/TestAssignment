package dao;

import java.util.ArrayList;
import java.util.List;

import databeans.Entry;

public class EntryDAO {
	
	private static final Entry[] ALL_ENTRIES = initEntries();
	
	public Entry read(int id) {
		for(Entry e: ALL_ENTRIES) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	 private static Entry[] initEntries() {
		 List<Entry> cities = new ArrayList<>();
		 
		 Entry e = new Entry();
		 e.setId(cities.size() + 1);
		 e.setCityName("Karagandy");
		 e.setTimeZone("GMT+6");
		 e.setTempurature(-8);
		 cities.add(e);
		 
		 e = new Entry();
		 e.setId(cities.size() + 1);
		 e.setCityName("London");
		 e.setTimeZone("GMT");
		 e.setTempurature(7);
		 cities.add(e);
		 
		 e = new Entry();
		 e.setId(cities.size() + 1);
		 e.setCityName("Tokyo");
		 e.setTimeZone("GMT+9");
		 e.setTempurature(9);
		 cities.add(e);
		 
		return cities.toArray(new Entry[cities.size()]);
	 }
	
}
