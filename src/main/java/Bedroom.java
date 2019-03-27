import java.util.ArrayList;

public class Bedroom {

    private int number;
    private int capacity;
    private String roomType;
    private ArrayList<Guest> guests;
    private int rate;

    public Bedroom(int number, int capacity, String roomType) {
        this.number = number;
        this.capacity = capacity;
        this.roomType = roomType;
        this.guests = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getGuestCount() {
        return guests.size();
    }

    public void addGuest(Guest newGuest) {
        this.guests.add(newGuest);
    }

    public void removeGuest(Guest oldGuest) {
        this.guests.remove(oldGuest);
    }

    public boolean guestInRoom(Guest guest) {
        return guests.contains(guest);
    }

    public void setRate(int newRate) {
        this.rate = newRate;
    }

    public int getRate() {
        return this.rate;
    }

}

