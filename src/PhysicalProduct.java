import java.util.Scanner;

public class PhysicalProduct extends Product {
    private String genre;
    private int numberOfDisc;
    private String colorOfDisc;

    public PhysicalProduct() {
        // calls the parent constructor
        super();
        this.genre = "N/A";
        this.numberOfDisc = 0;
        this.colorOfDisc= "N/A";

    }

    public PhysicalProduct(String name, double price, String sku, String genre, int numberOfDisc, String colorOfDisc) {
        // calls the parent constructor
        super(name, price, sku);
        this.genre = genre;
        this.numberOfDisc = numberOfDisc;
        this.colorOfDisc = colorOfDisc;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre ) {
        this.genre = genre;
    }

    public double getNumberOfDisc() {
        return numberOfDisc;
    }

    public void setNumberOfDisc(int numberOfDisc) {
        this.numberOfDisc = numberOfDisc;
    }

    public String getColorOfDisc() {
        return colorOfDisc;
    }

    public void setColorOfDisc(String colorOfDisc) {
        this.colorOfDisc = colorOfDisc;
    }
    public void displayNetPrice() {
        double tax = calculateSaleTax();
        double netPrice = getPrice() + tax;
        System.out.println("Net Price: $" + netPrice);
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Physical Product Genre : " + getGenre());
        System.out.println("Physical Product Number Of Disc : " + getNumberOfDisc() + " Cds");
        System.out.println("Physical Product Color of Disc : " + getColorOfDisc());
    }
    @Override
    public void editDetails() {
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new genre: ");
        String newGenre = scanner.nextLine();
        this.setGenre(newGenre);

        System.out.print("Enter the new number of disc: ");
        int newNumberOfDisc = scanner.nextInt();
        this.setNumberOfDisc(newNumberOfDisc);

        System.out.print("Enter the new color of disc: ");
        scanner.nextLine();
        String newColorOfDisc = scanner.nextLine();
        this.setColorOfDisc(newColorOfDisc);
    }

}
