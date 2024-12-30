package org.example;

import java.lang.reflect.Field;
import java.sql.*;

public class Requests {

    public static void createTable(Object obj) throws SQLException {
        if (!obj.getClass().isAnnotationPresent(Table.class)) {
            System.out.println("Аннотации у класса нет.");
            return;
        }
        Table table = obj.getClass().getAnnotation(Table.class);
        StringBuilder sql = new StringBuilder("CREATE TABLE " + table.title() + " (");
        StringBuilder sqlDEL = new StringBuilder("DROP TABLE IF EXISTS " + table.title() + ";");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
//            if (!field.isAnnotationPresent(Column.class)) {
//                System.out.println("Произошла ошибка!");
//                return;
//            }
            if (field.isAnnotationPresent(Column.class)) {
                sql.append(field.getName()).append(" ");

                if (field.getType().getSimpleName().equals("int")) {
                    sql.append("INTEGER");
                }
                else if (field.getType().getSimpleName().equals("Date")) {
                    sql.append("DATE");
                }
                else {
                    sql.append("TEXT");
                }
                sql.append(",");
            }
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(");");
        // подключение к БД
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:dataBase.sqlite");
            Statement statement = connection.createStatement();
            statement.execute(sqlDEL.toString());
            statement.execute(sql.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
    public static void insertIntoTable(Object obj) throws SQLException {
        String tableName = obj.getClass().getAnnotation(Table.class).title();
        Field[] fields = obj.getClass().getDeclaredFields(); // получаем все поля класса объекта
        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                query.append(field.getName()).append(",");
            }
        }
        query.deleteCharAt(query.length() - 1).append(") VALUES (");
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                field.setAccessible(true);
                try {
                    query.append("'").append(field.get(obj)).append("',");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        query.deleteCharAt(query.length() - 1).append(")");
        // подключение к БД
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:dataBase.sqlite");
            Statement statement = connection.createStatement();
            statement.execute(query.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
}
