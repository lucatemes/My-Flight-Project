package pucrs.myflight.modelo;

import java.time.Duration;

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
		double lat1= Math.toRadians(local1.getLatitude());
		double long1= Math.toRadians(local1.getLongitude());
		double lat2= Math.toRadians(local2.getLatitude());
		double long2= Math.toRadians(local2.getLongitude());
		distancia = 2*raioTerra*Math.asin(Math.sqrt(Math.pow(Math.sin (lat1- lat2)/2, 2)+ (Math.pow(Math.sin ((long1 - long2)/2), 2))* Math.cos(lat1) * Math.cos(lat2))); 
		return distancia;
	}

	public double getDistancia(Geo local1){
		double  distancia;
		double raioTerra = 6371;
		distancia = 2*raioTerra*Math.asin(Math.sqrt(Math.pow(Math.sin ((Math.toRadians(local1.getLatitude()) - Math.toRadians(getLatitude()))/2), 2)+ (Math.pow(Math.sin ((local1.getLongitude() - getLongitude())/2), 2))* Math.cos(Math.toRadians(local1.getLongitude())) * Math.cos(Math.toRadians(getLongitude()))));     
		return distancia;
	}

	public long getDuracao (Geo local1, Geo local2){
		double distancia = getDistancia(local1, local2);
		double velocidadeMedia = 805;
		double duracao = (distancia / velocidadeMedia) * 60 + 30;
		return (long) duracao ;
	}
}
