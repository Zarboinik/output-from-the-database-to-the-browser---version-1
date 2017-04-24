package foo.bar.dao;

import foo.bar.model.Desktop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    private static final Logger loger = LoggerFactory.getLogger(ProductDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDesktop(Desktop desktop) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(desktop);
        loger.info("Компьютер успешно сохранен " + desktop);

    }

    @Override
    public void updateDesktop(Desktop desktop) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(desktop);
        loger.info("Компьютер успешно изменен " + desktop);
    }

    @Override
    public void deleteDesktop(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Desktop desktop = (Desktop) session.load(Desktop.class, id);
        if (desktop != null){
            session.delete(desktop);
        }
        loger.info("Компьютер успешно удален " + desktop);
    }

    @Override
    public Desktop getDesktopById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Desktop desktop = (Desktop) session.load(Desktop.class, id);
        loger.info("Компьютер загружен " + desktop);
        return desktop;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Desktop> listDesktop() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Desktop> desktopList = session.createQuery("from Desktop").list();
        for (Desktop desktop : desktopList){
            loger.info("Desktop List: " + desktop);
        }
        return desktopList;
    }
}
