package util;
import org.openqa.selenium.WebElement;

import java.util.Random;
import java.util.List;;
public class Utilities {



    //1- Function for Generate Random Data for register
        public static String[] generateRandomRegisterData() {
            String[] userData = new String[6];
            // Random object for generating random values
            Random rand = new Random();
            // Array of first names
            String[] firstNames = {"John", "Jane", "David", "Emily", "Michael", "Sarah", "Christopher", "Jessica"};
            // Array of last names
            String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis"};
            // Generate random first name
            userData[0] = firstNames[rand.nextInt(firstNames.length)];
            // Generate random last name
            userData[1] = lastNames[rand.nextInt(lastNames.length)];
            // Generate timestamp-based unique identifier (example)
            long timestamp = System.currentTimeMillis();
            String uniqueId = String.valueOf(timestamp); // or use a random number generator

            // Generate email address with unique identifier
            userData[2] = userData[0].toLowerCase() + "." + userData[1].toLowerCase() + "+" + uniqueId + "@example.com";
            // Generate random phone number (11 digits starting with 011, 010, 012, or 015)
            String[] prefixes = {"011", "010", "012", "015"};
            String prefix = prefixes[rand.nextInt(prefixes.length)];
            userData[3] = prefix + String.format("%08d", rand.nextInt(100000000));
            // Generate random password (8 characters)
            userData[4] = generateRandomPassword(8);
            // Confirm password (same as generated password)
            userData[5] = userData[4];
            return userData;
        }

        private static String generateRandomPassword(int length) {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random rand = new Random();
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                password.append(chars.charAt(rand.nextInt(chars.length())));
            }
            return password.toString();
        }


        // 2- Function for Select random radio button when user register


    public class RadioButtonSelector {

        public static int selectRandomRadioButtonIndex(List<WebElement> radioButtons) {
            if (radioButtons.isEmpty()) {
                throw new RuntimeException("No radio buttons found.");
            }
            Random rand = new Random();
            return rand.nextInt(radioButtons.size());
        }
    }

    // 3- Function for Search with random known value
    // Method to generate a random search value
    public static String getRandomSearchValue() {
        // Define the array of search values
        String[] searchValues = {"MacBook", "iPhone", "iPod Touch", "iPod Classic"};

        // Create a Random object
        Random random = new Random();

        // Generate a random index from 0 to the length of the array - 1
        int randomIndex = random.nextInt(searchValues.length);

        // Return the value at the randomly selected index
        return searchValues[randomIndex];
    }

    //4-   RandomCategoryGenerator the main tabs

    public static String RandomCategoryGeneratorMainTabs() {
        String[] categories = {"Desktops", "Components", "Laptops & Notebooks","Tablets","Software","Phones & PDAs","Cameras","MP3 Players"};
        Random random = new Random();
        int randomIndex = random.nextInt(categories.length);
        return categories[randomIndex];
    }




    //5-   RandomCategoryGenerator Desktops or  Components or Laptops & Notebooks

        public static String RandomCategoryGenerator() {
            String[] categories = {"Desktops", "Components", "Laptops & Notebooks"};
            Random random = new Random();
            int randomIndex = random.nextInt(categories.length);
            return categories[randomIndex];
        }





      //6-  RandomMethodsForBillingDetails
        // Arrays for random selection of names, companies, cities, etc.
        private static final String[] FIRST_NAMES = {"John", "Alice", "Robert", "Jessica", "Michael", "Sarah", "David", "Emily"};
        private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Williams", "Jones", "Garcia", "Miller", "Davis"};
        private static final String[] COMPANIES = {"TechCorp", "InnoSolutions", "Webify", "DataMasters", "CloudSphere", "FastTrack", "CodeCraft", "Visionary"};
        private static final String[] CITIES = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "San Diego", "Austin", "Dallas"};
        private static final Random random = new Random();

        // Method to get a random first name
        public static String getFirstName() {
            return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        }

        // Method to get a random last name
        public static String getLastName() {
            return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        }

        // Method to get a random company
        public static String getCompany() {
            return COMPANIES[random.nextInt(COMPANIES.length)];
        }

        // Method to get a random address
        public static String getAddress() {
            return (random.nextInt(900) + 100) + " " + getRandomStreetName() + " St";
        }
        // Helper method to get a random street name
        public static String getRandomStreetName() {
            String[] streetNames = {"Main", "Oak", "Pine", "Maple", "Elm", "Cedar", "Washington", "2nd"};
            return streetNames[random.nextInt(streetNames.length)];
        }
        // Method to get a random city
        public static String getCity() {
            return CITIES[random.nextInt(CITIES.length)];
        }
        // Method to get a random postal code
        public static String getPostCode() {
            return String.format("%05d", random.nextInt(100000));
        }



        //7- Generate random comments for delivery methods


    // Method to generate random text with a specific length
    public static String generateRandomText(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        StringBuilder randomText = new StringBuilder();
        Random random = new Random();

        // Generate random text of the specified length
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomText.append(characters.charAt(randomIndex));
        }

        return randomText.toString();
    }

    // Overloaded method to generate random text with a default length (e.g., 20 characters)
    public static String generateRandomText() {
        return generateRandomText(20); // Default length of 20 characters
    }




}

