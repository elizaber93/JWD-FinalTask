package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Article;
import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SQLArticleDAO {
    private int idUser;
    private String title;
    private Timestamp date;
    private String link;

    private final String INSERT_ARTICLE = "";
    private final String DELETE_ARTICLE = "";
    private final String UPDATE_AUTHOR = "";
    private final String UPDATE_TITLE = "";
    private final String UPDATE_LINK = "";
    private final String SELECT_BY_DATE = "";
    private final String SELECT_BY_TITLE = "";
    private final String SELECT_BY_AUTHOR = "";
    private final String SELECT_ALL = "";

    public boolean addArticle(Article article) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(INSERT_ARTICLE,
                article.getIdUser(),
                article.getTitle(),
                article.getDate(),
                article.getLink());
        executor.close();
        return result == 1;
    }

    public boolean deleteArticle(Article article) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(DELETE_ARTICLE, article.getId());
        executor.close();
        return result == 1;
    }

    public List<Article> getBy(Parameter parameter, Object ... value) throws DAOException {

        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        switch (parameter) {
            case AUTHOR:
                resultSet = executor.select(SELECT_BY_AUTHOR, value);
                break;
            case TITLE:
                resultSet = executor.select(SELECT_BY_TITLE, value);
                break;
            case DATE:
                resultSet = executor.select(SELECT_BY_DATE, value);
                break;
            default:
                resultSet = executor.select(SELECT_ALL);
                break;
        }
        List<Article> articleList = convertToList(resultSet);
        executor.close();
        return articleList;
    }

    public List<Article> getArticleList() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_ALL);
        List<Article> articleList = convertToList(resultSet);
        executor.close();
        return articleList;
    }

    public List<Article> convertToList(ResultSet resultSet) {
        List<Article> articleList = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    articleList.add(new Article(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getTimestamp(4),
                            resultSet.getString(5)));
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLServiceDAO.class).info(e.getMessage());
            }
        }
        return articleList;
    }

    public boolean update(Parameter parameter, Article article, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result;
        switch (parameter) {
            case AUTHOR:
                result = executor.update(UPDATE_AUTHOR, value, article.getId());
                break;
            case TITLE:
                result = executor.update(UPDATE_TITLE, value, article.getId());
                break;
            case LINK:
                result = executor.update(UPDATE_LINK, value, article.getId());
                break;
            default: result = 0;
        }
        executor.close();
        return result == 1;
    }

}
