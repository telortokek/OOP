
public abstract class Guitar {

	private String amp,model,type,hybrid;
	protected String brand;
	int num;
	public String getAmp() {
		return amp;
	}
	public void setAmp(String amp) {
		this.amp = amp;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHybrid() {
		return hybrid;
	}
	public void setHybrid(String hybrid) {
		this.hybrid = hybrid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Guitar(String amp, String brand, String model, String type, String hybrid, int num) {
		super();
		this.amp = amp;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.hybrid = hybrid;
		this.num = num;
	}
	public abstract int calculatePrice();
}
