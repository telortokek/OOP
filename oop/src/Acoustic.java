
public class Acoustic extends Guitar{

	public Acoustic(String amp, String brand, String model, String type, String hybrid, int num) {
		super(amp, brand, model, type, hybrid, num);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int calculatePrice() {
		// TODO Auto-generated method stub
		int base_price;
		if(brand.equals("Yamaha")) {
			base_price = 1500000;
		}else if(brand.equals("Fender")) {
			base_price = 2000000;
		}else {
			base_price = 1000000;
		}
		int total = base_price + (150000*num) + 500000;
		return total;
	}
}
