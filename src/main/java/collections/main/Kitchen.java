package collections.main;

import collections.main.vegetableTypes.bulbousVegetable.BulbOnion;
import collections.main.vegetableTypes.bulbousVegetable.Garlic;
import collections.main.vegetableTypes.bulbousVegetable.Leek;
import collections.main.vegetableTypes.bulbousVegetable.Shallot;
import collections.main.vegetableTypes.cabbageVegetable.Broccoli;
import collections.main.vegetableTypes.cabbageVegetable.BrusselsSprouts;
import collections.main.vegetableTypes.cabbageVegetable.Cauliflower;
import collections.main.vegetableTypes.melonsVegetable.Cucumber;
import collections.main.vegetableTypes.melonsVegetable.Pumpkin;
import collections.main.vegetableTypes.melonsVegetable.Squash;
import collections.main.vegetableTypes.nightshadeVegetable.ChiliPepper;
import collections.main.vegetableTypes.nightshadeVegetable.Pepper;
import collections.main.vegetableTypes.nightshadeVegetable.Tomato;
import collections.main.vegetableTypes.rootVegetable.Carrot;
import collections.main.vegetableTypes.rootVegetable.Radish;
import collections.main.vegetableTypes.saladVegetable.HeadSalad;
import collections.main.vegetableTypes.saladVegetable.Lettuce;
import collections.main.vegetableTypes.spicyVegetable.Basil;
import collections.main.vegetableTypes.spicyVegetable.Dill;
import collections.main.vegetableTypes.spicyVegetable.Oregano;
import collections.main.vegetableTypes.spicyVegetable.Parsley;
import collections.main.vegetableTypes.tuberVegetable.Potato;
import collections.main.vegetableTypes.tuberVegetable.SweetPotato;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Kitchen {
    private Salad chiefSalad;
    private String chiefName;
    private double chiefWeight = 0.0;
    private String menuNumber;
    private Scanner scanner = new Scanner(System.in);

    private String getChiefName() {
        return chiefName;
    }

    private void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }

    public void mainMenu() {
        System.out.println("< MAIN >");
        inputChiefName();
        System.out.println("Hello " + getChiefName() + ", choose one of the menu items:");
        pintMainMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    loadSalad();
                    createMenu();
                    break;
                case "2":
                    createNewSalad();
                    createMenu();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice, please choose one of the menu items!\n");
            }
            pintMainMenu();
        }
    }

    private void inputChiefName() {
        System.out.println("Input your name:");
        setChiefName(scanner.nextLine());
    }

    private void pintMainMenu() {
        System.out.println("1. Load salad from file;");
        System.out.println("2. Create a new salad;");
        System.out.println("3. Exit");
    }

    private void loadSalad() {
        String vegName;
        double vegWeight;
        String line;
        String fileName = "";
        System.out.println("Enter the file name:");
        while (scanner.hasNextLine()) {
            Scanner scannerForFileName = new Scanner(System.in);
            fileName = scannerForFileName.nextLine();
            if (fileName.length() == 0)
                System.out.println("You didn't enter a file name! Try it again!");
            else break;
        }
        try (Scanner scannerForFile = new Scanner(new FileReader(fileName + ".txt"))) {
            chiefSalad = new Salad(fileName);
            while (scannerForFile.hasNext()) {
                line = scannerForFile.nextLine();
                vegName = line.toLowerCase().substring(0, line.lastIndexOf(" "));
                vegWeight = Double.parseDouble(line.substring(line.lastIndexOf(" ") + 1));
                switch (vegName) {
                    case "bulbonion":
                        chiefSalad.addNewIngredient(new BulbOnion(vegWeight));
                        break;
                    case "garlic":
                        chiefSalad.addNewIngredient(new Garlic(vegWeight));
                        break;
                    case "leek":
                        chiefSalad.addNewIngredient(new Leek(vegWeight));
                        break;
                    case "shallot":
                        chiefSalad.addNewIngredient(new Shallot(vegWeight));
                        break;
                    case "broccoli":
                        chiefSalad.addNewIngredient(new Broccoli(vegWeight));
                        break;
                    case "brusselssprouts":
                        chiefSalad.addNewIngredient(new BrusselsSprouts(vegWeight));
                        break;
                    case "cauliflower":
                        chiefSalad.addNewIngredient(new Cauliflower(vegWeight));
                        break;
                    case "cucumber":
                        chiefSalad.addNewIngredient(new Cucumber(vegWeight));
                        break;
                    case "pumpkin":
                        chiefSalad.addNewIngredient(new Pumpkin(vegWeight));
                        break;
                    case "squash":
                        chiefSalad.addNewIngredient(new Squash(vegWeight));
                        break;
                    case "chiliPepper":
                        chiefSalad.addNewIngredient(new ChiliPepper(vegWeight));
                        break;
                    case "pepper":
                        chiefSalad.addNewIngredient(new Pepper(vegWeight));
                        break;
                    case "tomato":
                        chiefSalad.addNewIngredient(new Tomato(vegWeight));
                        break;
                    case "carrot":
                        chiefSalad.addNewIngredient(new Carrot(vegWeight));
                        break;
                    case "radish":
                        chiefSalad.addNewIngredient(new Radish(vegWeight));
                        break;
                    case "headSalad":
                        chiefSalad.addNewIngredient(new HeadSalad(vegWeight));
                        break;
                    case "lettuce":
                        chiefSalad.addNewIngredient(new Lettuce(vegWeight));
                        break;
                    case "basil":
                        chiefSalad.addNewIngredient(new Basil(vegWeight));
                        break;
                    case "dill":
                        chiefSalad.addNewIngredient(new Dill(vegWeight));
                        break;
                    case "oregano":
                        chiefSalad.addNewIngredient(new Oregano(vegWeight));
                        break;
                    case "parsley":
                        chiefSalad.addNewIngredient(new Parsley(vegWeight));
                        break;
                    case "potato":
                        chiefSalad.addNewIngredient(new Potato(vegWeight));
                        break;
                    case "sweetpotato":
                        chiefSalad.addNewIngredient(new SweetPotato(vegWeight));
                        break;
                    default:
                        System.out.println("There is no " + vegName + " in the list of available vegetableTypes.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The specified file cannot be found.");
            System.exit(0);
        }
    }

    private void createMenu() {
        printShowMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addVegetableToSalad();
                    break;
                case "2":
                    showAllIngredientsOfSalad();
                    break;
                case "3":
                    sortVegetablesInSaladByWeight();
                    break;
                case "4":
                    sortVegetablesInSaladByCalories();
                    break;
                case "5":
                    sortVegetablesInSaladByTotalVegetablesCalories();
                    break;
                case "6":
                    getVegetablesFromSaladInCalorieRang();
                    break;
                case "7":
                    return;
                case "8":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nIncorrect choice");
            }
            printShowMenu();
        }
    }

    private void printShowMenu() {
        System.out.println("\nChoose one of the options:");
        System.out.println("1. Add vegetableTypes to salad;");
        System.out.println("2. Show all ingredients of salad;");
        System.out.println("3. Sort vegetableTypes in salad by weight;");
        System.out.println("4. Sort vegetableTypes in salad by calories;");
        System.out.println("5. Sort vegetableTypes in salad by total vegetableTypes calories;");
        System.out.println("6. Get vegetableTypes from a salad in the calorie range;");
        System.out.println("7. To main menu;");
        System.out.println("8. Exit");
    }

    private void addVegetableToSalad() {
        printAddVegetableToSaladMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    bulbousVegetable();
                    break;
                case "2":
                    cabbageVegetable();
                    break;
                case "3":
                    melonsVegetable();
                    break;
                case "4":
                    nightshadeVegetable();
                    break;
                case "5":
                    rootVegetable();
                    break;
                case "6":
                    saladVegetable();
                    break;
                case "7":
                    spicyVegetable();
                    break;
                case "8":
                    tuberVegetable();
                    break;
                case "9":
                    return;
                case "10":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nIncorrect choice");
            }
            printAddVegetableToSaladMenu();
        }
    }

    private void printAddVegetableToSaladMenu() {
        System.out.println("\nChoose one of the vegetableTypes types:");
        System.out.println("1. BulbousVegetable;");
        System.out.println("2. CabbageVegetable;");
        System.out.println("3. MelonsVegetable;");
        System.out.println("4. NightshadeVegetable;");
        System.out.println("5. RootVegetable;");
        System.out.println("6. SaladVegetable;");
        System.out.println("7. SpicyVegetable;");
        System.out.println("8. TuberVegetable;");
        System.out.println("9. To previous page;");
        System.out.println("10. Exit");
    }

    private void bulbousVegetable() {
        printBulbousVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addBulOnion();
                    break;
                case "2":
                    addGarlic();
                    break;
                case "3":
                    addLeek();
                    break;
                case "4":
                    addShallot();
                    break;
                case "5":
                    return;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nIncorrect choice");
            }
            printBulbousVegetableMenu();
        }
    }

    private void printBulbousVegetableMenu() {
        System.out.println("\nChoose one of the BulbousVegetable:");
        System.out.println("1. BulbOnion");
        System.out.println("2. Garlic");
        System.out.println("3. Leek");
        System.out.println("4. Shallot");
        System.out.println("5. To previous page");
        System.out.println("6. Exit");
    }

    private void addBulOnion() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new BulbOnion(chiefWeight));
    }

    private double checkCorrectnessOfDoubleNumberInput(double inputNumber) {
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                inputNumber = scanner.nextDouble();
                if (inputNumber < 0)
                    System.out.println("Incorrect input data! Try it again!");
                else break;
            } else {
                System.out.println("Incorrect input data! Try it again!");
                scanner.next();
            }
        }
        return inputNumber;
    }

    private void addGarlic() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Garlic(chiefWeight));
    }

    private void addLeek() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Leek(chiefWeight));
    }

    private void addShallot() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Shallot(chiefWeight));
    }

    private void cabbageVegetable() {
        printCabbageVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addBroccoli();
                    break;
                case "2":
                    addBrusselsSprouts();
                    break;
                case "3":
                    addCauliflower();
                    break;
                case "4":
                    return;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nIncorrect choice");
            }
            printCabbageVegetableMenu();
        }
    }

    private void printCabbageVegetableMenu() {
        System.out.println("\nChoose one of the CabbageVegetable:");
        System.out.println("1. Broccoli");
        System.out.println("2. BrusselsSprouts");
        System.out.println("3. Cauliflower");
        System.out.println("4. To previous page");
        System.out.println("5. Exit");
    }

    private void addBroccoli() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Broccoli(chiefWeight));
    }

    private void addBrusselsSprouts() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new BrusselsSprouts(chiefWeight));
    }

    private void addCauliflower() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Cauliflower(chiefWeight));
    }

    private void melonsVegetable() {
        printMelonsVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addCucumber();
                    break;
                case "2":
                    addPumpkin();
                    break;
                case "3":
                    addSquash();
                    break;
                case "4":
                    return;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printMelonsVegetableMenu();
        }
    }

    private void printMelonsVegetableMenu() {
        System.out.println("\nChoose one of the MelonsVegetable:");
        System.out.println("1. Cucumber");
        System.out.println("2. Pumpkin");
        System.out.println("3. Squash");
        System.out.println("4. To previous page");
        System.out.println("5. Exit");
    }

    private void addCucumber() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Cucumber(chiefWeight));
    }

    private void addPumpkin() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Pumpkin(chiefWeight));
    }

    private void addSquash() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Squash(chiefWeight));
    }

    private void nightshadeVegetable() {
        printNightshadeVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addChiliPepper();
                    break;
                case "2":
                    addPepper();
                    break;
                case "3":
                    addTomato();
                    break;
                case "4":
                    return;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printNightshadeVegetableMenu();
        }
    }

    private void printNightshadeVegetableMenu() {
        System.out.println("\nChoose one of the NightshadeVegetable:");
        System.out.println("1. ChiliPepper");
        System.out.println("2. Pepper");
        System.out.println("3. Tomato");
        System.out.println("4. To previous page");
        System.out.println("5. Exit");
    }

    private void addChiliPepper() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new ChiliPepper(chiefWeight));
    }

    private void addPepper() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Pepper(chiefWeight));
    }

    private void addTomato() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Tomato(chiefWeight));
    }

    private void rootVegetable() {
        printRootVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addCarrot();
                    break;
                case "2":
                    addRadish();
                case "3":
                    return;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printRootVegetableMenu();
        }
    }

    private void printRootVegetableMenu() {
        System.out.println("\nChoose one of the RootVegetable:");
        System.out.println("1. Carrot");
        System.out.println("2. Radish");
        System.out.println("3. To previous page");
        System.out.println("4. Exit");
    }

    private void addCarrot() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Carrot(chiefWeight));
    }

    private void addRadish() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Radish(chiefWeight));
    }

    private void saladVegetable() {
        printSaladVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addHeadSalad();
                    break;
                case "2":
                    addLettuce();
                    break;
                case "3":
                    return;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printSaladVegetableMenu();
        }
    }

    private void printSaladVegetableMenu() {
        System.out.println("\nChoose one of the SaladVegetable:");
        System.out.println("1. HeadSalad");
        System.out.println("2. Lettuce");
        System.out.println("3. To previous page");
        System.out.println("4. Exit");
    }

    private void addHeadSalad() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new HeadSalad(chiefWeight));
    }

    private void addLettuce() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Lettuce(chiefWeight));
    }

    private void spicyVegetable() {
        printSpicyVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addBasil();
                    break;
                case "2":
                    addDill();
                    break;
                case "3":
                    addOregano();
                    break;
                case "4":
                    addParsley();
                    break;
                case "5":
                    return;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printSpicyVegetableMenu();
        }

    }

    private void printSpicyVegetableMenu() {
        System.out.println("\nChoose one of the SpicyVegetable:");
        System.out.println("1. Basil;");
        System.out.println("2. Dill;");
        System.out.println("3. Oregano;");
        System.out.println("4. Parsley;");
        System.out.println("5. To previous page;");
        System.out.println("6. Exit.");
    }

    private void addBasil() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Basil(chiefWeight));
    }

    private void addDill() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Dill(chiefWeight));
    }

    private void addOregano() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Oregano(chiefWeight));
    }

    private void addParsley() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Parsley(chiefWeight));
    }

    private void tuberVegetable() {
        printTuberVegetableMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    addPotato();
                    break;
                case "2":
                    addSweetPotato();
                    break;
                case "3":
                    return;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printTuberVegetableMenu();
        }
    }

    private void printTuberVegetableMenu() {
        System.out.println("\nChoose one of the TuberVegetable:");
        System.out.println("1. Potato;");
        System.out.println("2. SweetPotato;");
        System.out.println("3. To previous page;");
        System.out.println("4. Exit.");
    }

    private void addPotato() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new Potato(chiefWeight));
    }

    private void addSweetPotato() {
        System.out.println("Enter the required weight in grams:");
        chiefWeight = checkCorrectnessOfDoubleNumberInput(chiefWeight);
        chiefSalad.addNewIngredient(new SweetPotato(chiefWeight));
    }

    private void showAllIngredientsOfSalad() {
        printShowAllIngredientsOfSaladMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    chiefSalad.showAllIngredient();
                    break;
                case "2":
                    return;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printShowAllIngredientsOfSaladMenu();
        }
    }

    private void printShowAllIngredientsOfSaladMenu() {
        System.out.println("\nChoose one of the options:");
        System.out.println("1. Show all ingredients of salad;");
        System.out.println("2. To previous page;");
        System.out.println("3. Exit");
    }

    private void sortVegetablesInSaladByWeight() {
        printSortVegetablesInSaladByWeightMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    chiefSalad.sortByWeight();
                    break;
                case "2":
                    return;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printSortVegetablesInSaladByWeightMenu();
        }
    }

    private void printSortVegetablesInSaladByWeightMenu() {
        System.out.println("\nChoose one of the options:");
        System.out.println("1. Sort vegetableTypes in salad by weight;");
        System.out.println("2. To previous page;");
        System.out.println("3. Exit");
    }

    private void sortVegetablesInSaladByCalories() {
        printSortVegetablesInSaladByCaloriesMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    chiefSalad.sortByKcal();
                case "2":
                    return;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printSortVegetablesInSaladByCaloriesMenu();
        }
    }

    private void printSortVegetablesInSaladByCaloriesMenu() {
        System.out.println("\nChoose one of the options:");
        System.out.println("1. Sort vegetableTypes in salad by calories;");
        System.out.println("2. To previous page;");
        System.out.println("3. Exit");
    }

    private void sortVegetablesInSaladByTotalVegetablesCalories() {
        printSortVegetablesInSaladByTotalVegetablesCaloriesMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    chiefSalad.sortByTotalVegetableKcal();
                    break;
                case "2":
                    return;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printSortVegetablesInSaladByTotalVegetablesCaloriesMenu();
        }
    }

    private void printSortVegetablesInSaladByTotalVegetablesCaloriesMenu() {
        System.out.println("\nChoose one of the options:");
        System.out.println("1. Sort vegetableTypes in salad by total vegetableTypes calories;");
        System.out.println("2. To previous page;");
        System.out.println("3. Exit");
    }

    private void getVegetablesFromSaladInCalorieRang() {
        printGetVegetablesFromSaladInCalorieRangMenu();
        while (scanner.hasNext()) {
            switch (menuNumber = scanner.next()) {
                case "1":
                    getVegetablesInCalorieRang();
                    break;
                case "2":
                    return;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
            printGetVegetablesFromSaladInCalorieRangMenu();
        }
    }

    private void printGetVegetablesFromSaladInCalorieRangMenu() {
        System.out.println("\nChoose one of the options:");
        System.out.println("1. Get vegetableTypes from a salad in the calorie rang;");
        System.out.println("2. To previous page;");
        System.out.println("3. Exit");
    }

    private void getVegetablesInCalorieRang() {
        double lower = 0.0;
        double upper = 0.0;
        while (scanner.hasNextLine()) {
            System.out.println("Enter the lower limit of calories:");
            lower = checkCorrectnessOfDoubleNumberInput(lower);
            System.out.println("Enter the upper limit of calories:");
            upper = checkCorrectnessOfDoubleNumberInput(upper);
            if (lower > upper)
                System.out.println("Lower limit must be less than the upper! Try it again!");
            else break;
        }
        chiefSalad.findVegetableByKcal(lower, upper);
    }

    private void createNewSalad() {
        String saladName = "";
        System.out.println("< Create a new salad >");
        System.out.println("Input salad name:");
        while (scanner.hasNextLine()) {
            Scanner scannerForNewSalad = new Scanner(System.in);
            saladName = scannerForNewSalad.nextLine();
            if (saladName.length() == 0)
                System.out.println("You didn't enter a salad name! Try it again!");
            else break;
        }
        chiefSalad = new Salad(saladName);
        System.out.println(getChiefName() + ",let's cook salad - " + chiefSalad.getName() + "!");
    }
}