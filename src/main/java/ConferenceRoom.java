import java.util.ArrayList;

public class ConferenceRoom {

    private String name;
    private int capacity;
    private ArrayList<Guest> guests;


    public ConferenceRoom(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getCapacity() {
        return capacity;
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
}
