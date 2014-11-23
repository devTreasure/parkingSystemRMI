package ParkingSystem.Entities;

public interface OccupancySubjectObservable {
	
	public void addObserver(OccupancyObserver o);
	public void removeObserver(OccupancyObserver o);
	public void notifyObserver();
	

}
