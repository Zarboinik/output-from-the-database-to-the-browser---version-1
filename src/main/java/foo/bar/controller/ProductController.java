package foo.bar.controller;

import foo.bar.model.Desktop;
import foo.bar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listProduct(Model model){
        model.addAttribute("desktop", new Desktop());
        model.addAttribute("listDesktop", this.productService.listDesktop());
        return "products";
    }

    @RequestMapping(value = "products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Desktop desktop){
        if (desktop.getId() == 0){
            this.productService.addDesktop(desktop);
        } else {
            this.productService.updateDesktop(desktop);
        }
        return "redirect:/products";
    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
        this.productService.deleteDesktop(id);
        return "redirect:/products";
    }

    @RequestMapping("/edit{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("Product", this.productService.getDesktopById(id));
        model.addAttribute("ProductList ", this.productService.listDesktop());
        return "products";
    }

    @RequestMapping("/productdata{id}")
    public String productDate(@PathVariable("id") int id, Model model){
        model.addAttribute("Product", this.productService.getDesktopById(id));
        return "productdata";
    }
}
