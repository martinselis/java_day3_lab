import java.util.ArrayList;

public class Hotel {

    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Bedroom> bedrooms;

    public Hotel(ArrayList<ConferenceRoom> conferenceRooms, ArrayList<Bedroom> bedrooms) {
        this.conferenceRooms = conferenceRooms;
        this.bedrooms = bedrooms;
    }

    public int getConferenceRoomCount() {
        return conferenceRooms.size();
    }

    public int getBedroomCount() {
        return bedrooms.size();
    }

    public void checkIn(Guest guestToCheckIn, String roomType) {
        if (roomType == "conference room") {
            conferenceRooms.get(0).addGuest(guestToCheckIn);
        } else if (roomType == "bedroom") {
            getVacantBedrooms().get(0).addGuest(guestToCheckIn);
        }
    }

    public void checkOut(Guest guestLeaving) {
        for (int i = 0; i < getConferenceRoomCount()-1; i++) {
            if (bedrooms.get(i).guestInRoom(guestLeaving)) {
                bedrooms.get(i).removeGuest(guestLeaving);
                return;
            }
        }

        for (int i = 0; i < getBedroomCount(); i++) {
            if (conferenceRooms.get(i).guestInRoom(guestLeaving)) {
                conferenceRooms.get(i).removeGuest(guestLeaving);
                return;
            }
        }
    }

    public Booking bookRoom(Bedroom bedroomToBook, int nights) {
        Booking booking = new Booking(bedroomToBook, 5);
        return booking;
    }

    public ArrayList<Bedroom> getVacantBedrooms() {
        ArrayList<Bedroom> vacantBedrooms = new ArrayList<>();
        for (Bedroom roomToCheck : bedrooms) {
            if (roomToCheck.getGuestCount() == 0) {
                vacantBedrooms.add(roomToCheck);
            }
        }
        return vacantBedrooms;
    }


}
