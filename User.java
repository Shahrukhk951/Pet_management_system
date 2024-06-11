import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;


public class User {
    public String username, password, type;
    public LinkedList<String> petList;
    public LinkedList<User> userList;

    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.petList = new LinkedList<>();
        this.userList = new LinkedList<>();
    }

    public void addUsers(Scanner sc) {
        sc.nextLine();
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        boolean asktype = true;
        String type = "";

        while (asktype) {
            System.out.println("Enter Role of Person (Customer/Admin):");
            type = sc.nextLine();

            if (type.equalsIgnoreCase("Customer") || type.equalsIgnoreCase("Admin")) {
                asktype = false;
            } else {
                System.out.println("Please enter a valid role (Customer): ");
            }
        }

        User user = new User(username, password, type);
        userList.add(user);
        System.out.println("Customer has been added!");
    }

    public void addPets(Scanner sc) {
        LinkedList<String> petList = new LinkedList<>();
        sc.nextLine();
        petList.add("1.Persian Cat");
        petList.add("2.Golden Retriever");
        petList.add("3.Parrot");
        petList.add("4.Fish");
        petList.add("5.Rabbit");
        petList.add("6.Hamster");
        petList.add("7.Budgie Bird");
        petList.add("8.Goat");
        petList.add("9.Horse");
        petList.add("10.Cow");
        petList.add("11.Turtle");
        petList.add("12.Bull Dog");
        petList.add("13.German Shepherd");
        petList.add("14.Macaw");
        petList.add("15.GoldFish");
        petList.add("16.Betta Fish");
        petList.add("17.Finch");
        petList.add("18.American Shorthair");
        petList.add("19.Gerbil");
        petList.add("20.Cockatoo");

        System.out.println("Enter Pet Category : ");
        String petCategory = sc.nextLine();
        petList.add(petCategory);
        System.out.println("New Pet Category added in the Shop!\n");
        printList(petList);
    }

    public void adoptPets() {
        Scanner obj = new Scanner(System.in);
        LinkedList<String> petList = new LinkedList<>();
        petList.add("1.Persian Cat");
        petList.add("2.Golden Retriever");
        petList.add("3.Parrot");
        petList.add("4.Fish");
        petList.add("5.Rabbit");
        petList.add("6.Hamster");
        petList.add("7.Budgie Bird");
        petList.add("8.Goat");
        petList.add("9.Horse");
        petList.add("10.Cow");
        petList.add("11.Turtle");
        petList.add("12.Bull Dog");
        petList.add("13.German Shepherd");
        petList.add("14.Macaw");
        petList.add("15.GoldFish");
        petList.add("16.Betta Fish");
        petList.add("17.Finch");
        petList.add("18.American Shorthair");
        petList.add("19.Gerbil");
        petList.add("20.Cockatoo");
        System.out.println("Enter the username who's adopting pet : ");
        String name = obj.nextLine();
        System.out.println("Here are the Pet Categories available in PetShop");
        printList(petList);
        System.out.println("\n\nEnter which Pet Category you want?");
        int petIndex = obj.nextInt();
        if (petIndex >= 1 && petIndex <= 20) {
            deleteNode(petList, petIndex - 1);
        } else {
            System.out.println("Wrong input");
        }
        System.out.println("\n\tPet Category has been Selected by " + name + " successfully!");
        System.out.println("\n\tIt is a great choice as a Pet!");
        System.out.println("Updated List of Pets available: ");
        printList(petList);
    }

    public String binarySearch(LinkedList<String> petList, String str) {
        LinkedList<String> availablePets = new LinkedList<>();
        availablePets.sort(String::compareToIgnoreCase);

        petList.add("1.Persian Cat");
        petList.add("2.Golden Retriever");
        petList.add("3.Parrot");
        petList.add("4.Fish");
        petList.add("5.Rabbit");
        petList.add("6.Hamster");
        petList.add("7.Budgie Bird");
        petList.add("8.Goat");
        petList.add("9.Horse");
        petList.add("10.Cow");
        petList.add("11.Turtle");
        petList.add("12.Bull Dog");
        petList.add("13.German Shepherd");
        petList.add("14.Macaw");
        petList.add("15.GoldFish");
        petList.add("16.Betta Fish");
        petList.add("17.Finch");
        petList.add("18.American Shorthair");
        petList.add("19.Gerbil");
        petList.add("20.Cockatoo");

        int low = 0;
        int high = petList.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = petList.get(mid).compareTo(str);

            if (cmp == 0) {
                return str + " is available in the shop.";
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return str + " is not available in the shop.";
    }


    public void printList(LinkedList<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public void deleteNode(LinkedList<String> list, int position) {
        if (position >= 0 && position < list.size()) {
            list.remove(position);
        }
    }

    public void viewPets(LinkedList<String> petList) {
        System.out.println("Available Pet Categories:");
        printList(petList);
    }

    public void viewUsers(LinkedList<User> userList) {
        System.out.println("Existing Users:");
        for (User user : userList) {
            System.out.println("Username: " + user.username + ", Role: " + user.type);
        }
    }

    public void removeUser(LinkedList<User> userList, String username) {
        for (User user : userList) {
            if (user.username.equals(username)) {
                userList.remove(user);
                System.out.println("User " + username + " removed successfully.");
                return;
            }
        }
        System.out.println("User " + username + " not found.");
    }

    public void removePet(LinkedList<String> petList, String petCategory) {
        if (petList.remove(petCategory)) {
            System.out.println("Pet category " + petCategory + " removed successfully.");
        } else {
            System.out.println("Pet category " + petCategory + " not found.");
        }
    }

    public void updateUser(LinkedList<User> userList, String username, String newRole) {
        for (User user : userList) {
            if (user.username.equals(username)) {
                user.type = newRole;
                System.out.println("User " + username + " role updated to " + newRole + " successfully.");
                return;
            }
        }
        System.out.println("User " + username + " not found.");
    }
    // Method to save users to a file
    public void saveUsersToFile(String filename) {
        try (FileWriter fileWriter = new FileWriter(filename);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (User user : userList) {
                bufferedWriter.write(user.username + "," + user.password + "," + user.type + "\n");
            }
            System.out.println("User data saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error occurred while saving users to file: " + e.getMessage());
        }
    }

    // Method to load users from a file
    public void loadUsersFromFile(String filename) {
        userList.clear(); // Clear the existing userList before loading from file
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    userList.add(new User(userData[0], userData[1], userData[2]));
                }
            }
            System.out.println("User data loaded from file: " + filename);
        } catch (IOException e) {
            System.out.println("Error occurred while loading users from file: " + e.getMessage());
        }
    }
}
























