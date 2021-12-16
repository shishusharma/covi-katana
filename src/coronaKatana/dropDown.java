package coronaKatana;

public class dropDown {
String id,value;


public dropDown(Integer v, String value) {
	super();
	this.id = String.valueOf(v);
	this.value = value;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}
}
