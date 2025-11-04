package ticket.booking.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNumber;
    private String trainName;
    private Map<String, String> stationTimes;
    private List<List<Integer>> seats;
    private List<String> stations;

    public Train(String trainId, String trainNumber, String trainName, Map<String, String> stationTimes, List<List<Integer>> seats, List<String> stations){
        this.trainId = trainId;
        this.trainNumber = trainNumber;
        this.trainName=trainName;
        this.stationTimes=stationTimes;
        this.seats=seats;
        this.stations=stations;
    }
    public Train(){}

    public String getTrainId() {
        return trainId;
    }
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }
    public String getTrainNumber() {
        return trainNumber;
    }
    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
    public String getTrainName() {
        return trainName;
    }
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
    public Map<String, String> getStationTimes() {
        return stationTimes;
    }
    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }
    public List<List<Integer>> getSeats() {
        return seats;
    }
    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }
    public List<String> getStations() {
        return stations;
    }
    public void setStations(List<String> stations) {
        this.stations = stations;
    }
    public String getTrainInfo(){
        return String.format("Train Id: %s Train No: %s", trainId, trainNumber);
    }
}
