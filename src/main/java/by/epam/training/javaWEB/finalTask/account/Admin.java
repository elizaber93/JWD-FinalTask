package by.epam.training.javaWEB.finalTask.account;

import by.epam.training.javaWEB.finalTask.bean.Order;
import by.epam.training.javaWEB.finalTask.bean.OrderedService;
import by.epam.training.javaWEB.finalTask.bean.Supply;
import by.epam.training.javaWEB.finalTask.bean.User;

public interface Admin extends Client {
    void addAdmin(User user);
    void addSupply(Supply supply);
    void assignOrderToServiceStaff(OrderedService orderedService, ServiceStaff executor);
    void assignOrderToCourier(Order order, Courier courier);
}
