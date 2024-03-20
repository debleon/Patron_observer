import java.util.ArrayList;
import java.util.List;

// Interfaz Observable
interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Interfaz Observer
interface Observer {
    void update();
}

// Servicio de Payment
class PaymentService implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // Método que simula la compra
    public void purchaseCompleted() {
        // Realizar lógica de compra aquí...

        // Notificar a los observadores
        notifyObservers();
    }
}

// Servicio de Carrito de Compras
class ShoppingCartService implements Observer {
    @Override
    public void update() {
        // Lógica para limpiar el carrito de compras
        System.out.println("Limpiando el carrito de compras...");
    }
}

// Servicio de Inventario
class InventoryService implements Observer {
    @Override
    public void update() {
        // Lógica para actualizar el inventario
        System.out.println("Actualizando el inventario...");
    }
}

// Servicio de Usuario
class UserService implements Observer {
    @Override
    public void update() {
        // Lógica para notificar al usuario
        System.out.println("Notificando al usuario...");
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear instancias de los servicios
        PaymentService paymentService = new PaymentService();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        InventoryService inventoryService = new InventoryService();
        UserService userService = new UserService();

        // Agregar observadores al servicio de Payment
        paymentService.addObserver(shoppingCartService);
        paymentService.addObserver(inventoryService);
        paymentService.addObserver(userService);

        // Simular una compra completada
        paymentService.purchaseCompleted();
    }
}
