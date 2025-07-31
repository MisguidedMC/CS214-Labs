import java.util.*;

class Caller {
    String name;
    String phone;

    public Caller(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

   @Override
    public String toString() {
        return "Caller Name: " + name + ", Phone: " + phone;
    }
}

public class CallCenterSimulation {
    private static final Queue<Caller> callQueue = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Call Center Menu ---");
            System.out.println("1. New Call");
            System.out.println("2. Attend Next Call");
            System.out.println("3. View Queue");
            System.out.println("4. Hangup call");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt(); scanner.nextLine();

            switch (option) {
                case 1 -> addNewCall();
                case 2 -> attendCall();
                case 3 -> viewQueue();
                case 4 -> callerHangUp();
                case 5 -> {
                    running = false;
                    System.out.println("Shutting down...");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addNewCall() {
        System.out.print("Enter caller's name: ");
        String name = scanner.nextLine();

        // Simulate auto-captured phone
        String phone = "Phone No-" + new Random().nextInt(1000000);
        callQueue.add(new Caller(name, phone));
        System.out.println("Call added to the queue.");
    }

    private static void attendCall() {
        if (callQueue.isEmpty()) {
            System.out.println("No. calls in the queue.");
        } else {
            Caller nextCaller = callQueue.poll();
            System.out.println("Attending call from: " + nextCaller);
        }
    }

    private static void viewQueue() {
        System.out.println("Current callers in queue: " + callQueue.size());
        for (Caller c : callQueue) {
            System.out.println(" - " + c);
        }
    }
    private static void callerHangUp() {
    System.out.print("Enter caller name to remove from queue: ");
    String name = scanner.nextLine();

    boolean found = false;
    Iterator<Caller> it = callQueue.iterator();
    while (it.hasNext()) {
        Caller c = it.next();
        if (c.name.equalsIgnoreCase(name)) {
            it.remove();
            found = true;
            System.out.println("Caller '" + name + "' has been removed from the queue.");
            break;
        }
    }

    if (!found) {
        System.out.println("Caller not found in queue.");
    }
}

}
