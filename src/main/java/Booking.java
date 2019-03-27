public class Booking {

    private Bedroom bookedRoom;
    private int nightsBooked;


    public Booking(Bedroom bookedRoom, int nightsBooked) {
        this.bookedRoom = bookedRoom;
        this.nightsBooked = nightsBooked;
    }

    public int getRoomNumber() {
        return bookedRoom.getNumber();
    }

    public int calculateBill() {
        return this.bookedRoom.getRate() * this.nightsBooked;
    }

}
