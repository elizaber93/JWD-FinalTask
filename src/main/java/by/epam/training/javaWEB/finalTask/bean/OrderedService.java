package by.epam.training.javaWEB.finalTask.bean;

import java.util.Objects;

public class OrderedService {
    private int orderId;
    private int serviceId;
    private int executorId;

    public OrderedService() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getExecutorId() {
        return executorId;
    }

    public void setExecutorId(int executorId) {
        this.executorId = executorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedService)) return false;
        OrderedService that = (OrderedService) o;
        return orderId == that.orderId &&
                serviceId == that.serviceId &&
                executorId == that.executorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, serviceId, executorId);
    }

    @Override
    public String toString() {
        return "OrderedService{" +
                "orderId=" + orderId +
                ", serviceId=" + serviceId +
                ", executorId=" + executorId +
                '}';
    }
}
