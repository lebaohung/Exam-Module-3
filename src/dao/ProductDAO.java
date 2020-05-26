package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String select_all_product = "select * from product";
    private static final String insert_product = "insert into product " +
            "(name, price, quantity, color, descr, cateId) values " + "(?, ?, ?, ?, ?, ?)";
    private static final String select_product_by_id = "select * from product where id = ?";
//    private static final String update_product_by_id = "update product set name = ?, price = ?, quantity = ?, color = ?, descr = ?, cateid = ?";
    private final String delete_product = "DELETE FROM product WHERE productId = ?";
    private final String update_product = "UPDATE product SET name = ?, price = ?, quantity = ?, color = ?, descr = ?, cateId = ? WHERE productId = ?;";

    Connection connection = JbdcConnection.getConnection();

    public ProductDAO() {
    }


    @Override
    public void insertProduct(Product procduct) {
        Connection connection = JbdcConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_product);
//            preparedStatement.setInt(1, procduct.getProductId());
            preparedStatement.setString(1, procduct.getName());
            preparedStatement.setFloat(2, procduct.getPrice());
            preparedStatement.setInt(3, procduct.getQuantity());
            preparedStatement.setString(4, procduct.getColor());
            preparedStatement.setString(5, procduct.getDescr() );
            preparedStatement.setInt(6, procduct.getCateId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int productId) {
        Product product = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select_product_by_id);
            preparedStatement.setInt(1, productId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("dd");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String descr = rs.getString("descr");
                int cateId = rs.getInt("cateId");

                product = new Product(productId, name, price, quantity, color, descr, cateId);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> procductList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select_all_product);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("productId");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String descr = rs.getString("descr");
                int cateId = rs.getInt("cateId");

                procductList.add(new Product(productId, name, price, quantity, color, descr, cateId));
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return  procductList;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDelete;
        try(
            PreparedStatement preparedStatement = connection.prepareStatement(delete_product);) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdate = false;
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(update_product);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescr());
            preparedStatement.setInt(6, product.getCateId());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
