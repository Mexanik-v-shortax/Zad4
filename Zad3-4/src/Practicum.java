import java.util.ArrayList;
import java.util.HashMap;
public class Practicum {
    public static void main(String[] args) {
        OrdersManager ordersManager = new OrdersManager();

        ordersManager.printAllOrders();
        System.out.println("Всего заказов на сумму: " + ordersManager.getOrdersSum());

        String maxOrderCustomerName = ordersManager.getMaxOrderCustomerName();
        System.out.println("Самая большая сумма заказов у " + maxOrderCustomerName);
        ordersManager.printCustomerOrders(maxOrderCustomerName);

        ordersManager.removeUnprofitableOrders();
    }
}


    class OrdersManager {
    HashMap<String, ArrayList<Double>> customersOrders;

    public OrdersManager() {
        customersOrders = new HashMap<>();
        ArrayList<Double> orders = new ArrayList<>();
        orders.add(154.43);
        orders.add(5453.98);
        orders.add(8776.65);
        customersOrders.put("Иван И.", orders);

        orders = new ArrayList<>();
        orders.add(25343.54);
        orders.add(420.50);
        customersOrders.put("Ольга С.", orders);

        orders = new ArrayList<>();
        orders.add(325.90);
        customersOrders.put("Александр Т.", orders);

        orders = new ArrayList<>();
        orders.add(253.54);
        orders.add(420.50);
        customersOrders.put("Александр Р.", orders);

        orders = new ArrayList<>();
        orders.add(780.54);
        orders.add(420.50);
        orders.add(36343.54);
        orders.add(2000.50);
        customersOrders.put("Екатерина О.", orders);
    }

    void printAllOrders() {
        for (String name : customersOrders.keySet()) { // цикл должен пройтись по ключам
            System.out.println("Заказы " + name + ":");
            ArrayList<Double> value = customersOrders.get(name);
            System.out.println(value);
        }
    }

    double getOrdersSum() {
        double sum = 0;
        for (ArrayList<Double> orders : customersOrders.values()) { // здесь должен быть обход по значениям
            for (double orderPrice : orders) {
                sum += orderPrice;
            }
        }
        return sum;
    }

    void printCustomerOrders(String customerName) {
        if (customersOrders.containsKey(customerName)) { // проверьте, есть ли указанный ключ в таблице
            System.out.println("Заказы " + customerName + ":");
            System.out.println(customersOrders.get(customerName));
        }
    }

    String getMaxOrderCustomerName() {
        double maxOrder = 0;
        String customerName = "";

        // допишите логику работы метода
        for (String name : customersOrders.keySet()) {
            double sum = 0;
            for (double order : customersOrders.get(name)) {
                sum += order;
            }
            if (sum > maxOrder) {
                maxOrder = sum;
                customerName = name;
            }
        }
        return customerName;
    }

    void removeUnprofitableOrders() {
        ArrayList<String> names = new ArrayList<>(); // создайте список клиентов с заказами меньше 5000

        // наполните список names
        for (String name : customersOrders.keySet()) {
            double ordersSum = 0;
            for (double order : customersOrders.get(name)) {
                ordersSum += order;
            }

            if (ordersSum < 5000) {
                names.add(name);
            }
        }

        for (String name : names) { // удалите из хеш-таблицы тех, чьи расходы строго меньше 5000
            customersOrders.remove(name);
            System.out.println("Клиента " + name + " больше нет в таблице.");
        }
    }
}
