package by.epam.training.javaWEB.finalTask.controller.util;

public enum Page {
    INDEX("index.jsp"),
    LOGIN_REGISTER("/WEB-INF/jsp/login_register.jsp"),
    CONTACT("/WEB-INF/jsp/contact.jsp"),
    ABOUT("/WEB-INF/jsp/about.jsp"),
    ADD_SUPPLIER("/WEB-INF/jsp/add_supplier.jsp"),
    EDIT_PROFILE("/WEB-INF/jsp/edit_profile.jsp"),
    SUPPLIER_LIST("/WEB-INF/jsp/supplier_list.jsp"),
    USER_LIST("/WEB-INF/jsp/user_list.jsp"),
    PRODUCT_LIST("/WEB-INF/jsp/product_list.jsp"),
    ADD_ARTICLE("/WEB-INF/jsp/add_article.jsp"),
    ADD_PRODUCT("/WEB-INF/jsp/add_product.jsp"),
    ADD_SERVICE("/WEB-INF/jsp/add_service.jsp"),
    ADD_SUPPlY("/WEB-INF/jsp/add_supply.jsp"),
    SERVICE_LIST("/WEB-INF/jsp/service_list.jsp");

    private final String path;

    Page(String path) {
        this.path=path;
    }

    public String getPath() {
        return path;
    }
}
