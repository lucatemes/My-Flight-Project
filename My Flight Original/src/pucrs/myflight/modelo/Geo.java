package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public static double getDistancia(double latitude1, double latitude2, double longitude1, double longitude2){
		double  distancia;
		double raioTerra = 6371;
		distancia = 2*raioTerra*Math.asin(Math.sqrt(Math.pow(Math.sin ((Math.toRadians(latitude1) - Math.toRadians(latitude2))/2), 2)+ (Math.pow(Math.sin ((longitude1 - longitude2)/2), 2))* Math.cos(Math.toRadians(longitude1)) * Math.cos(Math.toRadians(longitude2))));     
		return distancia;
	}

}
