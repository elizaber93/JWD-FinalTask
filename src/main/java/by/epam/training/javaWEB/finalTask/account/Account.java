package by.epam.training.javaWEB.finalTask.account;

import by.epam.training.javaWEB.finalTask.bean.Order;
import by.epam.training.javaWEB.finalTask.bean.OrderedService;
import by.epam.training.javaWEB.finalTask.bean.Supply;
import by.epam.training.javaWEB.finalTask.bean.User;

public class Account extends User implements Admin, Client, Courier, ServiceStaff{
    @Override
    public void addAdmin(User user) {

    }

    @Override
    public void addSupply(Supply supply) {

    }

    @Override
    public void assignOrderToServiceStaff(OrderedService orderedService, ServiceStaff executor) {

    }

    @Override
    public void assignOrderToCourier(Order order, Courier courier) {

    }
}
