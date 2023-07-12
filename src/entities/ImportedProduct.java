package entities;

public class ImportedProduct extends Product{
    Double customsFee;

    public ImportedProduct(String name, double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag(){
        return this.getName() + " $ " + String.format("%.2f", totalPrice()) + "(Customs fee: $" + String.format("%.2f", customsFee) + ")";
    }

    private Double totalPrice() {
        return this.getPrice() + customsFee;
    }
}
