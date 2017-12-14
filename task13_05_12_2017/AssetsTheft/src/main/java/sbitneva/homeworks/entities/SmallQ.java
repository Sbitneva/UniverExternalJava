package sbitneva.homeworks.entities;

public class SmallQ {
    int n;
    boolean valueSet = false;

    synchronized int get(){
        while(!valueSet){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Get exception - " + e.getMessage());
            }
        }
        System.out.println("gets " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while(valueSet){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Put exception - " + e.getMessage());
            }
        }
        System.out.println("puts " + n);
        this.n = n;
        valueSet = true;
        notify();
    }
}
