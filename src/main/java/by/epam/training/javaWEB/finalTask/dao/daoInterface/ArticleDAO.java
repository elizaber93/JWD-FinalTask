package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Article;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;

import java.util.List;

public interface ArticleDAO {
    List<Article> getArticleList() throws DAOException;
    List<Article> getBy(Parameter parameter, Object ... value) throws DAOException;
    boolean deleteArticle(Article article) throws DAOException;
    boolean addArticle(Article article) throws DAOException;
    boolean update(Parameter parameter, Article article, Object value) throws DAOException;
}
