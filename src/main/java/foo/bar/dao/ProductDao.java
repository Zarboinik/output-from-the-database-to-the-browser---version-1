package foo.bar.dao;

import foo.bar.model.Desktop;

import java.util.List;

public interface ProductDao {
    public void addDesktop(Desktop desktop);

    public void updateDesktop(Desktop desktop);

    public void deleteDesktop(Integer id);

    public Desktop getDesktopById(Integer id);

    public List<Desktop> listDesktop();
}
