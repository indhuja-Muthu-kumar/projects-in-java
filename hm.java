import java.util.Scanner;

class Hotel {
    Scanner obj = new Scanner(System.in);
    String customerName;
    int roomType;
    int foodBill = 0;
    boolean booked;


    void bookRoom() {

        if (booked) {
            System.out.println("oops!,room is already booked");
            return;
        }
        obj.nextLine();
        System.out.println("enter customer name:");
        customerName = obj.nextLine();

        System.out.println("ROOM TYPES");
        System.out.println("1.STANDARD [Rs.1000");
        System.out.println("2.DELUXE [Rs.2000]");
        System.out.println("3.LUXURY [Rs.3000]");
        System.out.println("4.SUITE [Rs.4000]");

        System.out.println("enter your room type:");
        roomType = obj.nextInt();

        booked = true;
        obj.nextLine();

        System.out.println("room booked successfully");
    }

    void orderFood() {
        if (!booked) {
            System.out.println("book your room first!!");
            return;
        }
        System.out.println("FOOD MENU");
        System.out.println("1.PIZZA----------[Rs.400]");
        System.out.println("2.BURGER---------[Rs.300]");
        System.out.println("3.COFFEE----------[Rs.100]");
        System.out.println("4.MILKSHAKE-------[Rs.180]");

        System.out.println("ENTER YOUR CHOICES:");
        int choice = obj.nextInt();

        System.out.println("ENTER QUANTITY:");
        int qnt = obj.nextInt();

        switch (choice) {
            case 1:
                foodBill = qnt * 400;
                break;
            case 2:
                foodBill = qnt * 300;
                break;
            case 3:
                foodBill = qnt * 100;
                break;
            case 4:
                foodBill = qnt * 180;
                break;
            default:
                System.out.println("INVALID CHOICE");
        }
    }

    void checkout() {
        if (!booked) {
            System.out.println("NO ROOM BOOKED");
            return;
        }
        int roomCharge = 0;
        switch (roomType) {
            case 1:
                roomCharge = 1000;
                break;
            case 2:
                roomCharge = 2000;
                break;
            case 3:
                roomCharge = 3000;
                break;
            case 4:
                roomCharge = 4000;
                break;
        }

        int total = roomCharge + foodBill;

        System.out.println("========bill=======");
        System.out.println("customer name" + customerName);
        System.out.println("room charge" + "Rs." + roomCharge);
        System.out.println("food bill" + "Rs." + foodBill);
        System.out.println("total" + "Rs." + total);

        booked = false;
        customerName = "";
        roomCharge = 0;
        foodBill = 0;
    }


    public static void main(String[] args) {

        Hotel h = new Hotel();

        while (true) {
            System.out.println("\n hotel management");
            System.out.println("1.BOOK ROOM");
            System.out.println("2.ORDER FOOD");
            System.out.println("3.CHECKOUT");
            System.out.println("4.EXIT");

            System.out.println("enter choice:");
            int ch = h.obj.nextInt();
            h.obj.nextLine();

            switch (ch) {
                case 1:
                    h.bookRoom();
                    break;
                case 2:
                    h.orderFood();
                    break;
                case 3:
                    h.checkout();
                    break;
                case 4:
                    System.out.println("THANK YOU!!");
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
}
