package model;

import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;

public class ForecastData implements Subject {
    private ArrayList<Observer> observers;

    private double temperature;
    private int pressure;
    private int humidity;

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public ForecastData(){

        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int observerIndex = observers.indexOf(o);
        if(observerIndex >= 0){
            observers.remove(observerIndex);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).update(temperature, pressure, humidity);
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(double t, int p, int h){
        try{
            if((t != temperature) || (p != pressure) || (h != humidity)){
                this.temperature = t;
                this.pressure = p;
                this.humidity = h;
                measurementsChanged();
            }
        }catch(Exception e){

        }
    }
}
