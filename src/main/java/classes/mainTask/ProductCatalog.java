package classes.mainTask;

import java.util.Arrays;

public class ProductCatalog {
    private final static int SIZE_BY_DEFAULT = 8;
    private Product[] products;
    private int size;

    ProductCatalog(){
        products = new Product[SIZE_BY_DEFAULT];
    }

    ProductCatalog (int capacity){
        products = new Product[capacity];
    }

    ProductCatalog(Product[] products){
        this.products = new Product[products.length];
        for (Product x: products) {
            putProduct(x);
        }
    }

    public Product[] getProducts() {
        return Arrays.copyOf(products, size);
    }

    private void expandArray (){
        Product[] newProducts = new Product[products.length*2];
        System.arraycopy(products,0,newProducts,0,products.length);
        products = newProducts;
    }

    public int putProduct (Product product) {
        if (product == null) return 0;
        for (int i = 0; i < size; i++){
            if (product.getId() == products[i].getId()) {
                products[i] = product;
                return 1;
            }
        }
        if(size == products.length ){
            expandArray();
        }
        products [size++] = product;
        return 1;
    }

    public int delProduct (Product product){
        if (product == null) return 0;
        for (int i = 0; i < size; i++){
            if (product.getId() == products[i].getId()) {
                System.arraycopy(products,i + 1,products,i,size-i-1);
                products[size-1] = null;
                size--;
                return 1;
            }
        }
        return 0;
    }


    public void clearAll(){
        products = new Product[SIZE_BY_DEFAULT];
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public Product[] productListByName (String name){
        Product[] productByName = new Product[size];
        int quantity = 0;
        for (int i = 0; i < size; i++){
            if (name.toLowerCase().equals(products[i].getName().toLowerCase())) {
                productByName[quantity++] = products[i];
            }
        }
        return Arrays.copyOf(productByName, quantity);
    }

    public Product[] productCorrectPrice (String name, double price){
        Product[] productCorrectPrice = new Product[size];
        int quantity = 0;
        for (int i = 0; i < size; i++){
            if (name.toLowerCase().equals(products[i].getName().toLowerCase()) && price >= products[i].getPrice()) {
                productCorrectPrice[quantity++] = products[i];
            }
        }
        return Arrays.copyOf(productCorrectPrice, quantity);
    }

    public Product[] productCorrectSelfLife (int selfLife){
        Product[] productSelfLife = new Product[size];
        int quantity = 0;
        for (int i = 0; i < size; i++){
            if (selfLife < products[i].getSelfLife()) {
                productSelfLife[quantity++] = products[i];
            }
        }
        return Arrays.copyOf(productSelfLife, quantity);
    }

    public void printCatalog(Product[] products) {
        if (products == null) {
            System.out.println("There is no products in catalog!");
            return;
        }
        if (products.length == 0) {
            System.out.println("There is no no matching products!");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }
}



