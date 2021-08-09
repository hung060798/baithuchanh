package Service;

import Dao.ManagerProduct;
import Model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> list = new ArrayList<>();
    public ProductService(){
        try {
            list = ManagerProduct.select();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void add(Product p) throws SQLException {
        ManagerProduct.create(p);
        list.add(p);
    }

    public  void edit(Product p, int index) throws SQLException {
        ManagerProduct.edit(p);
        list.set(index, p);
    }

    public void delete(int index) throws SQLException {
        ManagerProduct.delete(list.get(index).getId());
        list.remove(index);
    }

    public Product findById(int id){
        for (Product p : list){
            if (p.getId() == id){
                return p;
            }
        }
        return  null;
    }
    public ArrayList<Product> findByName(String name) throws SQLException {
        return  ManagerProduct.findByName(name);
    }
}
