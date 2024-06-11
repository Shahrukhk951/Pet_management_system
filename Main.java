import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("", "", "");

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
        LinkedList<User> userList = new LinkedList<>(); // Add this line to create a list of users

        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1) Add Users");
            System.out.println("2) Add Pets");
            System.out.println("3) Adopt Pets");
            System.out.println("4) Search Pets");
            System.out.println("5) Exit");
            System.out.println("6) View Pets");
            System.out.println("7) View Users");
            System.out.println("8) removeUser");
            System.out.println("9) removePets");
            System.out.println("10) Update User");


            try {
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        user.addUsers(sc);
                        break;
                    case 2:
                        user.addPets(sc);
                        break;
                    case 3:
                        user.adoptPets();
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("Enter the pet you want to search for: ");
                        String pet = sc.nextLine();
                        System.out.println(user.binarySearch(petList, pet));
                        break;
                    case 5:
                        exit = true;
                        break;
                    case 6:
                        user.viewPets(petList); // Call the method to view all pets
                        break;
                    case 7:
                        user.viewUsers(userList); // Call the method to view all users
                        break;
                    case 8:
                        sc.nextLine();
                        System.out.println("Enter the username to remove: ");
                        String userToRemove = sc.nextLine();
                        user.removeUser(userList, userToRemove);
                        break;
                    case 9:
                        sc.nextLine();
                        System.out.println("Enter the pet category to remove: ");
                        String petToRemove = sc.nextLine();
                        user.removePet(petList, petToRemove);
                        break;
                    case 10:
                        sc.nextLine();
                        System.out.println("Enter the username to update: ");
                        String userToUpdate = sc.nextLine();
                        System.out.println("Enter the new role (Customer/Admin): ");
                        String newRole = sc.nextLine();
                        user.updateUser(userList, userToUpdate, newRole);
                        break;

                        case 11:
                            user.saveUsersToFile("users.txt");
                            break;
                        case 12:
                            user.loadUsersFromFile("users.txt");
                            break;

                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}

































/*
case 5:
   user.viewPets(); // Call the method to view all pets
    break;
    case 6:
  user.viewUsers(); // Call the method to view all users
    break;
    case 7:
   sc.nextLine(); // Clear the input buffer (for previous integer input)
    System.out.println("Enter the username of the user you want to remove: "); // Prompt the user to enter a username
    String usernameToRemove = sc.nextLine(); // Read the username from the user
   user.removeUser(usernameToRemove); // Call the method to remove a user
     break;
     case 8:
   sc.nextLine(); // Clear the input buffer (for previous integer input)
      System.out.println("Enter the category of the pet you want to remove: "); // Prompt the user to enter a pet category
      String petCategoryToRemove = sc.nextLine(); // Read the pet category from the user
       user.removePet(petCategoryToRemove); // Call the method to remove a pet
      break;
        case 9:
     sc.nextLine(); // Clear the input buffer (for previous integer input)
     System.out.println("Enter the username of the user you want to update: "); // Prompt the user to enter a username
      String usernameToUpdate = sc.nextLine(); // Read the username from the user
     System.out.println("Enter the new username: "); // Prompt the user to enter a new username
     String newUsername = sc.nextLine(); // Read the new username from the user
     System.out.println("Enter the new password: "); // Prompt the user to enter a new password
     String newPassword = sc.nextLine(); // Read the new password from the user
       System.out.println("Enter the new type: "); // Prompt the user to enter a new type
       String newType = sc.nextLine(); // Read the new type from the user
    user.updateUser(usernameToUpdate, newUsername, newPassword, newType); // Call the method to update a user
      break;
        case 10:
       sc.nextLine(); // Clear the input buffer (for previous integer input)
      System.out.println("Enter the category of the pet you want to update: "); // Prompt the user to enter a pet category
      String petCategoryToUpdate = sc.nextLine(); // Read the pet category from the user
       System.out.println("Enter the new category: "); // Prompt the user to enter a new category
       String newCategory = sc.nextLine(); // Read the new category from the user
        user.updatePet(petCategoryToUpdate, newCategory); // Call the method to update a pet
         break;
 */