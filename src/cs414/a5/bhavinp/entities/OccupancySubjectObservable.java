package cs414.a5.bhavinp.entities;

public interface OccupancySubjectObservable {

	public void addObserver(OccupancyObserver o);

	public void removeObserver(OccupancyObserver o);

	public void notifyObserver();

}
