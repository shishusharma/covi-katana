package coronaKatanaGov;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicInteger;

public class IdIncrement {
	private AtomicInteger value= new AtomicInteger(0);
	public int increment(Connection con) {
		if(value.get()<1) {
			synchronized (con) {
				if(value.get()==0)value.set(Integer.parseInt(new GovEndPanel().getID(con)));
			}
		}
		return value.incrementAndGet();
	}
}
