package foo.bar.service;

import foo.bar.dao.ProductDao;
import foo.bar.model.Desktop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public void addDesktop(Desktop desktop) {
        this.productDao.addDesktop(desktop);
    }

    @Override
    @Transactional
    public void updateDesktop(Desktop desktop) {
        this.productDao.updateDesktop(desktop);
    }

    @Override
    @Transactional
    public void deleteDesktop(Integer id) {
        this.productDao.deleteDesktop(id);
    }

    @Override
    @Transactional
    public Desktop getDesktopById(Integer id) {
        return this.productDao.getDesktopById(id);
    }

    @Override
    @Transactional
    public List<Desktop> listDesktop() {
        return this.productDao.listDesktop();
    }
}
