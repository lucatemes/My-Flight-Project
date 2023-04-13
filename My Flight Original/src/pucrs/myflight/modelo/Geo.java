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

	public static double getDistancia(Geo local1, Geo local2){
		double  distancia;
		double raioTerra = 6371;
		distancia = 2*raioTerra*Math.asin(Math.sqrt(Math.pow(Math.sin ((Math.toRadians(local1.getLatitude()) - Math.toRadians(local2.getLatitude()))/2), 2)+ (Math.pow(Math.sin ((local1.getLongitude() - local2.getLongitude())/2), 2))* Math.cos(Math.toRadians(local1.getLongitude())) * Math.cos(Math.toRadians(local2.getLongitude()))));     
		return distancia;
	}

}
