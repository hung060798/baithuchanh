package Dao;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ManagerProduct {
    static Connection connection;
    static ArrayList<Product> list = new ArrayList<>();
    static {
        connection = ConnectMysql.getConnect();
    }
    public static ArrayList<Product> select() throws SQLException, ClassNotFoundException{
        String select = "select * from product";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString("id"));
            String tensp = resultSet.getString("tensp");
            int gia = Integer.parseInt(resultSet.getString("gia"));
            int soluong = Integer.parseInt(resultSet.getString("soluong"));
            String mausac = resultSet.getString("mausac");
            String mota = resultSet.getString("mota");
            int danhmuc = resultSet.getInt("danhmuc");

            list.add(new Product(id,tensp, gia, soluong, mausac,mota, danhmuc));
        }
        return  list;
    }

    public static void create(Product p) throws SQLException{
        String create = "insert into product(id,tensp,gia,soluong, mausac,mota,danhmuc) value(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1,p.getId());
        preparedStatement.setString(2,p.getTensp());
        preparedStatement.setInt(3, p.getGia());
        preparedStatement.setInt(4,p.getSoluong());
        preparedStatement.setString(5,p.getMausac());
        preparedStatement.setString(6,p.getMota());
        preparedStatement.setInt(7,p.getDanhmuc());

        preparedStatement.execute();
    }

    public static  void edit(Product p) throws SQLException {
        String edit="update product set tensp =? , gia=? , soluong =? ,mausac= ?, mota=?,danhmuc=? where id =?";
        PreparedStatement preparedStatement=connection.prepareStatement(edit);
        preparedStatement.setInt(7,p.getId());
        preparedStatement.setString(1,p.getTensp());
        preparedStatement.setInt(2,p.getGia());
        preparedStatement.setInt(3,p.getSoluong());
        preparedStatement.setString(4,p.getMausac());
        preparedStatement.setString(5,p.getMota());
        preparedStatement.setInt(6,p.getDanhmuc());
        preparedStatement.execute();
    }

    public static void delete(int id) throws SQLException{
        String delete = "delete from product where id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static ArrayList<Product> findByName(String findName) throws SQLException{
        ArrayList<Product> findList = new ArrayList<>();
        String edit = "select * from product where name like '%" + findName + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString("id"));
            String tensp = resultSet.getString("tensp");
            int gia = resultSet.getInt("gia");
            int soluong = resultSet.getInt("soluong");
            String mausac = resultSet.getString("mausac");
            String mota = resultSet.getString("mota");
            int danhmuc = Integer.parseInt(resultSet.getString("danhmuc"));

            findList.add(new Product(id, tensp , gia, soluong, mausac, mota, danhmuc));
        }
        return findList;
    }
}