/*
public class User { // Declare a public class named User
    public String username, password, type; // Declare public String variables for username, password, and type
    private LinkedList<User> userList; // Declare a LinkedList to hold the users
    private LinkedList<String> petList; // Declare a LinkedList to hold the pets

    public User(String username, String password, String type) { // Constructor for the User class
        this.username = username; // Initialize the username with the passed value
        this.password = password; // Initialize the password with the passed value
        this.type = type; // Initialize the type with the passed value
        this.userList = new LinkedList<>(); // Initialize the userList LinkedList
        this.petList = new LinkedList<>(); // Initialize the petList LinkedList
    }
     public void viewPets() { // Method to view all pets
        // Print the header for the pet table
        System.out.println("Pet Category");
        // Iterate through the list of pets
        for (String pet : petList) {
            // Print the category of each pet
            System.out.println(pet);
        }
    }
       //Time complexity: O(n)
//Space complexity: O(1)
    public void viewUsers() { // Method to view all users
        // Print the header for the user table
        System.out.println("Username\tPassword\tType");
        // Iterate through the list of users
        for (User user : userList) {
            // Print the details of each user
            System.out.println(user.username + "\t" + user.password + "\t" + user.type);
        }
    }
       // Time complexity: O(n)
// Space complexity: O(1)
    public void removeUser(String username) {
        // Traverse the list of users
        for (int i = 0; i < userList.size(); i++) {
            // If the username matches the username of a user in the list
            if (userList.get(i).username.equals(username)) {
                // Remove the user from the list
                userList.remove(i);
                System.out.println("User removed successfully!");
                return;
            }
        }
        // If the username is not found in the list
        System.out.println("User not found!");
    }
    // Time complexity: O(n)
// Space complexity: O(1)
    public void removePet(String petCategory) {
        // Traverse the list of pets
        for (int i = 0; i < petList.size(); i++) {
            // If the pet category matches the category of a pet in the list
            if (petList.get(i).equals(petCategory)) {
                // Remove the pet from the list
                petList.remove(i);
                System.out.println("Pet removed successfully!");
                return;
            }
        }
        // If the pet category is not found in the list
        System.out.println("Pet not found!");
    }
    // Time complexity: O(n)
// Space complexity: O(1)
    public void updateUser(String username, String newUsername, String newPassword, String newType) {
        // Traverse the list of users
        for (User user : userList) {
            // If the username matches the username of a user in the list
            if (user.username.equals(username)) {
                // Update the user's information
                user.username = newUsername;
                user.password = newPassword;
                user.type = newType;
                System.out.println("User information updated successfully!");
                return;
            }
        }
        // If the username is not found in the list
        System.out.println("User not found!");
    }
    // Time complexity: O(n)
// Space complexity: O(1)
    public void updatePet(String petCategory, String newCategory) {
        // Traverse the list of pets
        for (int i = 0; i < petList.size(); i++) {
            // If the pet category matches the category of a pet in the list
            if (petList.get(i).equals(petCategory)) {
                // Update the pet's category
                petList.set(i, newCategory);
                System.out.println("Pet information updated successfully!");
                return;
            }
        }
        // If the pet category is not found in the list
        System.out.println("Pet not found!");
    }
 */